package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_OperationImplContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            /**
             */
            package {0}.impl;
            
            import {0}.{1}Package;
            import {0}.Xmod_Element;
            import {0}.Xmod_Exception;
            import {0}.Xmod_ExceptionLiteral;
            import {0}.Xmod_Operation;
            import {0}.util.TypeResolver;
            import exceptions.ParametersNotMatchingException;
            import exceptions.ReturnTypeNotMatchingException;
            import exceptions.ExceptionContext;
            import exceptions.MethodNotFoundException;
            import exceptions.ObjectNotFoundException;
            import exceptions.UnknownTagException;
            
            import static {0}.Xmod_ExceptionLiteral.*;
            
            import java.lang.reflect.Array;
            import java.lang.reflect.Constructor;
            import java.lang.reflect.InvocationTargetException;
            
            import java.lang.reflect.Method;
            import java.lang.reflect.modifier;
            import java.util.Arrays;
            import java.util.Collection;
            import java.util.Collections;
            import java.util.List;
            import java.util.Map;
            import java.util.stream.Collectors;
            
            import org.eclipse.emf.common.notify.Notification;
            import org.eclipse.emf.common.notify.NotificationChain;
            import org.eclipse.emf.common.util.BasicEList;
            import org.eclipse.emf.common.util.EList;
            
            import org.eclipse.emf.ecore.EClass;
            import org.eclipse.emf.ecore.InternalEObject;
            import org.eclipse.emf.ecore.impl.ENotificationImpl;
            import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
            
            import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
            import org.eclipse.emf.ecore.util.EObjectContainmentEList;
            import org.eclipse.emf.ecore.util.InternalEList;
            
            /**
             * <!-- begin-user-doc -->
             * An implementation of the model object ''<em><b>Xmod Operation</b></em>''.
             * <!-- end-user-doc -->
             * <p>
             * The following features are implemented:
             * </p>
             * <ul>
             *   <li>'{'@link {0}.impl.Xmod_OperationImpl#getName <em>Name</em>'}'</li>
             *   <li>'{'@link {0}.impl.Xmod_OperationImpl#getObjectTag <em>Object Tag</em>'}'</li>
             *   <li>'{'@link {0}.impl.Xmod_OperationImpl#getParametersTag <em>Parameters Tag</em>'}'</li>
             *   <li>'{'@link {0}.impl.Xmod_OperationImpl#getReturnTag <em>Return Tag</em>'}'</li>
             *   <li>'{'@link {0}.impl.Xmod_OperationImpl#getExceptions <em>Exceptions</em>'}'</li>
             * </ul>
             *
             * @generated
             */
            public class Xmod_OperationImpl extends MinimalEObjectImpl.Container implements Xmod_Operation '{'
            
                private static final String JAVA_TAG = "java";
                private static final String MODEL_TAG = "model";
                private static final String EXTERNAL_TAG = "ext";
                private static final String TAG_SEPARATOR = ":";
            
                private Xmod_Exception EOK;
            
                /**
                 * The default value of the '''{'@link #getName() <em>Name</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getName()
                 * @generated
                 * @ordered
                 */
                protected static final String NAME_EDEFAULT = null;
            
                /**
                 * The cached value of the '''{'@link #getName() <em>Name</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getName()
                 * @generated
                 * @ordered
                 */
                protected String name = NAME_EDEFAULT;
            
                /**
                 * The default value of the '''{'@link #getObjectTag() <em>Object Tag</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getObjectTag()
                 * @generated
                 * @ordered
                 */
                protected static final String OBJECT_TAG_EDEFAULT = null;
            
                /**
                 * The cached value of the '''{'@link #getObjectTag() <em>Object Tag</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getObjectTag()
                 * @generated
                 * @ordered
                 */
                protected String objectTag = OBJECT_TAG_EDEFAULT;
            
                /**
                 * The cached value of the '''{'@link #getParametersTag() <em>Parameters Tag</em>'}''' attribute list.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getParametersTag()
                 * @generated
                 * @ordered
                 */
                protected EList<String> parametersTag;
            
                /**
                 * The default value of the '''{'@link #getReturnTag() <em>Return Tag</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getReturnTag()
                 * @generated
                 * @ordered
                 */
                protected static final String RETURN_TAG_EDEFAULT = null;
            
                /**
                 * The cached value of the '''{'@link #getReturnTag() <em>Return Tag</em>'}''' attribute.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getReturnTag()
                 * @generated
                 * @ordered
                 */
                protected String returnTag = RETURN_TAG_EDEFAULT;
            
                /**
                 * The cached value of the '''{'@link #getExceptions() <em>Exceptions</em>'}''' containment reference list.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #getExceptions()
                 * @generated
                 * @ordered
                 */
                protected EList<Xmod_Exception> exceptions;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                protected Xmod_OperationImpl() '{'
                    super();
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                protected EClass eStaticClass() '{'
                    return {1}Package.Literals.XMOD_OPERATION;
                '}'
            
                public void setEOK(Xmod_Exception xme) '{'
                    EOK = xme;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String getName() '{'
                    return name;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void setName(String newName) '{'
                    String oldName = name;
                    name = newName;
                    if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_OPERATION__NAME, oldName, name));
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String getObjectTag() '{'
                    return objectTag;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void setObjectTag(String newObjectTag) '{'
                    String oldObjectTag = objectTag;
                    objectTag = newObjectTag;
                    if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_OPERATION__OBJECT_TAG, oldObjectTag, objectTag));
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public EList<String> getParametersTag() '{'
                    if (parametersTag == null) '{'
                        parametersTag = new EDataTypeUniqueEList<String>(String.class, this, {1}Package.XMOD_OPERATION__PARAMETERS_TAG);
                    '}'
                    return parametersTag;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String getReturnTag() '{'
                    return returnTag;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public void setReturnTag(String newReturnTag) '{'
                    String oldReturnTag = returnTag;
                    returnTag = newReturnTag;
                    if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_OPERATION__RETURN_TAG, oldReturnTag, returnTag));
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public EList<Xmod_Exception> getExceptions() '{'
                    if (exceptions == null) '{'
                        exceptions = new EObjectContainmentEList<Xmod_Exception>(Xmod_Exception.class, this, {1}Package.XMOD_OPERATION__EXCEPTIONS);
                    '}'
                    return exceptions;
                '}'
            
                @Override
                public Xmod_Exception getException(Xmod_ExceptionLiteral literal) '{'
                    for (Xmod_Exception e : getExceptions())
                        if (e.getLiteral() == literal)
                            return e;
                    return null;
                '}'
            
                @Override
                public Xmod_Exception getException(Xmod_ExceptionLiteral literal, String filter) '{'
                    for (Xmod_Exception e : getExceptions())
                        if (e.getLiteral() == literal && e.getFilter().equals(filter))
                            return e;
                    return null;
                '}'
            
                @Override
                public void addException(Xmod_Exception xme) '{'
                    getExceptions().add(xme);
                '}'
            
                            /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private static Method findHighestMethod(Class<?> cls, String methodName, Class<?>... paramClass) '{'
            
                    for (Class<?> iface : cls.getInterfaces()) '{'
                        Method ifaceMethod = findHighestMethod(iface, methodName, paramClass);
                        if (ifaceMethod != null)
                            return ifaceMethod;
                    '}'
            
                    if (cls.getSuperclass() != null) '{'
                        Method parentMethod = findHighestMethod(cls.getSuperclass(), methodName, paramClass);
                        if (parentMethod != null)
                            return parentMethod;
                    '}'
            
                    try '{'
                        Method method = cls.getMethod(methodName, paramClass);
                        return method;
                    '}'
                    catch(NoSuchMethodException nsme) '{'
                        return null;
                    '}'
                }
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @Override
                public Xmod_Exception callOperation() '{'
            
                    /* Init */
                    Object returnValue; // Returned object by the method
                    Class<?>[] parametersType = null;
                    Method m;
                    Object[] parameters = null;
            
                    /* Body */
                    if (getObjectTag() != null) '{' // check if the object on which the operation is being called has an annotation
                        // in case there are one or more parameters
                        try '{'
                            if (getParametersTag() != null) '{'
                                parametersType = new Class[getParametersTag().size()];
                                parameters = new Object[getParametersTag().size()];
                                // browsing of the list of parameters of the operation
                                for (int i = 0; i < getParametersTag().size(); i++) '{'
                                    if (getParametersTag().get(i) != null) '{' // check if the item has an annotation
                                        Object target = getTarget(getParametersTag().get(i), 0, 0);
                                        parameters[i] = target;
                                        parametersType[i] = target.getClass();
                                    '}'
                                '}'
                            '}'
            
                            // dynamic invocation
                            Object owner = getTarget(getObjectTag(), 0, 0);
                            m = getMethod(owner, getName(), parametersType);
                            // if the method is static
                            if (modifier.isStatic(m.getmodifiers())) '{'
                                returnValue = m.invoke(null, parameters);
                            // if not
                            '}' else '{'
                                returnValue = m.invoke(owner, parameters);
                            '}'
            
                            // update of the hashmap
                            if (getReturnTag() != null) '{'
                                String[] couple = getReturnTag().split(TAG_SEPARATOR);
                                String[] chain = couple[1].split("\\.");
            
                                // is a model object
                                if (couple[0].equals(MODEL_TAG)) '{'
                                    String targetPropertyName = chain[chain.length-1];
                                    Object target = getTarget(getReturnTag(), 0, -1);
                                    Object targetProperty = getTarget(getReturnTag(), 0, 0);
            
                                    // check if the object can be assigned with the returning type
                                    if (!targetProperty.getClass().isAssignableFrom(returnValue.getClass()))
                                        throw new ReturnTypeNotMatchingException(
                                                returnValue.getClass().getSimpleName()+" isn''t assignable to ("+targetProperty.getClass()+")");
            
                                    Method setter = getMethod(target, "set" + capitalize(targetPropertyName), targetProperty.getClass());
                                    setter.invoke(target, returnValue);
            
                                // is external to the model
                                else if (couple[0].equals(EXTERNAL_TAG)) '{'
                                    {0}.util.{1}Utils.getExtMap().put(getReturnTag().split(":")[1], returnValue);
                                '}' else '{'
                                    throw new UnknownTagException(couple[0]);
                                '}'
                            '}'
                        '}'
            
                        catch (Exception e) '{'
                            Exception savedException = e instanceof InvocationTargetException ? (Exception) e.getCause() : e;
            
                            {0}.util.{1}Utils.getExtMap().put(ExceptionContext.CONTEXT_KEY,
                                    new ExceptionContext(savedException, getName(), (String[]) getParametersTag().toArray()));
            
                            Xmod_ExceptionLiteral lit;
                            if (e instanceof UnknownTagException) lit = UNKNOWN_TAG;
                            else if (e instanceof ObjectNotFoundException) lit = OBJECT_NOT_FOUND;
                            else if (e instanceof MethodNotFoundException) lit = METHOD_NOT_FOUND;
                            else if (e instanceof ParametersNotMatchingException) lit = PARAMETERS_NOT_MATCHING;
                            else if (e instanceof ReturnTypeNotMatchingException) lit = RETURN_TYPE_NOT_MATCHING;
                            else if (e instanceof InvocationTargetException) lit = METHOD_EXCEPTION;
                            else '{'
                                e.printStackTrace();
                                return null;
                            '}'
            
                            Xmod_Exception xme = lit == METHOD_EXCEPTION ? getException(lit, savedException.getClass().getSimpleName()) : getException(lit);
                            return xme == null ? getException(Xmod_ExceptionLiteral.OTHER) : xme;
                        '}'
                    '}'
            
                    return EOK;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_OPERATION__EXCEPTIONS:
                            return ((InternalEList<?>)getExceptions()).basicRemove(otherEnd, msgs);
                    '}'
                    return super.eInverseRemove(otherEnd, featureID, msgs);
                '}'
            
                            /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private static String capitalize(String s) '{'
                    return s.substring(0, 1).toUpperCase() + s.substring(1);
                }
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private static Method getMethod(Object target, String methodName, Class<?>... paramsType) throws MethodNotFoundException, ParametersNotMatchingException '{'
                    Class<?> owningClass = target.getClass();
            
                    List<Method> candidates = Arrays.stream(owningClass.getMethods())
                            .filter(m -> m.getName().equals(methodName))
                            .collect(Collectors.toList());
            
                    if (candidates.isEmpty())
                        throw new MethodNotFoundException("''"+methodName+"'' in ''"+target.getClass().getSimpleName()+"''");
            
                    for (Method m : candidates) '{'
                        Class<?>[] pt = m.getParameterTypes();
                        if (pt.length != paramsType.length) continue;
                        boolean compatible = true;
                        for (int i = 0; i < pt.length; i++)
                            if (!pt[i].isAssignableFrom(paramsType[i])) '{'
                                compatible = false;
                                break;
                            '}'
                        if (compatible) return m;
                    '}'
            
                    throw new ParametersNotMatchingException(methodName+"("+
                            Arrays	.stream(paramsType)
                                    .map(Class::getSimpleName)
                                    .collect(Collectors.joining(", "))+")");
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * Returns the object targeted by this string, starting the search at "startOffset" and ending it at "endOffset" tokens before the last one.
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private static Object getTarget(String params, int startOffset, int endOffset) throws UnknownTagException, ObjectNotFoundException, MethodNotFoundException, ParametersNotMatchingException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, NoSuchMethodException, SecurityException, InstantiationException '{'
                    String[] couple = params.split(TAG_SEPARATOR,2);
            
                    // is an orphan object to create
                    if (couple[0].equals(JAVA_TAG)) '{'
                        int open = couple[1].indexOf(''('');
                        int close = couple[1].indexOf('')'');
                        String classStr = couple[1].substring(0,open);
                        String content = couple[1].substring(open + 1,close);
            
                        String[] pStr = content.split(",");
                        int length = pStr.length;
                        Object[] parameters = new Object[length];
                        Class<?>[] parametersType = new Class<?>[length];
                        for (int i = 0; i < length; i++) '{'
                            if (pStr[i].contains(":")) parameters[i] = getTarget(pStr[i],0,0);
                            else parameters[i] = null; // TODO: possible valeur literale
                            parametersType[i] = TypeResolver.tryUnbox(parameters[i].getClass());
                        '}'
            
                        Class<?> classType = TypeResolver.resolve(classStr);
                        Constructor<?> constructor = classType.getConstructor(parametersType);
                        return constructor.newInstance(parameters);
                    '}'
            
                    // is a model object
                    if (couple[0].equals(MODEL_TAG)) '{'
                        String[] split = couple[1].split("\\\\.");
                        Map<String,Object> map = {0}.util.{1}Utils.getmodelMap();
                        String chain = String.join(".", Arrays.copyOfRange(split, startOffset + 1, split.length + endOffset));
            
                        if (split[0].equals("this"))
                            return getDeepTarget(null, chain); // TODO: null -> parent
            
                        Object mappedTarget = map.get(split[0]);
                        if (mappedTarget == null)
                            throw new ObjectNotFoundException(split[0]);
                        return getDeepTarget(mappedTarget, chain);
                    '}'
            
                    // is external to the model
                    if (couple[0].equals(EXTERNAL_TAG)) '{'
                        String[] split = couple[1].split("\\\\.");
                        Map<String,Object> map = {0}.util.{1}Utils.getExtMap();
                        String chain = String.join(".", Arrays.copyOfRange(split, startOffset + 1, split.length + endOffset));
            
                        Object mappedTarget = map.get(split[0]);
                        if (mappedTarget == null)
                            throw new ObjectNotFoundException(split[0]);
                        return getDeepTarget(mappedTarget, chain);
                    '}'
            
                    // is unrecognized
                    throw new UnknownTagException(couple[0]);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @SuppressWarnings("unchecked")
                private static Object getDeepTarget(Object target, String params) throws ObjectNotFoundException, MethodNotFoundException, ParametersNotMatchingException, InvocationTargetException, IllegalAccessException, NoSuchMethodException '{'
                    if (params == null || params.isEmpty()) return target;
            
                    String[] parts = params.split("\\\\.", 2);
                    String current = parts[0];
                    String remain = parts.length > 1 ? parts[1] : "";
            
                    if (current.contains("[")) '{'
                        int open = current.indexOf(''['');
                        int close = current.indexOf('']'');
                        String propertyName = current.substring(0,open);
                        String subpropertyName = current.substring(open + 1, close);
            
                        Method g = getMethod(target, "get" + capitalize(propertyName));
                        List<Object> list = (List<Object>) g.invoke(target);
                        target = null;
                        for (Object obj : list) '{'
                            if (obj instanceof Xmod_Element e) '{'
                                if (e.getXmod_id().equals(subpropertyName)) target = e;
                            '}'
                        '}'
            
                    '}' else '{'
                        Method g = getMethod(target, "get" + capitalize(current));
                        target = g.invoke(target);
                    '}'
            
                    if (target == null)
                        throw new ObjectNotFoundException(current);
                    if (remain.isBlank()) return target;
                    return getDeepTarget(target, remain);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public Object eGet(int featureID, boolean resolve, boolean coreType) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_OPERATION__NAME:
                            return getName();
                        case {1}Package.XMOD_OPERATION__OBJECT_TAG:
                            return getObjectTag();
                        case {1}Package.XMOD_OPERATION__PARAMETERS_TAG:
                            return getParametersTag();
                        case {1}Package.XMOD_OPERATION__RETURN_TAG:
                            return getReturnTag();
                        case {1}Package.XMOD_OPERATION__EXCEPTIONS:
                            return getExceptions();
                    '}'
                    return super.eGet(featureID, resolve, coreType);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @SuppressWarnings("unchecked")
                @Override
                public void eSet(int featureID, Object newValue) '{'
                    switch (featureID) '{'
                        case {1}Package.XMOD_OPERATION__NAME:
                            setName((String)newValue);
                            return;
                        case {1}Package.XMOD_OPERATION__OBJECT_TAG:
                            setObjectTag((String)newValue);
                            return;
                        case {1}Package.XMOD_OPERATION__PARAMETERS_TAG:
                            getParametersTag().clear();
                            getParametersTag().addAll((Collection<? extends String>)newValue);
                            return;
                        case {1}Package.XMOD_OPERATION__RETURN_TAG:
                            setReturnTag((String)newValue);
                            return;
                        case {1}Package.XMOD_OPERATION__EXCEPTIONS:
                            getExceptions().clear();
                            getExceptions().addAll((Collection<? extends Xmod_Exception>)newValue);
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
                        case {1}Package.XMOD_OPERATION__NAME:
                            setName(NAME_EDEFAULT);
                            return;
                        case {1}Package.XMOD_OPERATION__OBJECT_TAG:
                            setObjectTag(OBJECT_TAG_EDEFAULT);
                            return;
                        case {1}Package.XMOD_OPERATION__PARAMETERS_TAG:
                            getParametersTag().clear();
                            return;
                        case {1}Package.XMOD_OPERATION__RETURN_TAG:
                            setReturnTag(RETURN_TAG_EDEFAULT);
                            return;
                        case {1}Package.XMOD_OPERATION__EXCEPTIONS:
                            getExceptions().clear();
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
                        case {1}Package.XMOD_OPERATION__NAME:
                            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
                        case {1}Package.XMOD_OPERATION__OBJECT_TAG:
                            return OBJECT_TAG_EDEFAULT == null ? objectTag != null : !OBJECT_TAG_EDEFAULT.equals(objectTag);
                        case {1}Package.XMOD_OPERATION__PARAMETERS_TAG:
                            return parametersTag != null && !parametersTag.isEmpty();
                        case {1}Package.XMOD_OPERATION__RETURN_TAG:
                            return RETURN_TAG_EDEFAULT == null ? returnTag != null : !RETURN_TAG_EDEFAULT.equals(returnTag);
                        case {1}Package.XMOD_OPERATION__EXCEPTIONS:
                            return exceptions != null && !exceptions.isEmpty();
                    '}'
                    return super.eIsSet(featureID);
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException '{'
                    switch (operationID) '{'
                        case {1}Package.XMOD_OPERATION___CALL_OPERATION:
                            return callOperation();
                    '}'
                    return super.eInvoke(operationID, arguments);
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
                    result.append(" (name: ");
                    result.append(name);
                    result.append(", objectTag: ");
                    result.append(objectTag);
                    result.append(", parametersTag: ");
                    result.append(parametersTag);
                    result.append(", returnTag: ");
                    result.append(returnTag);
                    result.append('')'');
                    return result.toString();
                '}'
            
            '}' //Xmod_OperationImpl
            """,
        projectName, projectClass);
    }
}
