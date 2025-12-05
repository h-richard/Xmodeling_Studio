package xmodeling.contents;

public class FactoryContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+";\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EFactory;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * The <b>Factory</b> for the model.\r\n" +
            " * It provides a create method for each non-abstract class of the model.\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @see "+projectName+"."+projectClass+"Package\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public interface "+projectClass+"Factory extends EFactory {\r\n" +
            "	/**\r\n" +
            "	 * The singleton instance of the factory.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	"+projectClass+"Factory eINSTANCE = "+projectName+".impl."+projectClass+"FactoryImpl.init();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns a new object of class '<em>Xmod Operation</em>'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return a new object of class '<em>Xmod Operation</em>'.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	Xmod_Operation createXmod_Operation();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns a new object of class '<em>Xmod Action</em>'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return a new object of class '<em>Xmod Action</em>'.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	Xmod_Action createXmod_Action();\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the package supported by this factory.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the package supported by this factory.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	"+projectClass+"Package get"+projectClass+"Package();\r\n" +
            "\r\n" +
            "} //"+projectClass+"Factory\r\n";
    }
}
