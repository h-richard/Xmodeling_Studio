package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ElementImplContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
    """
            /**
             */
            package {0}.impl;
            
            import org.eclipse.emf.common.notify.Notification;
            
            import org.eclipse.emf.ecore.EClass;
            
            import org.eclipse.emf.ecore.impl.ENotificationImpl;
            import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
            
            import {0}.{1}Package;
            import {0}.Xmod_Element;
            
            /**
             * <!-- begin-user-doc -->
             * An implementation of the model object ''<em><b>Xmod Element</b></em>''.
             * <!-- end-user-doc -->
             * <p>
             * The following features are implemented:
             * </p>
             * <ul>
             *   <li>'{'@link {0}.impl.Xmod_ElementImpl#getXmod_id <em>Xmod id</em>'}'</li>
             * </ul>
             *
             * @generated
             */
            public abstract class Xmod_ElementImpl extends MinimalEObjectImpl.Container implements Xmod_Element '{'
                /**
                 * The default value of the '''{'@link #getXmod_id() <em>Xmod id</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getXmod_id()
                 * @generated
                 * @ordered
                 */
                protected static final String XMOD_ID_EDEFAULT = null;
            
                /**
                 * The cached value of the '''{'@link #getXmod_id() <em>Xmod id</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getXmod_id()
                 * @generated
                 * @ordered
                 */
                protected String xmod_id = XMOD_ID_EDEFAULT;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                protected Xmod_ElementImpl() '{'
                    super();
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                protected EClass eStaticClass() '{'
                    return {1}Package.Literals.XMOD_ELEMENT;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String getXmod_id() '{'
                    return xmod_id;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void setXmod_id(String newXmod_id) '{'
                    String oldXmod_id = xmod_id;
                    xmod_id = newXmod_id;
                    if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_ELEMENT__XMOD_ID, oldXmod_id, xmod_id));
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public Object eGet(int featureID, boolean resolve, boolean coreType) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_ELEMENT__XMOD_ID:
                            return getXmod_id();
                    '}'
                    return super.eGet(featureID, resolve, coreType);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void eSet(int featureID, Object newValue) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_ELEMENT__XMOD_ID:
                            setXmod_id((String)newValue);
                            return;
                    '}'
                    super.eSet(featureID, newValue);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void eUnset(int featureID) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_ELEMENT__XMOD_ID:
                            setXmod_id(XMOD_ID_EDEFAULT);
                            return;
                    '}'
                    super.eUnset(featureID);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public boolean eIsSet(int featureID) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_ELEMENT__XMOD_ID:
                            return XMOD_ID_EDEFAULT == null ? xmod_id != null : !XMOD_ID_EDEFAULT.equals(xmod_id);
                    '}'
                    return super.eIsSet(featureID);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String toString() '{'
                    if (eIsProxy()) return super.toString();
            
                    StringBuilder result = new StringBuilder(super.toString());
                    result.append(" (xmod_id: ");
                    result.append(xmod_id);
                    result.append('')'');
                    return result.toString();
                '}'
            
            '}' //Xmod_ElementImpl
            """,
        projectName, projectClass);
    }
}
