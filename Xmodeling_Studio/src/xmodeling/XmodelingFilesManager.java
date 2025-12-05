package xmodeling;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import xmodeling.contents.*;

/**
 * <b> PrintSourceFiles is the class responsible to generate new files with content. </b>
 * <p>
 * A file may need the following information:
 * <ul>
 * <li>the name of the project owning the file,</li>
 * <li>the name of the project but this time with upper-case for the first letter,</li>
 * <li>the referenced project.</li>
 * </ul>
 * 
 * @author Lea Brunschwig
 * @author Hugo Richard
 *
 */
public class XmodelingFilesManager {

	private static final String[] fileIds = {
			"build.properties", "plugin.properties", "plugin.xml", ".project", ".classpath", "MANIFEST.MF",
			"aird", "ecore", "genmodel", "Switch.java", "AdapterFactory.java", "Factory.java",
			"FactoryImpl.java", "Package.java", "PackageImpl.java", "XmodUtils.java",
			"Xmod_Action.java", "Xmod_ActionImpl.java", "Xmod_Operation.java", "Xmod_OperationImpl.java",
			"Xmod_Element.java", "Xmod_ElementImpl.java", "Xmod_Exception.java", "Xmod_ExceptionImpl.java",
			"Xmod_ExceptionLiteral.java", "Xmod_ExceptionReaction.java"
	};

	/**
	 * @see SourceFilesPrinter(IProject, String, String)
	 */
	private final String projectName;
	/**
	 * @see SourceFilesPrinter(IProject, String, String)
	 */
	private final String projectClass;
	/**
	 * @see SourceFilesPrinter(IProject, String, String)
	 */
	private final IProject project;
	
	/**
	 * Constructor PrintSourceFiles.
	 * 
	 * @param project
	 * 			The referenced project.
	 * @param projectName
	 * 			The name of the project owing the file.
	 * @param projectClass
	 * 			The name of the project but with upper-case for the first letter.
	 * 
	 * @see XmodelingFilesManager#project
	 * @see XmodelingFilesManager#projectClass
	 * @see XmodelingFilesManager#projectName
	 */
	protected XmodelingFilesManager(IProject project, String projectName, String projectClass) {
		this.project = project;
		this.projectName = projectName;
		this.projectClass = projectClass;
	}
	
	protected XmodelingFilesManager(String projectName, String projectClass) {
		this.project = null;
		this.projectName = projectName;
		this.projectClass = projectClass;
	}
	
	/**
     * Retrieves the project directory based on the provided target file.
     * @param path 
     * 		the target file's path
     * @param projectName
     * 		the name of the project
     * @return
     * 		the directory of given project name or null if not found
     */
    public static File findProjectUpwards(String path, String projectName) {
        File current = new File(path);

        while (current != null) {
            if (current.getName().equals(projectName)) {
            	// check if said directory is an eclipse project
                File dotProject = new File(current, ".project");
                if (dotProject.exists())
                    return current;
            }
            current = current.getParentFile(); // go up
        }

        return null;
    }
    
    /**
     * Retrieves a given folder in another, based on its name
     * @param root
     * 		the folder from where to start the search
     * @param folderName
     * 		the name of the searched folder
     * @return
     * 		the folder you're looking for or null if not found
     */
    public static File findFolder(File current, String folderName) {
        if (!current.isDirectory()) return null;

        if (current.getName().equals(folderName)) return current;

        File[] children = current.listFiles(File::isDirectory);
        if (children == null) return null;

        for (File child : children) {
            File result = findFolder(child, folderName);
            if (result != null) return result;
        }

        return null;
    }

	/**
	 * Create the file in the specified folder with the specified name and the corresponding content.
	 * 
	 * @param folder
	 * 			The folder where the file will be created.
	 * @param file
	 * 			The name of the file, the corresponding content will be printed.
	 * 
	 * @see XmodelingFilesManager#switchForContentFile(String)
	 * @see XmodelingFilesManager#project
	 */
	protected void createFile(Path folder, String fileName) throws IOException {
		Path file = folder.resolve(fileName);

    	// gathers the content for the file based on its name
        String content = switchForContentFile(fileName);

		// some file names aren't complete, so we also try to match a pattern
		if (content == null)
			for (String id : fileIds)
				if (fileName.contains(id))
					content = switchForContentFile(id);

		Files.writeString(
    		file,
    		content,
    		StandardOpenOption.CREATE, // creates file if it doesnt exist
    		StandardOpenOption.TRUNCATE_EXISTING // overwrites it if it does
        );
	}
	
	/**
	 * Handles the creation of the utils file which requires the root class name.
	 * This method is meant to be used for this purpose only !
	 * 
	 * @param folder
	 * @param fileName
	 * @param rootClassName
	 * @throws IOException
	 */
	protected void createUtilsFile(Path folder, String fileName, String rootClassName) throws IOException {
		Path file = folder.resolve(fileName);
		String content = new XmodUtilContent().getContentFor(projectName, projectClass, rootClassName);
		Files.writeString(
    		file,
    		content,
    		StandardOpenOption.CREATE, // creates file if it doesnt exist
    		StandardOpenOption.TRUNCATE_EXISTING // overwrites it if it does
        );
    }
	
	protected void createXtextFile(Path folder, String fileName, Path mmPath) {
		
	}
	
	/**
	 * returns the content of a specific file through a switch.
	 * 
	 * @param id Correspond to one of the cases enumerated previously.
	 * 
	 * @return a string containing the corresponding content for a file
	 * 
	 * @see XmodelingFilesManager#projectClass
	 * @see XmodelingFilesManager#projectName
	 */
	private String switchForContentFile(String id) {
		FileContent fc = switch (id) {
			case "build.properties" -> new BuildPropertiesContent();
			case "plugin.properties" -> new PluginPropertiesContent();
			case "plugin.xml" -> new PluginXmlContent();
			case ".project" -> new ProjectFileContent();
			case ".classpath" -> new ClasspathFileContent();
			case "MANIFEST.MF" -> new ManifestFileContent();

			case "aird" -> new AirdFileContent();
			case "ecore" -> new EcoreFileContent();
			case "genmodel" -> new GenmodelFileContent();

			case "Factory.java" -> new FactoryContent();
			case "FactoryImpl.java" -> new FactoryImplContent();
			case "Package.java" -> new PackageContent();
			case "PackageImpl.java" -> new PackageImplContent();
			case "AdapterFactory.java" -> new AdapterFactoryContent();
			case "Switch.java" -> new SwitchFileContent();

			case "XmodUtil.java" -> new XmodUtilContent();

			case "Xmod_Action.java" -> new Xmod_ActionContent();
			case "Xmod_ActionImpl.java" -> new Xmod_ActionImplContent();
			case "Xmod_Operation.java" -> new Xmod_OperationContent();
			case "Xmod_OperationImpl.java" -> new Xmod_OperationImplContent();
			case "Xmod_Element.java" -> new Xmod_ElementContent();
			case "Xmod_ElementImpl.java" -> new Xmod_ElementImplContent();
			case "Xmod_Exception.java" -> new Xmod_ExceptionContent();
			case "Xmod_ExceptionImpl.java" -> new Xmod_ExceptionImplContent();
			case "Xmod_ExceptionLiteral.java" -> new Xmod_ExceptionLiteralContent();
			case "Xmod_ExceptionReaction.java" -> new Xmod_ExceptionReactionContent();

			default -> null;
		};

		if (fc == null) return null;
		return new FileGenerator(fc).getContentFor(projectName, projectClass);
	}
}
