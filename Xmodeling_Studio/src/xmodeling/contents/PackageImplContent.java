package xmodeling.contents;

public class PackageImplContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+".impl;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EAttribute;\r\n" +
            "import org.eclipse.emf.ecore.EClass;\r\n" +
            "import org.eclipse.emf.ecore.EOperation;\r\n" +
            "import org.eclipse.emf.ecore.EPackage;\r\n" +
            "import org.eclipse.emf.ecore.EReference;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.impl.EPackageImpl;\r\n" +
            "\r\n" +
            "import "+projectName+"."+projectClass+"Factory;\r\n" +
            "import "+projectName+"."+projectClass+"Package;\r\n" +
            "import "+projectName+".Xmod_Action;\r\n" +
            "import "+projectName+".Xmod_Operation;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * An implementation of the model <b>Package</b>.\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public class "+projectClass+"PackageImpl extends EPackageImpl implements "+projectClass+"Package {\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private EClass xmod_OperationEClass = null;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private EClass xmod_ActionEClass = null;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates an instance of the model <b>Package</b>, registered with\r\n" +
            "	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package\r\n" +
            "	 * package URI value.\r\n" +
            "	 * <p>Note: the correct way to create the package is via the static\r\n" +
            "	 * factory method {@link #init init()}, which also performs\r\n" +
            "	 * initialization of the package, or returns the registered package,\r\n" +
            "	 * if one already exists.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @see org.eclipse.emf.ecore.EPackage.Registry\r\n" +
            "	 * @see "+projectName+"."+projectClass+"Package#eNS_URI\r\n" +
            "	 * @see #init()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private "+projectClass+"PackageImpl() {\r\n" +
            "		super(eNS_URI, "+projectClass+"Factory.eINSTANCE);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private static boolean isInited = false;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.\r\n" +
            "	 * \r\n" +
            "	 * <p>This method is used to initialize {@link "+projectClass+"Package#eINSTANCE} when that field is accessed.\r\n" +
            "	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @see #eNS_URI\r\n" +
            "	 * @see #createPackageContents()\r\n" +
            "	 * @see #initializePackageContents()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public static "+projectClass+"Package init() {\r\n" +
            "		if (isInited)\r\n" +
            "			return ("+projectClass+"Package) EPackage.Registry.INSTANCE.getEPackage("+projectClass+"Package.eNS_URI);\r\n" +
            "\r\n" +
            "		// Obtain or create and register package\r\n" +
            "		"+projectClass+"PackageImpl the"+projectClass+"Package = ("+projectClass+"PackageImpl) (EPackage.Registry.INSTANCE\r\n" +
            "				.get(eNS_URI) instanceof "+projectClass+"PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)\r\n" +
            "						: new "+projectClass+"PackageImpl());\r\n" +
            "\r\n" +
            "		isInited = true;\r\n" +
            "\r\n" +
            "		// Create package meta-data objects\r\n" +
            "		the"+projectClass+"Package.createPackageContents();\r\n" +
            "\r\n" +
            "		// Initialize created meta-data\r\n" +
            "		the"+projectClass+"Package.initializePackageContents();\r\n" +
            "\r\n" +
            "		// Mark meta-data to indicate it can't be changed\r\n" +
            "		the"+projectClass+"Package.freeze();\r\n" +
            "\r\n" +
            "		// Update the registry and return the package\r\n" +
            "		EPackage.Registry.INSTANCE.put("+projectClass+"Package.eNS_URI, the"+projectClass+"Package);\r\n" +
            "		return the"+projectClass+"Package;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EClass getXmod_Operation() {\r\n" +
            "		return xmod_OperationEClass;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EAttribute getXmod_Operation_Name() {\r\n" +
            "		return (EAttribute) xmod_OperationEClass.getEStructuralFeatures().get(0);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EAttribute getXmod_Operation_ObjectTag() {\r\n" +
            "		return (EAttribute) xmod_OperationEClass.getEStructuralFeatures().get(1);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EAttribute getXmod_Operation_ParametersTag() {\r\n" +
            "		return (EAttribute) xmod_OperationEClass.getEStructuralFeatures().get(2);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EAttribute getXmod_Operation_ReturnTag() {\r\n" +
            "		return (EAttribute) xmod_OperationEClass.getEStructuralFeatures().get(3);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EOperation getXmod_Operation__Execute() {\r\n" +
            "		return xmod_OperationEClass.getEOperations().get(0);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EClass getXmod_Action() {\r\n" +
            "		return xmod_ActionEClass;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EReference getXmod_Action_OnEntry() {\r\n" +
            "		return (EReference) xmod_ActionEClass.getEStructuralFeatures().get(0);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EReference getXmod_Action_OnExit() {\r\n" +
            "		return (EReference) xmod_ActionEClass.getEStructuralFeatures().get(1);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EReference getXmod_Action_OnDo() {\r\n" +
            "		return (EReference) xmod_ActionEClass.getEStructuralFeatures().get(2);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EOperation getXmod_Action__OnEntry() {\r\n" +
            "		return xmod_ActionEClass.getEOperations().get(0);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EOperation getXmod_Action__OnExit() {\r\n" +
            "		return xmod_ActionEClass.getEOperations().get(1);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public EOperation getXmod_Action__OnDo() {\r\n" +
            "		return xmod_ActionEClass.getEOperations().get(2);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public "+projectClass+"Factory get"+projectClass+"Factory() {\r\n" +
            "		return ("+projectClass+"Factory) getEFactoryInstance();\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private boolean isCreated = false;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates the meta-model objects for the package.  This method is\r\n" +
            "	 * guarded to have no affect on any invocation but its first.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public void createPackageContents() {\r\n" +
            "		if (isCreated)\r\n" +
            "			return;\r\n" +
            "		isCreated = true;\r\n" +
            "\r\n" +
            "		// Create classes and their features\r\n" +
            "		xmod_OperationEClass = createEClass(XMOD_OPERATION);\r\n" +
            "		createEAttribute(xmod_OperationEClass, XMOD_OPERATION__NAME);\r\n" +
            "		createEAttribute(xmod_OperationEClass, XMOD_OPERATION__OBJECT_TAG);\r\n" +
            "		createEAttribute(xmod_OperationEClass, XMOD_OPERATION__PARAMETERS_TAG);\r\n" +
            "		createEAttribute(xmod_OperationEClass, XMOD_OPERATION__RETURN_TAG);\r\n" +
            "		createEOperation(xmod_OperationEClass, XMOD_OPERATION___EXECUTE);\r\n" +
            "\r\n" +
            "		xmod_ActionEClass = createEClass(XMOD_ACTION);\r\n" +
            "		createEReference(xmod_ActionEClass, XMOD_ACTION__ON_ENTRY);\r\n" +
            "		createEReference(xmod_ActionEClass, XMOD_ACTION__ON_EXIT);\r\n" +
            "		createEReference(xmod_ActionEClass, XMOD_ACTION__ON_DO);\r\n" +
            "		createEOperation(xmod_ActionEClass, XMOD_ACTION___ON_ENTRY);\r\n" +
            "		createEOperation(xmod_ActionEClass, XMOD_ACTION___ON_EXIT);\r\n" +
            "		createEOperation(xmod_ActionEClass, XMOD_ACTION___ON_DO);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	private boolean isInitialized = false;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Complete the initialization of the package and its meta-model.  This\r\n" +
            "	 * method is guarded to have no affect on any invocation but its first.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public void initializePackageContents() {\r\n" +
            "		if (isInitialized)\r\n" +
            "			return;\r\n" +
            "		isInitialized = true;\r\n" +
            "\r\n" +
            "		// Initialize package\r\n" +
            "		setName(eNAME);\r\n" +
            "		setNsPrefix(eNS_PREFIX);\r\n" +
            "		setNsURI(eNS_URI);\r\n" +
            "\r\n" +
            "		// Create type parameters\r\n" +
            "\r\n" +
            "		// Set bounds for type parameters\r\n" +
            "\r\n" +
            "		// Add supertypes to classes\r\n" +
            "\r\n" +
            "		// Initialize classes, features, and operations; add parameters\r\n" +
            "		initEClass(xmod_OperationEClass, Xmod_Operation.class, \"Xmod_Operation\", !IS_ABSTRACT, !IS_INTERFACE,\r\n" +
            "				IS_GENERATED_INSTANCE_CLASS);\r\n" +
            "		initEAttribute(getXmod_Operation_Name(), ecorePackage.getEString(), \"name\", null, 0, 1, Xmod_Operation.class,\r\n" +
            "				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);\r\n" +
            "		initEAttribute(getXmod_Operation_ObjectTag(), ecorePackage.getEString(), \"objectTag\", null, 1, 1,\r\n" +
            "				Xmod_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,\r\n" +
            "				!IS_DERIVED, IS_ORDERED);\r\n" +
            "		initEAttribute(getXmod_Operation_ParametersTag(), ecorePackage.getEString(), \"parametersTag\", null, 0, -1,\r\n" +
            "				Xmod_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,\r\n" +
            "				!IS_DERIVED, IS_ORDERED);\r\n" +
            "		initEAttribute(getXmod_Operation_ReturnTag(), ecorePackage.getEString(), \"returnTag\", null, 0, 1,\r\n" +
            "				Xmod_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,\r\n" +
            "				!IS_DERIVED, IS_ORDERED);\r\n" +
            "\r\n" +
            "		initEOperation(getXmod_Operation__Execute(), null, \"execute\", 0, 1, IS_UNIQUE, IS_ORDERED);\r\n" +
            "\r\n" +
            "		initEClass(xmod_ActionEClass, Xmod_Action.class, \"Xmod_Action\", !IS_ABSTRACT, !IS_INTERFACE,\r\n" +
            "				IS_GENERATED_INSTANCE_CLASS);\r\n" +
            "		initEReference(getXmod_Action_OnEntry(), this.getXmod_Operation(), null, \"onEntry\", null, 0, 1,\r\n" +
            "				Xmod_Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,\r\n" +
            "				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);\r\n" +
            "		initEReference(getXmod_Action_OnExit(), this.getXmod_Operation(), null, \"onExit\", null, 0, 1, Xmod_Action.class,\r\n" +
            "				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,\r\n" +
            "				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);\r\n" +
            "		initEReference(getXmod_Action_OnDo(), this.getXmod_Operation(), null, \"onDo\", null, 0, 1, Xmod_Action.class,\r\n" +
            "				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,\r\n" +
            "				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);\r\n" +
            "\r\n" +
            "		initEOperation(getXmod_Action__OnEntry(), null, \"onEntry\", 0, 1, IS_UNIQUE, IS_ORDERED);\r\n" +
            "\r\n" +
            "		initEOperation(getXmod_Action__OnExit(), null, \"onExit\", 0, 1, IS_UNIQUE, IS_ORDERED);\r\n" +
            "\r\n" +
            "		initEOperation(getXmod_Action__OnDo(), null, \"onDo\", 0, 1, IS_UNIQUE, IS_ORDERED);\r\n" +
            "\r\n" +
            "		// Create resource\r\n" +
            "		createResource(eNS_URI);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "} //"+projectClass+"PackageImpl\r\n";
    }
}
