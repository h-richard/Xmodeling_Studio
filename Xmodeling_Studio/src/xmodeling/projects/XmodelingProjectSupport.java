package xmodeling.projects;
 
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;

import xmodeling.XmodelingFilesManager;

/**
 * <b> XmodelingProjectSupport is providing methods to create a project. </b>
 * 
 * @see XmodelingFilesManager
 * 
 * @author Lea Brunschwig
 * @author Hugo Richard
 */
public class XmodelingProjectSupport {
	
	/**
	 * <p>To create a Xmodeling project, we need to:
	 * <ul>
	 * <li>create the default Eclipse project</li>
	 * <li>create the folder structure</li>
	 * <li>add all the necessary files</li>
	 * </ul>
	 * </p>
	 * 
	 * @see XmodelingProjectSupport#createBaseProject(String, java.net.URI)
	 * @see XmodelingProjectSupport#addToProjectStructure(IProject, String[])
	 * @see XmodelingProjectSupport#fromExistingEcoreTransformation(String, String, String, String)
	 * //@see XmodelingProjectNewWizardFromExistingEcore
	 * //@see XmodelingProjectNewWizardFromExistingEcorePage1
	 * 
	 * @param projectName
	 * 			The name of the project that is going to be created.
	 * @param location
	 * 			The URI of the location where the project is going to be created.
	 * @param ecore
	 * 			Case <i>"Xmodeling Project from existing ecore"</i>: the name of the ecore file.
	 * @param xmod_main
	 * 			Case <i>"Xmodeling Project from existing ecore"</i>: the name of the class that has been annotated with Xmod_main.
	 * @param sourcePackage
	 * 			Case <i>"Xmodeling Project from existing ecore"</i>: the name of the source package frome the ecore.
	 * 
	 * @return the Xmodeling project that has been created.
	 */
    public static IProject createProject(String projectName, java.net.URI location, String ecore, String xmod_main, String sourcePackage) {
    	Assert.isNotNull(projectName);
        Assert.isTrue(projectName.trim().length() > 0);
 
        IProject project = createBaseProject(projectName, location);
        try {
            String[] paths = { "src-gen", "src", "META-INF", "model", "src-gen/"+ projectName, "src-gen/"+projectName+"/impl", "src-gen/"+projectName+"/util" }; 
            addToProjectStructure(project, paths);
            if(ecore != null && xmod_main != null && sourcePackage!= null) {
            	try { fromExistingEcoreTransformation(projectName, ecore, xmod_main, sourcePackage); }
				catch (IOException e) { e.printStackTrace(); }
            }
        } catch (CoreException e) {
            e.printStackTrace();
            project = null;
        }
 
        return project;
    }
 
    /**
     * Case <i>"Xmodeling Project from existing ecore"</i>
     * <p>Add the content of the chosen .ecore to the actual .ecore of the project and create the XmodUtil class with the corresponding class.</p>
     * 
     * @param projectName
	 * 			The name of the project that is going to be created.
     * @param ecore
     * 			The name of the ecore file.
     * @param xmod_main
     * 			The name of the class that has been annotated with Xmod_main.
     * @param sourcePackage
     * 			The name of the source package from the ecore.
     * 
     * @throws IOException
     * @throws CoreException
     */
    private static void fromExistingEcoreTransformation(String projectName, String ecore, String xmod_main, String sourcePackage) throws IOException, CoreException {
    	/* Init */
		String projectClass, content;
    	StringBuffer sb = new StringBuffer();
    	String buf;
		IProject p;
		IFile f;
		InputStream s;
		File ecoreFile;
		
		/* Body */
		p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    	f = p.getFolder("model").getFile(projectName+".ecore");
    	if (!f.exists()) { // if the original <projectName>XmodUtil.java file has been deleted
			f.create(null, true, null);
    	}
		ecoreFile = new File(ecore);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(ecoreFile));
	    StringWriter out = new StringWriter();
	    int b;
	    while ((b=in.read()) != -1)
	        out.write(b);
	    out.flush();
	    out.close();
	    in.close();
	    content = out.toString();
	    content = content.replaceAll(sourcePackage, projectName);
		s = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
		f.setContents(s, true, true, null);
    	
		sb.delete(0, sb.length());
		buf = projectName;
    	projectClass = buf.substring(0,1).toUpperCase();
    	sb.append(projectClass);
    	sb.append(buf.substring(1, buf.length()));
    	projectClass = sb.toString();
    	
    	f = p.getFolder("src-gen/"+p.getName()+"/util").getFile(projectClass+"XmodUtil.java");
		    	
    	if (!f.exists()) { // if the original <projectName>XmodUtil.java file has been deleted
			f.create(null, true, null);
    	}
    	content = "package "+projectName+".util;\r\n" + 
    			"\r\n" + 
    			"import java.beans.XMLDecoder;\r\n" + 
    			"import java.beans.XMLEncoder;\r\n" + 
    			"import java.io.BufferedInputStream;\r\n" + 
    			"import java.io.BufferedOutputStream;\r\n" + 
    			"import java.io.File;\r\n" + 
    			"import java.io.FileInputStream;\r\n" + 
    			"import java.io.FileNotFoundException;\r\n" + 
    			"import java.io.FileOutputStream;\r\n" + 
    			"import java.util.HashMap;\r\n" + 
    			"\r\n" + 
    			"import org.eclipse.emf.common.util.TreeIterator;\r\n" + 
    			"import org.eclipse.emf.common.util.URI;\r\n" + 
    			"import org.eclipse.emf.ecore.EObject;\r\n" + 
    			"import org.eclipse.emf.ecore.EPackage;\r\n" + 
    			"import org.eclipse.emf.ecore.resource.Resource;\r\n" + 
    			"import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;\r\n" + 
    			"import org.eclipse.emf.ecore.xmi.XMLResource;\r\n" + 
    			"import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;\r\n" + 
    			"import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;\r\n" + 
    			"import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;\r\n" + 
    			"import "+projectName+"."+xmod_main+";\r\n" + 
    			"\r\n" + 
    			"import "+projectName+"."+projectClass+"Package;\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"/**\r\n" + 
    			" * <b> "+projectClass+"XmodUtil is a class that provides tools to manipulate the model and the map. </b>\r\n" + 
    			" * \r\n" + 
    			" * @author LeaBrunschwig\r\n" + 
    			" */" +
    			"public class "+projectClass+"XmodUtil {\r\n" + 
    			"	\r\n" + 
    			"	/**\r\n" + 
    			"	 * The map containing all the tags.\r\n" + 
    			"	 * \r\n" + 
    			"	 * @see #getMap()\r\n" + 
    			"	 * @see #setMap(HashMap)\r\n" + 
    			"	 * @see #loadMap(String)\r\n" + 
    			"	 * @see #saveMap(String)\r\n" + 
    			"	 */" +
    			"	private static HashMap<String,Object> hm;\r\n" + 
    			"	\r\n" + 
    			"	/**\r\n" + 
    			"	 * Returns the value of the map.\r\n" + 
    			"	 * <p>The singleton design pattern is used.</p>\r\n" + 
    			"	 * @return the map hm.\r\n" + 
    			"	 * @see #hm\r\n" + 
    			"	 */" +
    			"	public static HashMap<String,Object> getMap() {\r\n" + 
    			"		if (hm == null) {\r\n" + 
    			"			hm = new HashMap<String,Object>();\r\n" + 
    			"		}\r\n" + 
    			"		return hm;\r\n" + 
    			"	}\r\n" + 
    			"\r\n" + 
    			"	/**\r\n" + 
    			"	 * Updates the map hm.\r\n" + 
    			"	 * @param hm\r\n" + 
    			"	 * 			Map that is going to be set to the attribute hm.\r\n" + 
    			"	 * @see #hm\r\n" + 
    			"	 */" +
    			"	public static void setMap(HashMap<String,Object> hm) {\r\n" + 
    			"		"+projectClass+"XmodUtil.hm = hm;\r\n" + 
    			"	}\r\n" + 
    			"\r\n" + 
    			"	/**\r\n" + 
    			"	 * Loads a map from a file.\r\n" + 
    			"	 * <p>The map is deserialized.</p>\r\n" + 
    			"	 * @param fileName\r\n" + 
    			"	 * 			Name of the file containing a map.\r\n" + 
    			"	 * @return a map containing the map from the given file.\r\n" + 
    			"	 */" +
    			"	@SuppressWarnings(\"unchecked\")\r\n" + 
    			"	public static java.util.Map<String, Object> loadMap(String fileName) {\r\n" + 
    			"\r\n" + 
    			"		/* Init */\r\n" + 
    			"		File xmlFile;\r\n" + 
    			"		XMLDecoder decoder = null;\r\n" + 
    			"		HashMap<String, Object> hm = new HashMap<String, Object>();\r\n" + 
    			"\r\n" + 
    			"		/* Body */\r\n" + 
    			"		try {\r\n" + 
    			"			xmlFile = new File(fileName);\r\n" + 
    			"			if (xmlFile.exists()) { // if an xml file with the name of the map does exist, we deserialize it.\r\n" + 
    			"				decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(xmlFile)));\r\n" + 
    			"				hm = (HashMap<String, Object>) decoder.readObject();\r\n" + 
    			"				decoder.close();\r\n" + 
    			"			}\r\n" + 
    			"\r\n" + 
    			"		} catch (FileNotFoundException e1) {\r\n" + 
    			"			e1.printStackTrace();\r\n" + 
    			"		}\r\n" + 
    			"\r\n" + 
    			"		return hm;\r\n" + 
    			"	}\r\n" + 
    			"	\r\n" + 
    			"	/**\r\n" + 
    			"	 * Saves a map in a file.\r\n" + 
    			"	 * <p>The map is serialized.</p>\r\n" + 
    			"	 * @param fileName\r\n" + 
    			"	 * 			Name of the file where the map is going to be saved.\r\n" + 
    			"	 */" +
    			"	public static void saveMap(String fileName) {\r\n" + 
    			"\r\n" + 
    			"		/* Init */\r\n" + 
    			"		File xmlFile;\r\n" + 
    			"		XMLEncoder encoder = null;\r\n" + 
    			"\r\n" + 
    			"		/* Body */\r\n" + 
    			"		try {\r\n" + 
    			"			xmlFile = new File(fileName);\r\n" + 
    			"			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(xmlFile)));\r\n" + 
    			"			encoder.writeObject(getMap());\r\n" + 
    			"			encoder.flush();\r\n" + 
    			"		} catch (FileNotFoundException e) {\r\n" + 
    			"			e.printStackTrace();\r\n" + 
    			"		} finally {\r\n" + 
    			"			// closing of the encoder\r\n" + 
    			"			encoder.close();\r\n" + 
    			"		}\r\n" + 
    			"	}\r\n" + 
    			"	\r\n" + 
    			"\r\n" + 
    			"	/**\r\n" + 
    			"	 * Saves a given model at a given URI.\r\n" + 
    			"	 * @param uri\r\n" + 
    			"	 * 			The URI where the model will be saved.\r\n" + 
    			"	 * @param root\r\n" + 
    			"	 * 			The root of the model that is going to be saved.\r\n" + 
    			"	 */" +
    			"	public static void saveModel(String uri, EObject root) {\r\n" + 
    			"		Resource resource = null;\r\n" + 
    			"		try {\r\n" + 
    			"			URI uriUri = URI.createURI(uri);\r\n" + 
    			"			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\"xmi\", new XMIResourceFactoryImpl());\r\n" + 
    			"			resource = (new ResourceSetImpl()).createResource(uriUri);\r\n" + 
    			"			resource.getContents().add(root);\r\n" + 
    			"			resource.save(null); \r\n" + 
    			"		} catch (Exception e) { \r\n" + 
    			"			System.err.println(\"Error in saving the model: \"+e);\r\n" + 
    			"			e.printStackTrace(); \r\n" + 
    			"		} \r\n" + 
    			"	}\r\n" + 
    			"\r\n" + 
    			"	/**\r\n" + 
    			"	 * Load a model from a given URI.\r\n" + 
    			"	 * @param uri\r\n" + 
    			"	 * 			The URI where the model is.\r\n" + 
    			"	 * @param pack\r\n" + 
    			"	 * 			an instance of EPackage\r\n" + 
    			"	 * @return a model\r\n" + 
    			"	 */" +
    			"	public static Resource loadModel(String uri, EPackage pack) {\r\n" + 
    			"		Resource resource = null;\r\n" + 
    			"		try {\r\n" + 
    			"			URI uriUri = URI.createURI(uri);\r\n" + 
    			"			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\"xmi\", new XMIResourceFactoryImpl());\r\n" + 
    			"			resource = (new ResourceSetImpl()).createResource(uriUri);\r\n" + 
    			"			XMLResource.XMLMap xmlMap = new XMLMapImpl();\r\n" + 
    			"			xmlMap.setNoNamespacePackage(pack);\r\n" + 
    			"			java.util.Map<String, XMLMap> options = new java.util.HashMap<String, XMLMap>();\r\n" + 
    			"			options.put(XMLResource.OPTION_XML_MAP, xmlMap);\r\n" + 
    			"			resource.load(options);    \r\n" + 
    			"		}\r\n" + 
    			"		catch(Exception e) {\r\n" + 
    			"			System.err.println(\"Error while loading the model: \"+e);\r\n" + 
    			"			e.printStackTrace();\r\n" + 
    			"		}\r\n" + 
    			"		return resource;\r\n" + 
    			"	}\r\n" + 
    			"	\r\n" + 
    			"	/**\r\n" + 
    			"	 * Load the "+xmod_main+" of the model, in other word, the root of the model.\r\n" + 
    			"	 * @param uri\r\n" + 
    			"	 * 			The location of the model.\r\n" + 
    			"	 * @return the root of the model: in our case the "+xmod_main+".\r\n" + 
    			"	 * @see #loadModel(String, EPackage)\r\n" + 
    			"	 * @see "+xmod_main+"\r\n" + 
    			"	 */" +
    			"	public static "+xmod_main+" load"+xmod_main+"(String uri) {\r\n" + 
    			"		Resource resource = "+projectName+".util."+projectClass+"XmodUtil.loadModel(uri, "+projectClass+"Package.eINSTANCE);\r\n" + 
    			"		if (resource == null) return null;\r\n" + 
    			"		\r\n" + 
    			"		TreeIterator<EObject> it = resource.getAllContents();\r\n" + 
    			"		\r\n" + 
    			"		"+xmod_main+" proc = null;\r\n" + 
    			"		while(it.hasNext()) {\r\n" + 
    			"			EObject obj = it.next();\r\n" + 
    			"			if (obj instanceof "+xmod_main+") { \r\n" + 
    			"				proc = ("+xmod_main+")obj;	\r\n" + 
    			"				break;	\r\n" + 
    			"			}\r\n" + 
    			"		}\r\n" + 
    			"		if (proc == null) {\r\n" + 
    			"			System.err.println(\"No root instance in the model\");\r\n" + 
    			"		}\r\n" + 
    			"		return proc;\r\n" + 
    			"	}\r\n" + 
    			"}\r\n" + 
    			"";
    	s = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
		f.setContents(s, true, true, null);
		
	}

    /**
     * Create a basic project.
     * 
     * @param projectName
	 * 			The name of the project that is going to be created.
     * @param location
	 * 			The URI of the location where the project is going to be created.
	 * 
     * @return the project that has been created.
     */
    private static IProject createBaseProject(String projectName, java.net.URI location) {
    	
        // it is acceptable to use the ResourcesPlugin class
        IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
 
        if (!newProject.exists()) {
            java.net.URI projectLocation = location;
            IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
            if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
                projectLocation = null;
            }
 
            desc.setLocationURI(projectLocation);
            try {
                newProject.create(desc, null);
                if (!newProject.isOpen()) {
                    newProject.open(null);
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
 
        return newProject;
    }
 
    /**
     * Create folder.
     * 
     * @param folder
     * 			The folder that we want to create.
     * 
     * @throws CoreException
     */
    private static void createFolder(IFolder folder) throws CoreException {
        IContainer parent = folder.getParent();
        if (parent instanceof IFolder) {
            createFolder((IFolder) parent);
        }
        if (!folder.exists()) {
            folder.create(false, true, null);
        }
    }

    /**
     * Create a folder structure with a parent root and add all the structure file and Xmod java classes.
     * 
     * @param newProject
     * 			The project that is being created.
     * @param paths
     * 			The paths of the different folders.
     * 
     * @see XmodelingFilesManager#createFile(String, String)
     * @see XmodelingProjectSupport#createFolder(IFolder)
     * 
     * @throws CoreException
     */
    private static void addToProjectStructure(IProject newProject, String[] paths) throws CoreException {
    	
    	/* Init */
    	String buf, classe;
    	StringBuffer sb = new StringBuffer();
    	IFolder etcFolders;
    	XmodelingFilesManager p;
    	
    	/* Body */
    	buf = newProject.getName();
    	classe = buf.substring(0,1).toUpperCase();
    	sb.append(classe);
    	sb.append(buf.substring(1, buf.length()));
    	classe = sb.toString();
    	/*
    	p = new XmodelingFilesManager(newProject, newProject.getName(), classe);
    	p.createFile(null, "build.properties");
    	p.createFile(null, "plugin.properties");
    	p.createFile(null, "plugin.xml");
        p.createFile(null, ".project"); 
        p.createFile(null, ".classpath"); 
    	
    	for (String path : paths) {
    		etcFolders = newProject.getFolder(path);
            createFolder(etcFolders);
        }
    	
    	p.createFile("model",newProject.getName()+".aird");
    	p.createFile("model",newProject.getName()+".ecore");
        p.createFile("model",newProject.getName()+".genmodel");
        p.createFile("META-INF","MANIFEST.MF"); 
        p.createFile("src-gen/"+newProject.getName()+"/impl","Xmod_ActionImpl.java"); 
        p.createFile("src-gen/"+newProject.getName(),"Xmod_Action.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/impl","Xmod_OperationImpl.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/","Xmod_Operation.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/impl",classe+"PackageImpl.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/",classe+"Package.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/impl",classe+"FactoryImpl.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/",classe+"Factory.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/util",classe+"AdapterFactory.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/util",classe+"Switch.java"); 
        p.createFile("src-gen/"+newProject.getName()+"/util", classe+"XmodUtil.java");
        */
    }
 
}