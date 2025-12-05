package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ElementContent implements FileContent {
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
             * A representation of the model object ''<em><b>Xmod Element</b></em>''.
             * <!-- end-user-doc -->
             *
             * <p>
             * The following features are supported:
             * </p>
             * <ul>
             *   <li>'{'@link {0}.Xmod_Element#getXmod_id <em>Xmod id</em>'}'</li>
             * </ul>
             *
             * @see {0}.{1}Package#getXmod_Element()
             * @model abstract="true"
             * @generated
             */
            public interface Xmod_Element extends EObject '{'
                /**
                 * Returns the value of the ''<em><b>Xmod id</b></em>'' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @return the value of the ''<em>Xmod id</em>'' attribute.
                 * @see #setXmod_id(String)
                 * @see {0}.{1}Package#getXmod_Element_Xmod_id()
                 * @model
                 * @generated
                 */
                String getXmod_id();
            
                /**
                 * Sets the value of the '''{'@link {0}.Xmod_Element#getXmod_id <em>Xmod id</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the new value of the ''<em>Xmod id</em>'' attribute.
                 * @see #getXmod_id()
                 * @generated
                 */
                void setXmod_id(String value);
            
            '}' // Xmod_Element
            """,
        projectName, projectClass);
    }
}
