package xmodeling.contents;

public class AdapterFactoryContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            "/**\r\n" +
            " */\r\n" +
            "package "+projectName+".util;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.common.notify.Adapter;\r\n" +
            "import org.eclipse.emf.common.notify.Notifier;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;\r\n" +
            "\r\n" +
            "import org.eclipse.emf.ecore.EObject;\r\n" +
            "\r\n" +
            "import "+projectName+".*;\r\n" +
            "\r\n" +
            "/**\r\n" +
            " * <!-- begin-user-doc -->\r\n" +
            " * The <b>Adapter Factory</b> for the model.\r\n" +
            " * It provides an adapter <code>createXXX</code> method for each class of the model.\r\n" +
            " * <!-- end-user-doc -->\r\n" +
            " * @see "+projectName+"."+projectClass+"Package\r\n" +
            " * @generated\r\n" +
            " */\r\n" +
            "public class "+projectClass+"AdapterFactory extends AdapterFactoryImpl {\r\n" +
            "	/**\r\n" +
            "	 * The cached model package.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	protected static "+projectClass+"Package modelPackage;\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates an instance of the adapter factory.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public "+projectClass+"AdapterFactory() {\r\n" +
            "		if (modelPackage == null) {\r\n" +
            "			modelPackage = "+projectClass+"Package.eINSTANCE;\r\n" +
            "		}\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Returns whether this factory is applicable for the type of the object.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return whether this factory is applicable for the type of the object.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	public boolean isFactoryForType(Object object) {\r\n" +
            "		if (object == modelPackage) {\r\n" +
            "			return true;\r\n" +
            "		}\r\n" +
            "		if (object instanceof EObject) {\r\n" +
            "			return ((EObject) object).eClass().getEPackage() == modelPackage;\r\n" +
            "		}\r\n" +
            "		return false;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * The switch that delegates to the <code>createXXX</code> methods.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	protected "+projectClass+"Switch<Adapter> modelSwitch = new "+projectClass+"Switch<Adapter>() {\r\n" +
            "		@Override\r\n" +
            "		public Adapter caseXmod_Operation(Xmod_Operation object) {\r\n" +
            "			return createXmod_OperationAdapter();\r\n" +
            "		}\r\n" +
            "\r\n" +
            "		@Override\r\n" +
            "		public Adapter caseXmod_Action(Xmod_Action object) {\r\n" +
            "			return createXmod_ActionAdapter();\r\n" +
            "		}\r\n" +
            "\r\n" +
            "		@Override\r\n" +
            "		public Adapter defaultCase(EObject object) {\r\n" +
            "			return createEObjectAdapter();\r\n" +
            "		}\r\n" +
            "	};\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates an adapter for the <code>target</code>.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @param target the object to adapt.\r\n" +
            "	 * @return the adapter for the <code>target</code>.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	@Override\r\n" +
            "	public Adapter createAdapter(Notifier target) {\r\n" +
            "		return modelSwitch.doSwitch((EObject) target);\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates a new adapter for an object of class '{@link "+projectName+".Xmod_Operation <em>Xmod Operation</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This default implementation returns null so that we can easily ignore cases;\r\n" +
            "	 * it's useful to ignore a case when inheritance will catch all the cases anyway.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the new adapter.\r\n" +
            "	 * @see "+projectName+".Xmod_Operation\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public Adapter createXmod_OperationAdapter() {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates a new adapter for an object of class '{@link "+projectName+".Xmod_Action <em>Xmod Action</em>}'.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This default implementation returns null so that we can easily ignore cases;\r\n" +
            "	 * it's useful to ignore a case when inheritance will catch all the cases anyway.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the new adapter.\r\n" +
            "	 * @see "+projectName+".Xmod_Action\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public Adapter createXmod_ActionAdapter() {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "	/**\r\n" +
            "	 * Creates a new adapter for the default case.\r\n" +
            "	 * <!-- begin-user-doc -->\r\n" +
            "	 * This default implementation returns null.\r\n" +
            "	 * <!-- end-user-doc -->\r\n" +
            "	 * @return the new adapter.\r\n" +
            "	 * @generated\r\n" +
            "	 */\r\n" +
            "	public Adapter createEObjectAdapter() {\r\n" +
            "		return null;\r\n" +
            "	}\r\n" +
            "\r\n" +
            "} //"+projectClass+"AdapterFactory\r\n";
    }
}
