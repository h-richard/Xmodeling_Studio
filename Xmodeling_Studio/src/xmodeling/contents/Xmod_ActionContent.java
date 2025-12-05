package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ActionContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            /**
             */
            package {0};
            
            import org.eclipse.emf.common.util.EList;
            
            /**
             * <!-- begin-user-doc -->
             * A representation of the model object '<em><b>Xmod Action</b></em>'.
             * <!-- end-user-doc -->
             *
             * <p>
             * The following features are supported:
             * </p>
             * <ul>
             *   <li>'{'@link {0}.Xmod_Action#getOperations <em>Operations</em>'}'</li>
             * </ul>
             *
             * @see {0}.{1}Package#getXmod_Action()
             * @model
             * @generated NOT
             */
            public interface Xmod_Action extends Xmod_Element '{'
                /**
                 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
                 * The list contents are of type '{'@link {0}.Xmod_Operation'}'.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the '<em>Operations</em>' containment reference list.
                 * @see {0}.{1}Package#getXmod_Action_Operations()
                 * @model containment="true" required="true"
                 * @generated NOT
                 */
                EList<Xmod_Operation> getOperations();
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @model
                 * @generated NOT
                 */
                Xmod_ExceptionReaction execute();
            
            '}' // Xmod_Action
            """,
        projectName, projectClass);
    }
}
