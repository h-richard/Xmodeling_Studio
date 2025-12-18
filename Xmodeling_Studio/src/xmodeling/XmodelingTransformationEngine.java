package xmodeling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * <b> XmodelingTransformationEngine is the class dealing with metamodel-to-metamodel transformation. </b>
 *
 * @author Lea Brunschwig
 * @author Hugo Richard
 */
public class XmodelingTransformationEngine {

    /**
     * Create the workflow metamodel elements to be added to the
     * other metamodel after concatenation
     *
     * @return ArrayList<EClass> the list of all elements from the workflow
     * metamodel.
     */
    @SuppressWarnings("unchecked")
    protected HashMap<String, EClassifier> getWorkflowElements() {

        EcoreFactory factory = EcoreFactory.eINSTANCE;
        EcorePackage pack = EcorePackage.eINSTANCE;

        // classes
        EClass Xmod_Operation = factory.createEClass();
        EClass Xmod_Action = factory.createEClass();
        EClass Xmod_Element = factory.createEClass();
        EClass Xmod_Exception = factory.createEClass();

        // enums
        EEnum Xmod_ExceptionReaction = factory.createEEnum();
        EEnum Xmod_ExceptionKind = factory.createEEnum();

        // references
        EReference operationsRef = factory.createEReference();
        EReference exceptionsRef = factory.createEReference();
        EReference calledOperationRef = factory.createEReference();

        // attributes
        EAttribute nameOperation = factory.createEAttribute();
        EAttribute objectOperation = factory.createEAttribute();
        EAttribute parametersOperation = factory.createEAttribute();
        EAttribute returnOperation = factory.createEAttribute();
        EAttribute xmod_id = factory.createEAttribute();
        EAttribute kind = factory.createEAttribute();
        EAttribute filter = factory.createEAttribute();
        EAttribute reaction = factory.createEAttribute();
        EAttribute actionName = factory.createEAttribute();

        // operations
        EOperation execute = factory.createEOperation();
        EOperation callOperation = factory.createEOperation();

        /******************/
        /* Xmod_Operation */
        /******************/
        Xmod_Operation.setName("Xmod_Operation");

        // attribute nameOperation
        nameOperation.setName("name");
        nameOperation.setLowerBound(1);
        nameOperation.setUpperBound(1);
        nameOperation.setEType(pack.getEString());

        // attribute objectOperation
        objectOperation.setName("objectTag");
        objectOperation.setLowerBound(1);
        objectOperation.setUpperBound(1);
        objectOperation.setEType(pack.getEString());

        // attribute parametersOperation
        parametersOperation.setName("parametersTag");
        parametersOperation.setLowerBound(0);
        parametersOperation.setUpperBound(-1);
        parametersOperation.setEType(pack.getEString());

        // attribute returnOperation
        returnOperation.setName("returnTag");
        returnOperation.setLowerBound(0);
        returnOperation.setUpperBound(1);
        returnOperation.setEType(pack.getEString());

        // operation callOperation
        callOperation.setName("callOperation");
        callOperation.setLowerBound(1);
        callOperation.setUpperBound(1);
        callOperation.setEType(Xmod_Exception);

        // reference exceptions
        exceptionsRef.setEType(Xmod_Exception);
        exceptionsRef.setLowerBound(0);
        exceptionsRef.setUpperBound(-1);
        exceptionsRef.setContainment(true);
        exceptionsRef.setName("exceptions");

        Xmod_Operation.getEStructuralFeatures().add(nameOperation);
        Xmod_Operation.getEStructuralFeatures().add(objectOperation);
        Xmod_Operation.getEStructuralFeatures().add(parametersOperation);
        Xmod_Operation.getEStructuralFeatures().add(returnOperation);
        Xmod_Operation.getEOperations().add(callOperation);
        Xmod_Operation.getEStructuralFeatures().add(exceptionsRef);

        /***************/
        /* Xmod_Action */
        /***************/
        Xmod_Action.setName("Xmod_Action");

        // attribute
        actionName.setName("name");
        actionName.setLowerBound(1);
        actionName.setUpperBound(1);
        actionName.setEType(pack.getEString());

        // reference operations
        operationsRef.setEType(Xmod_Operation);
        operationsRef.setLowerBound(1);
        operationsRef.setUpperBound(-1);
        operationsRef.setContainment(true);
        operationsRef.setName("operations");

        // operation execute
        execute.setName("execute");
        execute.setLowerBound(1);
        execute.setUpperBound(1);
        execute.setEType(Xmod_ExceptionReaction);

        Xmod_Action.getEStructuralFeatures().add(actionName);
        Xmod_Action.getEStructuralFeatures().add(operationsRef);
        Xmod_Action.getEOperations().add(execute);

        /***************/
        /* Xmod_Element */
        /***************/
        Xmod_Element.setName("Xmod_Element");

        // attribute xmod_id
        xmod_id.setName("xmod_id");
        xmod_id.setLowerBound(0);
        xmod_id.setUpperBound(1);
        xmod_id.setEType(pack.getEString());

        Xmod_Element.getEStructuralFeatures().add(xmod_id);
        Xmod_Element.setAbstract(true);

        /***************/
        /* Xmod_Exception */
        /***************/
        Xmod_Exception.setName("Xmod_Exception");

        // attribute kind
        kind.setName("kind");
        kind.setLowerBound(1);
        kind.setUpperBound(1);
        kind.setEType(Xmod_ExceptionKind);

        // attribute filter
        filter.setName("filter");
        filter.setLowerBound(0);
        filter.setUpperBound(1);
        filter.setEType(pack.getEString());

        // attribute reaction
        reaction.setName("reaction");
        reaction.setLowerBound(1);
        reaction.setUpperBound(1);
        reaction.setEType(Xmod_ExceptionReaction);

        // reference calledOperation
        calledOperationRef.setEType(Xmod_Operation);
        calledOperationRef.setLowerBound(0);
        calledOperationRef.setUpperBound(1);
        calledOperationRef.setContainment(true);
        calledOperationRef.setName("calledOperation");

        Xmod_Exception.getEStructuralFeatures().add(kind);
        Xmod_Exception.getEStructuralFeatures().add(filter);
        Xmod_Exception.getEStructuralFeatures().add(reaction);
        Xmod_Exception.getEStructuralFeatures().add(calledOperationRef);

        /***************/
        /* Xmod_ExceptionKind */
        /***************/
        Xmod_ExceptionKind.setName("Xmod_ExceptionKind");

        EEnumLiteral ok = factory.createEEnumLiteral();
        ok.setName("ok");
        ok.setValue(0);
        Xmod_ExceptionKind.getELiterals().add(ok);

        EEnumLiteral unknownNamespace = factory.createEEnumLiteral();
        unknownNamespace.setName("unknownNamespace");
        unknownNamespace.setValue(1);
        Xmod_ExceptionKind.getELiterals().add(unknownNamespace);

        EEnumLiteral objectNotFound = factory.createEEnumLiteral();
        objectNotFound.setName("objectNotFound");
        objectNotFound.setValue(2);
        Xmod_ExceptionKind.getELiterals().add(objectNotFound);

        EEnumLiteral methodNotFound = factory.createEEnumLiteral();
        methodNotFound.setName("methodNotFound");
        methodNotFound.setValue(3);
        Xmod_ExceptionKind.getELiterals().add(methodNotFound);

        EEnumLiteral parametersNotMatching = factory.createEEnumLiteral();
        parametersNotMatching.setName("parametersNotMatching");
        parametersNotMatching.setValue(4);
        Xmod_ExceptionKind.getELiterals().add(parametersNotMatching);

        EEnumLiteral returnTypeNotMatching = factory.createEEnumLiteral();
        returnTypeNotMatching.setName("returnTypeNotMatching");
        returnTypeNotMatching.setValue(5);
        Xmod_ExceptionKind.getELiterals().add(returnTypeNotMatching);

        EEnumLiteral methodException = factory.createEEnumLiteral();
        methodException.setName("methodException");
        methodException.setValue(6);
        Xmod_ExceptionKind.getELiterals().add(methodException);

        EEnumLiteral other = factory.createEEnumLiteral();
        other.setName("other");
        other.setValue(7);
        Xmod_ExceptionKind.getELiterals().add(other);

        /***************/
        /* Xmod_ExceptionReaction */
        /***************/
        Xmod_ExceptionReaction.setName("Xmod_ExceptionReaction");

        EEnumLiteral _continue = factory.createEEnumLiteral();
        _continue.setName("continue");
        _continue.setValue(0);
        Xmod_ExceptionReaction.getELiterals().add(_continue);

        EEnumLiteral skip = factory.createEEnumLiteral();
        skip.setName("skip");
        skip.setValue(1);
        Xmod_ExceptionReaction.getELiterals().add(skip);

        EEnumLiteral exit = factory.createEEnumLiteral();
        exit.setName("exit");
        exit.setValue(2);
        Xmod_ExceptionReaction.getELiterals().add(exit);


        HashMap<String, EClassifier> xmodClasses = new HashMap<>();
        xmodClasses.put("operation", Xmod_Operation);
        xmodClasses.put("action", Xmod_Action);
        xmodClasses.put("element", Xmod_Element);
        xmodClasses.put("exception", Xmod_Exception);
        xmodClasses.put("exReaction", Xmod_ExceptionReaction);
        xmodClasses.put("exKind", Xmod_ExceptionKind);

        return (HashMap<String, EClassifier>) xmodClasses.clone();
    }

    /**
     * <p>modifyMetaModel has two purposes :
     * <ul>
     * <li>Add to the metamodel the Xmod classes regarding the position of the Xmod_exec annotation.</li>
     * <li>Add a method at the end of the [projectName]XmodUtil class regarding the Xmod_main annotation position.</li>
     * </ul>
     * </p>
     *
     * @param mmSource file containing the original metamodel
     * @param mmTarget file in which the modified metamodel is saved
     * @throws IOException
     * @throws CoreException
     * @see XmodelingTransformationEngine#getWorkflowElements()
     */
    public void modifyMetaModel(String mmSource, String mmTarget) throws IOException, CoreException {

        /* Init */
        String projectName = "";
        String projectClass = "";
        EcoreFactory factory = EcoreFactory.eINSTANCE;

        // loading of the original MM
        URI uri = URI.createFileURI(mmSource);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        Factory resourceFactory = new XMIResourceFactoryImpl();
        Resource resource = resourceFactory.createResource(uri);
        resource.load(null);

        // change the URI to the modified metamodel
        uri = URI.createFileURI(mmTarget);
        resource.setURI(uri);

        // creation of the Workflow classes
        HashMap<String, EClassifier> xmodClasses = getWorkflowElements();

        // we go across every element of the metamodel
        TreeIterator<EObject> treeit = resource.getAllContents();
        ArrayList<EClass> metamodelClasses = new ArrayList<>();
        while (treeit.hasNext()) {

            EObject eobject = treeit.next();

            // if we find the package of the MM, we add all the new classes
            if (eobject instanceof EPackage pack) {
                projectName = pack.getName();
                // a class name begins with an upper-case letter, so we format it
                projectClass = projectName.substring(0, 1).toUpperCase() + projectName.substring(1);
                for (EClassifier classif : xmodClasses.values())
                    pack.getEClassifiers().add(classif);
            }

            // we gather all the classes from the metamodel except those we just added
            if (eobject instanceof EClass ecls)
                if (!xmodClasses.containsValue(ecls))
                    metamodelClasses.add(ecls);
        }

        for (EClass ecls : metamodelClasses) {
            for (EAnnotation annotation : ecls.getEAnnotations()) {
                String source = annotation.getSource();

                // if a class owns an annotation "Xmod_elem" => identifiable element
                if (source.equals("Xmod_elem"))
                    // add Xmod_Element as a super-type of said class
                    ecls.getESuperTypes().add((EClass) xmodClasses.get("element"));

                // if a class owns an annotation "Xmod_exec" => executable class
                if (source.equals("Xmod_exec")) {
                    // create a reference between this class and Action
                    EReference actions = factory.createEReference();
                    // reference actions
                    actions.setEType(xmodClasses.get("action"));
                    actions.setLowerBound(0);
                    actions.setUpperBound(-1);
                    actions.setContainment(true);
                    actions.setName("actions");
                    ecls.getEStructuralFeatures().add(actions);
                }

                // if a class owns an annotation "Xmod_main" => root class
                if (source.equals("Xmod_main")) {
                    File proj;

                    // trying to retrieve the project directory using eclipse's workspace
                    try {
                        IWorkspace ws = ResourcesPlugin.getWorkspace();
                        IPath ipath = ws.getRoot().getProject(projectName).getLocation();
                        if (ipath == null) ws.getRoot().getProject(projectClass).getLocation();
                        if (ipath == null) throw new IllegalStateException();
                        proj = ipath.toFile();
                    }
                    // attempt failed (usually when running outside eclipse environment)
                    // using file system instead
                    catch (IllegalStateException ise) {
                        proj = XmodelingFilesManager.findProjectUpwards(mmTarget, projectName);
                        if (proj == null) proj = XmodelingFilesManager.findProjectUpwards(mmTarget, projectClass);
                        if (proj == null) {
                            System.out.println("Project name is not consistent with meta-model name.");
                            return;
                        }
                    }

                    // looking for the source folder (usually named 'src' or 'src-gen')
                    File sourceFolderFile = XmodelingFilesManager.findFolder(proj, "src");
                    if (sourceFolderFile == null) sourceFolderFile = XmodelingFilesManager.findFolder(proj, "src-gen");
                    if (sourceFolderFile == null) {
                        System.out.println("Source folder not found.");
                        return;
                    }
                    Path sourceFolder = sourceFolderFile.toPath();

                    // creating the project folders if they dont exist
                    Path mainFolder = sourceFolder.resolve(projectName);
                    Path implFolder = sourceFolder.resolve(projectName + File.separatorChar + "impl");
                    Path utilsFolder = sourceFolder.resolve(projectName + File.separatorChar + "util");
                    Path exceptionsFolder = sourceFolder.resolve("exceptions");

                    XmodelingFilesManager fm = new XmodelingFilesManager(projectName, projectClass);

                    // Project
                    Files.createDirectories(mainFolder);
                    fm.createFile(mainFolder, "Xmod_Action.java");
                    fm.createFile(mainFolder, "Xmod_Operation.java");
                    fm.createFile(mainFolder, "Xmod_Element.java");
                    fm.createFile(mainFolder, "Xmod_Exception.java");
                    fm.createFile(mainFolder, "Xmod_ExceptionKind.java");
                    fm.createFile(mainFolder, "Xmod_ExceptionReaction.java");

                    // Project.impl
                    Files.createDirectories(implFolder);
                    fm.createFile(implFolder, "Xmod_ActionImpl.java");
                    fm.createFile(implFolder, "Xmod_OperationImpl.java");
                    fm.createFile(implFolder, "Xmod_ElementImpl.java");
                    fm.createFile(implFolder, "Xmod_ExceptionImpl.java");

                    // Project.util
                    Files.createDirectories(utilsFolder);
                    fm.createUtilsFile(utilsFolder, projectClass + "Utils.java", ecls.getName());

                    // exceptions
                    Files.createDirectories(exceptionsFolder);
                    fm.createFile(exceptionsFolder, "Xmod_ExceptionContext.java");
                    fm.createFile(exceptionsFolder, "Xmod_UnknownNamespaceException.java");
                    fm.createFile(exceptionsFolder, "Xmod_ObjectNotFoundException.java");
                    fm.createFile(exceptionsFolder, "Xmod_MethodNotFoundException.java");
                    fm.createFile(exceptionsFolder, "Xmod_ParametersNotMatchingException.java");
                    fm.createFile(exceptionsFolder, "Xmod_ReturnTypeNotMatchingException.java");

                    // Xtext
                    int index = mmTarget.indexOf(projectName + File.separatorChar);
                    if (index == -1) index = mmTarget.indexOf(projectName + '/');
                    if (index == -1) index = mmTarget.indexOf(projectClass + File.separatorChar);
                    if (index == -1) index = mmTarget.indexOf(projectClass + '/');
                    if (index == -1) {
                        System.out.println("Could not find a relative path to metamodel");
                        return;
                    }

                    // relative path to the metamodel file (.ecore)
                    Path mmRelativePath = Path.of(mmTarget.substring(index));

                    Path xtextFolder = proj.toPath().resolve("xtext");
                    Path xtextValidationFolder = proj.toPath().resolve("xtext" + File.separatorChar + "validation");

                    Files.createDirectories(xtextFolder);
                    fm.createXtextFile(xtextFolder, "XtextGrammar.xtext", mmRelativePath);

                    Files.createDirectories(xtextValidationFolder);
                    fm.createFile(xtextValidationFolder, "XtextValidator.xtext");
                }
            }
        }

        // saving of the modified MM
        try {
            resource.save(null);
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Could not save the modified model", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}