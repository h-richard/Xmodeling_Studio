package xmodeling.contents;

public class PackageContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+";\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EAttribute;\r\n" +
            "import org.eclipse.emf.ecore.EClass;\r\n" +
            "import org.eclipse.emf.ecore.EOperation;\r\n" +
            "import org.eclipse.emf.ecore.EPackage;\r\n" +
            "import org.eclipse.emf.ecore.EReference;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * The <b>Package</b> for the model.\r\n" +
            " * It contains accessors for the meta objects to represent\r\n" +
            " * <ul>\r\n" +
            " *   <li>each class,</li>\r\n" +
            " *   <li>each feature of each class,</li>\r\n" +
            " *   <li>each operation of each class,</li>\r\n" +
            " *   <li>each enum,</li>\r\n" +
            " *   <li>and each data type</li>\r\n" +
            " * </ul>\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @see "+projectName+"."+projectClass+"Factory\r\n" +
            " * @model kind=\"package\"\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public interface "+projectClass+"Package extends EPackage {\r\n" +
            "	/**\r\n" +
            "	 * The package name.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	String eNAME = \""+projectClass+"\";\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The package namespace URI.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	String eNS_URI = \"platform:/resource/"+projectClass+"Exec/model/"+projectClass+".ecore\";\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The package namespace name.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	String eNS_PREFIX = \""+projectClass+"\";\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The singleton instance of the package.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	"+projectClass+"Package eINSTANCE = "+projectName+".impl."+projectClass+"PackageImpl.init();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The meta object id for the '{@link "+projectName+".impl.Xmod_OperationImpl <em>Xmod Operation</em>}' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @see "+projectName+".impl.Xmod_OperationImpl\r\n" +
            "	 * @see "+projectName+".impl."+projectClass+"PackageImpl#getXmod_Operation()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION = 0;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>Name</b></em>' attribute.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION__NAME = 0;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>Object Tag</b></em>' attribute.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION__OBJECT_TAG = 1;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>Parameters Tag</b></em>' attribute list.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION__PARAMETERS_TAG = 2;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>Return Tag</b></em>' attribute.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION__RETURN_TAG = 3;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The number of structural features of the '<em>Xmod Operation</em>' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION_FEATURE_COUNT = 4;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The operation id for the '<em>Execute</em>' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION___EXECUTE = 0;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The number of operations of the '<em>Xmod Operation</em>' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_OPERATION_OPERATION_COUNT = 1;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The meta object id for the '{@link "+projectName+".impl.Xmod_ActionImpl <em>Xmod Action</em>}' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @see "+projectName+".impl.Xmod_ActionImpl\r\n" +
            "	 * @see "+projectName+".impl."+projectClass+"PackageImpl#getXmod_Action()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION = 1;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>On Entry</b></em>' containment reference.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION__ON_ENTRY = 0;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>On Exit</b></em>' containment reference.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION__ON_EXIT = 1;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The feature id for the '<em><b>On Do</b></em>' containment reference.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION__ON_DO = 2;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The number of structural features of the '<em>Xmod Action</em>' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION_FEATURE_COUNT = 3;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The operation id for the '<em>On Entry</em>' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION___ON_ENTRY = 0;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The operation id for the '<em>On Exit</em>' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION___ON_EXIT = 1;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The operation id for the '<em>On Do</em>' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION___ON_DO = 2;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The number of operations of the '<em>Xmod Action</em>' class.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 * @ordered\r\n" +
            "	 */\r\n" +
            "	int XMOD_ACTION_OPERATION_COUNT = 3;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for class '{@link "+projectName+".Xmod_Operation <em>Xmod Operation</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for class '<em>Xmod Operation</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EClass getXmod_Operation();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the attribute '{@link "+projectName+".Xmod_Operation#getName <em>Name</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the attribute '<em>Name</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation#getName()\r\n" +
            "	 * @see #getXmod_Operation()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EAttribute getXmod_Operation_Name();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the attribute '{@link "+projectName+".Xmod_Operation#getObjectTag <em>Object Tag</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the attribute '<em>Object Tag</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation#getObjectTag()\r\n" +
            "	 * @see #getXmod_Operation()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EAttribute getXmod_Operation_ObjectTag();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the attribute list '{@link "+projectName+".Xmod_Operation#getParametersTag <em>Parameters Tag</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the attribute list '<em>Parameters Tag</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation#getParametersTag()\r\n" +
            "	 * @see #getXmod_Operation()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EAttribute getXmod_Operation_ParametersTag();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the attribute '{@link "+projectName+".Xmod_Operation#getReturnTag <em>Return Tag</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the attribute '<em>Return Tag</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation#getReturnTag()\r\n" +
            "	 * @see #getXmod_Operation()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EAttribute getXmod_Operation_ReturnTag();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the '{@link "+projectName+".Xmod_Operation#execute() <em>Execute</em>}' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the '<em>Execute</em>' operation.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation#execute()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EOperation getXmod_Operation__Execute();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for class '{@link "+projectName+".Xmod_Action <em>Xmod Action</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for class '<em>Xmod Action</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Action\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EClass getXmod_Action();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the containment reference '{@link "+projectName+".Xmod_Action#getOnEntry <em>On Entry</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the containment reference '<em>On Entry</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#getOnEntry()\r\n" +
            "	 * @see #getXmod_Action()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EReference getXmod_Action_OnEntry();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the containment reference '{@link "+projectName+".Xmod_Action#getOnExit <em>On Exit</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the containment reference '<em>On Exit</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#getOnExit()\r\n" +
            "	 * @see #getXmod_Action()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EReference getXmod_Action_OnExit();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the containment reference '{@link "+projectName+".Xmod_Action#getOnDo <em>On Do</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the containment reference '<em>On Do</em>'.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#getOnDo()\r\n" +
            "	 * @see #getXmod_Action()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EReference getXmod_Action_OnDo();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the '{@link "+projectName+".Xmod_Action#onEntry() <em>On Entry</em>}' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the '<em>On Entry</em>' operation.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#onEntry()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EOperation getXmod_Action__OnEntry();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the '{@link "+projectName+".Xmod_Action#onExit() <em>On Exit</em>}' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the '<em>On Exit</em>' operation.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#onExit()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EOperation getXmod_Action__OnExit();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the meta object for the '{@link "+projectName+".Xmod_Action#onDo() <em>On Do</em>}' operation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the meta object for the '<em>On Do</em>' operation.\r\n" +
            "	 * @see "+projectName+".Xmod_Action#onDo()\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	EOperation getXmod_Action__OnDo();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the factory that creates the instances of the model.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the factory that creates the instances of the model.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	"+projectClass+"Factory get"+projectClass+"Factory();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * Defines literals for the meta objects that represent\r\n" +
            "	 * <ul>\r\n" +
            "	 *   <li>each class,</li>\r\n" +
            "	 *   <li>each feature of each class,</li>\r\n" +
            "	 *   <li>each operation of each class,</li>\r\n" +
            "	 *   <li>each enum,</li>\r\n" +
            "	 *   <li>and each data type</li>\r\n" +
            "	 * </ul>\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	interface Literals {\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '{@link "+projectName+".impl.Xmod_OperationImpl <em>Xmod Operation</em>}' class.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @see "+projectName+".impl.Xmod_OperationImpl\r\n" +
            "		 * @see "+projectName+".impl."+projectClass+"PackageImpl#getXmod_Operation()\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EClass XMOD_OPERATION = eINSTANCE.getXmod_Operation();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EAttribute XMOD_OPERATION__NAME = eINSTANCE.getXmod_Operation_Name();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>Object Tag</b></em>' attribute feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EAttribute XMOD_OPERATION__OBJECT_TAG = eINSTANCE.getXmod_Operation_ObjectTag();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>Parameters Tag</b></em>' attribute list feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EAttribute XMOD_OPERATION__PARAMETERS_TAG = eINSTANCE.getXmod_Operation_ParametersTag();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>Return Tag</b></em>' attribute feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EAttribute XMOD_OPERATION__RETURN_TAG = eINSTANCE.getXmod_Operation_ReturnTag();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>Execute</b></em>' operation.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EOperation XMOD_OPERATION___EXECUTE = eINSTANCE.getXmod_Operation__Execute();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '{@link "+projectName+".impl.Xmod_ActionImpl <em>Xmod Action</em>}' class.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @see "+projectName+".impl.Xmod_ActionImpl\r\n" +
            "		 * @see "+projectName+".impl."+projectClass+"PackageImpl#getXmod_Action()\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EClass XMOD_ACTION = eINSTANCE.getXmod_Action();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Entry</b></em>' containment reference feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EReference XMOD_ACTION__ON_ENTRY = eINSTANCE.getXmod_Action_OnEntry();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Exit</b></em>' containment reference feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EReference XMOD_ACTION__ON_EXIT = eINSTANCE.getXmod_Action_OnExit();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Do</b></em>' containment reference feature.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EReference XMOD_ACTION__ON_DO = eINSTANCE.getXmod_Action_OnDo();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Entry</b></em>' operation.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EOperation XMOD_ACTION___ON_ENTRY = eINSTANCE.getXmod_Action__OnEntry();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Exit</b></em>' operation.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EOperation XMOD_ACTION___ON_EXIT = eINSTANCE.getXmod_Action__OnExit();\r\n" +
            "\r\n" +
            "		/**\r\n" +
            "		 * The meta object literal for the '<em><b>On Do</b></em>' operation.\r\n" +
            "		 * <!-- begin-user-doc -->\r\n" +
            "		 * <!-- end-user-doc -->\r\n" +
            "		 * @generated\r\n" +
            "		 */\r\n" +
            "		EOperation XMOD_ACTION___ON_DO = eINSTANCE.getXmod_Action__OnDo();\r\n" +
            "\r\n" +
            "	}\r\n" +
            "\r\n" +
            "} //"+projectClass+"Package\r\n";
    }
}
