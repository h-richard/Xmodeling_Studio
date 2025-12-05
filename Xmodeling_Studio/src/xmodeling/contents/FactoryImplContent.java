package xmodeling.contents;

public class FactoryImplContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+".impl;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EClass;\r\n" +
            "import org.eclipse.emf.ecore.EObject;\r\n" +
            "import org.eclipse.emf.ecore.EPackage;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.impl.EFactoryImpl;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.plugin.EcorePlugin;\r\n" +
            "\r\n" +
            "import "+projectName+".*;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * An implementation of the model <b>Factory</b>.\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public class "+projectClass+"FactoryImpl extends EFactoryImpl implements "+projectClass+"Factory {\r\n" +
            "	/**\r\n" +
            "	 * Creates the default factory implementation.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public static "+projectClass+"Factory init() {\r\n" +
            "		try {\r\n" +
            "			"+projectClass+"Factory the"+projectClass+"Factory = ("+projectClass+"Factory) EPackage.Registry.INSTANCE.getEFactory("+projectClass+"Package.eNS_URI);\r\n" +
            "			if (the"+projectClass+"Factory != null) {\r\n" +
            "				return the"+projectClass+"Factory;\r\n" +
            "			}\r\n" +
            "		} catch (Exception exception) {\r\n" +
            "			EcorePlugin.INSTANCE.log(exception);\r\n" +
            "		}\r\n" +
            "		return new "+projectClass+"FactoryImpl();\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates an instance of the factory.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public "+projectClass+"FactoryImpl() {\r\n" +
            "		super();\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	public EObject create(EClass eClass) {\r\n" +
            "		switch (eClass.getClassifierID()) {\r\n" +
            "		case "+projectClass+"Package.XMOD_OPERATION:\r\n" +
            "			return createXmod_Operation();\r\n" +
            "		case "+projectClass+"Package.XMOD_ACTION:\r\n" +
            "			return createXmod_Action();\r\n" +
            "		default:\r\n" +
            "			throw new IllegalArgumentException(\"The class '\" + eClass.getName() + \"' is not a valid classifier\");\r\n" +
            "		}\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public Xmod_Operation createXmod_Operation() {\r\n" +
            "		Xmod_OperationImpl xmod_Operation = new Xmod_OperationImpl();\r\n" +
            "		return xmod_Operation;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public Xmod_Action createXmod_Action() {\r\n" +
            "		Xmod_ActionImpl xmod_Action = new Xmod_ActionImpl();\r\n" +
            "		return xmod_Action;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public "+projectClass+"Package get"+projectClass+"Package() {\r\n" +
            "		return ("+projectClass+"Package) getEPackage();\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @deprecated\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Deprecated\r\n" +
            "	public static "+projectClass+"Package getPackage() {\r\n" +
            "		return "+projectClass+"Package.eINSTANCE;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "} //"+projectClass+"FactoryImpl\r\n";
    }
}
