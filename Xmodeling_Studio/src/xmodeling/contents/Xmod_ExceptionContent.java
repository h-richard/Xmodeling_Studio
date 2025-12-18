package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ExceptionContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            /**
             */
            package {0};
            
            import org.eclipse.emf.ecore.EObject;
            
            /**
             * <!-- begin-user-doc -->
             * A representation of the model object '<em><b>Xmod Exception</b></em>'.
             * <!-- end-user-doc -->
             *
             * <p>
             * The following features are supported:
             * </p>
             * <ul>
             *   <li>'{'@link {0}.Xmod_Exception#getKind <em>Kind</em>'}'</li>
             *   <li>'{'@link {0}.Xmod_Exception#getFilter <em>Filter</em>'}'</li>
             *   <li>'{'@link {0}.Xmod_Exception#getReaction <em>Reaction</em>'}'</li>
             *   <li>'{'@link {0}.Xmod_Exception#getCalledOperation <em>Called Operation</em>'}'</li>
             * </ul>
             *
             * @see {0}.{1}Package#getXmod_Exception()
             * @model
             * @generated NOT
             */
            public interface Xmod_Exception extends EObject '{'
                /**
                 * Returns the value of the ''<em><b>Kind</b></em>'' attribute.
                 * The default value is <code>"ok"</code>.
                 * The kinds are from the enumeration '{'@link {0}.Xmod_ExceptionKind'}'.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the ''<em>Kind</em>'' attribute.
                 * @see {0}.Xmod_ExceptionKind
                 * @see #setKind(Xmod_ExceptionKind)
                 * @see {0}.{1}Package#getXmod_Exception_Kind()
                 * @model default="ok" required="true"
                 * @generated NOT
                 */
                Xmod_ExceptionKind getKind();
            
                /**
                 * Sets the value of the '''{'@link {0}.Xmod_Exception#getKind <em>Kind</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the new value of the ''<em>Kind</em>'' attribute.
                 * @see {0}.Xmod_ExceptionKind
                 * @see #getKind()
                 * @generated NOT
                 */
                void setKind(Xmod_ExceptionKind value);
            
                /**
                 * Returns the value of the ''<em><b>Filter</b></em>'' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the ''<em>Filter</em>'' attribute.
                 * @see #setFilter(String)
                 * @see {0}.{1}Package#getXmod_Exception_Filter()
                 * @model
                 * @generated NOT
                 */
                String getFilter();
            
                /**
                 * Sets the value of the '''{'@link {0}.Xmod_Exception#getFilter <em>Filter</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the new value of the ''<em>Filter</em>'' attribute.
                 * @see #getFilter()
                 * @generated NOT
                 */
                void setFilter(String value);
            
                /**
                 * Returns the value of the ''<em><b>Reaction</b></em>'' attribute.
                 * The default value is <code>"custom"</code>.
                 * The kinds are from the enumeration '{'@link {0}.Xmod_ExceptionReaction'}'.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the ''<em>Reaction</em>'' attribute.
                 * @see {0}.Xmod_ExceptionReaction
                 * @see #setReaction(Xmod_ExceptionReaction)
                 * @see {0}.{1}Package#getXmod_Exception_Reaction()
                 * @model default="custom" required="true"
                 * @generated NOT
                 */
                Xmod_ExceptionReaction getReaction();
            
                /**
                 * Sets the value of the '''{'@link {0}.Xmod_Exception#getReaction <em>Reaction</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the new value of the ''<em>Reaction</em>'' attribute.
                 * @see {0}.Xmod_ExceptionReaction
                 * @see #getReaction()
                 * @generated NOT
                 */
                void setReaction(Xmod_ExceptionReaction value);
            
                /**
                 * Returns the value of the ''<em><b>Called Operation</b></em>'' containment reference.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the ''<em>Called Operation</em>'' containment reference.
                 * @see #setCalledOperation(Xmod_Operation)
                 * @see {0}.{1}Package#getXmod_Exception_CalledOperation()
                 * @model containment="true"
                 * @generated NOT
                 */
                Xmod_Operation getCalledOperation();
            
                /**
                 * Sets the value of the '''{'@link {0}.Xmod_Exception#getCalledOperation <em>Called Operation</em>'}''' containment reference.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the new value of the ''<em>Called Operation</em>'' containment reference.
                 * @see #getCalledOperation()
                 * @generated NOT
                 */
                void setCalledOperation(Xmod_Operation value);
            
            '}' // Xmod_Exception
            """,
        projectName, projectClass);
    }
}
