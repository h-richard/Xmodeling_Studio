package xmodeling.contents;

public class SwitchFileContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+".util;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EObject;\r\n" +
            "import org.eclipse.emf.ecore.EPackage;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.util.Switch;\r\n" +
            "\r\n" +
            "import "+projectName+".*;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * The <b>Switch</b> for the model's inheritance hierarchy.\r\n" +
            " * It supports the call {@link #doSwitch(EObject) doSwitch(object)}\r\n" +
            " * to invoke the <code>caseXXX</code> method for each class of the model,\r\n" +
            " * starting with the actual class of the object\r\n" +
            " * and proceeding up the inheritance hierarchy\r\n" +
            " * until a non-null result is returned,\r\n" +
            " * which is the result of the switch.\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @see "+projectName+"."+projectClass+"Package\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public class "+projectClass+"Switch<T> extends Switch<T> {\r\n" +
            "	/**\r\n" +
            "	 * The cached model package\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	protected static "+projectClass+"Package modelPackage;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates an instance of the switch.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public "+projectClass+"Switch() {\r\n" +
            "		if (modelPackage == null) {\r\n" +
            "			modelPackage = "+projectClass+"Package.eINSTANCE;\r\n" +
            "		}\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Checks whether this is a switch for the given package.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @param ePackage the package in question.\r\n" +
            "	 * @return whether this is a switch for the given package.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	protected boolean isSwitchFor(EPackage ePackage) {\r\n" +
            "		return ePackage == modelPackage;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the first non-null result returned by a <code>caseXXX</code> call.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	protected T doSwitch(int classifierID, EObject theEObject) {\r\n" +
            "		switch (classifierID) {\r\n" +
            "		case "+projectClass+"Package.XMOD_OPERATION: {\r\n" +
            "			Xmod_Operation xmod_Operation = (Xmod_Operation) theEObject;\r\n" +
            "			T result = caseXmod_Operation(xmod_Operation);\r\n" +
            "			if (result == null)\r\n" +
            "				result = defaultCase(theEObject);\r\n" +
            "			return result;\r\n" +
            "		}\r\n" +
            "		case "+projectClass+"Package.XMOD_ACTION: {\r\n" +
            "			Xmod_Action xmod_Action = (Xmod_Action) theEObject;\r\n" +
            "			T result = caseXmod_Action(xmod_Action);\r\n" +
            "			if (result == null)\r\n" +
            "				result = defaultCase(theEObject);\r\n" +
            "			return result;\r\n" +
            "		}\r\n" +
            "		default:\r\n" +
            "			return defaultCase(theEObject);\r\n" +
            "		}\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the result of interpreting the object as an instance of '<em>Xmod Operation</em>'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This implementation returns null;\r\n" +
            "	 * returning a non-null result will terminate the switch.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @param object the target of the switch.\r\n" +
            "	 * @return the result of interpreting the object as an instance of '<em>Xmod Operation</em>'.\r\n" +
            "	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public T caseXmod_Operation(Xmod_Operation object) {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the result of interpreting the object as an instance of '<em>Xmod Action</em>'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This implementation returns null;\r\n" +
            "	 * returning a non-null result will terminate the switch.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @param object the target of the switch.\r\n" +
            "	 * @return the result of interpreting the object as an instance of '<em>Xmod Action</em>'.\r\n" +
            "	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public T caseXmod_Action(Xmod_Action object) {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This implementation returns null;\r\n" +
            "	 * returning a non-null result will terminate the switch, but this is the last case anyway.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @param object the target of the switch.\r\n" +
            "	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.\r\n" +
            "	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	public T defaultCase(EObject object) {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "} //"+projectClass+"Switch\r\n";
    }
}
