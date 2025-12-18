package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ExceptionKindContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            /**
             */
            package {0};
            
            import java.util.Arrays;
            import java.util.Collections;
            import java.util.List;
            
            import org.eclipse.emf.common.util.Enumerator;
            
            /**
             * <!-- begin-user-doc -->
             * A representation of the kinds of the enumeration ''<em><b>Xmod Exception Kind</b></em>'',
             * and utility methods for working with them.
             * <!-- end-user-doc -->
             * @see {0}.{1}Package#getXmod_ExceptionKind()
             * @model
             * @generated NOT
             */
            public enum Xmod_ExceptionKind implements Enumerator '{'
                /**
                 * The ''<em><b>Ok</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OK_VALUE
                 * @generated NOT
                 * @ordered
                 */
                OK(0, "ok", "ok"), /**
                 * The ''<em><b>Unknown Namespace</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #UNKNOWN_NAMESPACE_VALUE
                 * @generated NOT
                 * @ordered
                 */
                UNKNOWN_NAMESPACE(1, "unknownNamespace", "unknownNamespace"),
            
                /**
                 * The ''<em><b>Object Not Found</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OBJECT_NOT_FOUND_VALUE
                 * @generated NOT
                 * @ordered
                 */
                OBJECT_NOT_FOUND(2, "objectNotFound", "objectNotFound"),
            
                /**
                 * The ''<em><b>Method Not Found</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_NOT_FOUND_VALUE
                 * @generated NOT
                 * @ordered
                 */
                METHOD_NOT_FOUND(3, "methodNotFound", "methodNotFound"),
            
                /**
                 * The ''<em><b>Parameters Not Matching</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #PARAMETERS_NOT_MATCHING_VALUE
                 * @generated NOT
                 * @ordered
                 */
                PARAMETERS_NOT_MATCHING(4, "parametersNotMatching", "parametersNotMatching"),
            
                /**
                 * The ''<em><b>Return Type Not Matching</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #RETURN_TYPE_NOT_MATCHING_VALUE
                 * @generated NOT
                 * @ordered
                 */
                RETURN_TYPE_NOT_MATCHING(5, "returnTypeNotMatching", "returnTypeNotMatching"),
            
                /**
                 * The ''<em><b>Method Exception</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_EXCEPTION_VALUE
                 * @generated NOT
                 * @ordered
                 */
                METHOD_EXCEPTION(6, "methodException", "methodException"), /**
                 * The ''<em><b>Other</b></em>'' kind object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OTHER_VALUE
                 * @generated NOT
                 * @ordered
                 */
                OTHER(7, "other", "other");
            
                /**
                 * The ''<em><b>Ok</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OK
                 * @model name="ok"
                 * @generated NOT
                 * @ordered
                 */
                public static final int OK_VALUE = 0;
            
                /**
                 * The ''<em><b>Unknown Namespace</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #UNKNOWN_NAMESPACE
                 * @model name="unknownNamespace"
                 * @generated NOT
                 * @ordered
                 */
                public static final int UNKNOWN_NAMESPACE_VALUE = 1;
            
                /**
                 * The ''<em><b>Object Not Found</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OBJECT_NOT_FOUND
                 * @model name="objectNotFound"
                 * @generated NOT
                 * @ordered
                 */
                public static final int OBJECT_NOT_FOUND_VALUE = 2;
            
                /**
                 * The ''<em><b>Method Not Found</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_NOT_FOUND
                 * @model name="methodNotFound"
                 * @generated NOT
                 * @ordered
                 */
                public static final int METHOD_NOT_FOUND_VALUE = 3;
            
                /**
                 * The ''<em><b>Parameters Not Matching</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #PARAMETERS_NOT_MATCHING
                 * @model name="parametersNotMatching"
                 * @generated NOT
                 * @ordered
                 */
                public static final int PARAMETERS_NOT_MATCHING_VALUE = 4;
            
                /**
                 * The ''<em><b>Return Type Not Matching</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #RETURN_TYPE_NOT_MATCHING
                 * @model name="returnTypeNotMatching"
                 * @generated NOT
                 * @ordered
                 */
                public static final int RETURN_TYPE_NOT_MATCHING_VALUE = 5;
            
                /**
                 * The ''<em><b>Method Exception</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_EXCEPTION
                 * @model name="methodException"
                 * @generated NOT
                 * @ordered
                 */
                public static final int METHOD_EXCEPTION_VALUE = 6;
            
                /**
                 * The ''<em><b>Other</b></em>'' kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OTHER
                 * @model name="other"
                 * @generated NOT
                 * @ordered
                 */
                public static final int OTHER_VALUE = 7;
            
                /**
                 * An array of all the ''<em><b>Xmod Exception Kind</b></em>'' enumerators.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private static final Xmod_ExceptionKind[] VALUES_ARRAY =
                    new Xmod_ExceptionKind[] '{'
                        OK,
                        UNKNOWN_NAMESPACE,
                        OBJECT_NOT_FOUND,
                        METHOD_NOT_FOUND,
                        PARAMETERS_NOT_MATCHING,
                        RETURN_TYPE_NOT_MATCHING,
                        METHOD_EXCEPTION,
                        OTHER,
                    '}';
            
                /**
                 * A public read-only list of all the ''<em><b>Xmod Exception Kind</b></em>'' enumerators.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                public static final List<Xmod_ExceptionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
            
                /**
                 * Returns the ''<em><b>Xmod Exception Kind</b></em>'' kind with the specified kind value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param kind the kind.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated NOT
                 */
                public static Xmod_ExceptionKind get(String kind) '{'
                    for (int i = 0; i < VALUES_ARRAY.length; ++i) '{'
                        Xmod_ExceptionKind result = VALUES_ARRAY[i];
                        if (result.toString().equals(kind))
                            return result;
                    '}'
                    return null;
                '}'
            
                /**
                 * Returns the ''<em><b>Xmod Exception Kind</b></em>'' kind with the specified name.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param name the name.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated NOT
                 */
                public static Xmod_ExceptionKind getByName(String name) '{'
                    for (int i = 0; i < VALUES_ARRAY.length; ++i) '{'
                        Xmod_ExceptionKind result = VALUES_ARRAY[i];
                        if (result.getName().equals(name))
                            return result;
                    '}'
                    return null;
                '}'
            
                /**
                 * Returns the ''<em><b>Xmod Exception Kind</b></em>'' kind with the specified integer value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the integer value.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated NOT
                 */
                public static Xmod_ExceptionKind get(int value) '{'
                    switch (value) '{'
                        case OK_VALUE: return OK;
                        case UNKNOWN_NAMESPACE_VALUE: return UNKNOWN_NAMESPACE;
                        case OBJECT_NOT_FOUND_VALUE: return OBJECT_NOT_FOUND;
                        case METHOD_NOT_FOUND_VALUE: return METHOD_NOT_FOUND;
                        case PARAMETERS_NOT_MATCHING_VALUE: return PARAMETERS_NOT_MATCHING;
                        case RETURN_TYPE_NOT_MATCHING_VALUE: return RETURN_TYPE_NOT_MATCHING;
                        case METHOD_EXCEPTION_VALUE: return METHOD_EXCEPTION;
                        case OTHER_VALUE: return OTHER;
                    '}'
                    return null;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private final int value;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private final String name;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private final String kind;
            
                /**
                 * Only this class can construct instances.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                private Xmod_ExceptionKind(int value, String name, String kind) '{'
                    this.value = value;
                    this.name = name;
                    this.kind = kind;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @Override
                public int getValue() '{'
                  return value;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @Override
                public String getName() '{'
                  return name;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @Override
                public String getLiteral() '{'
                  return kind;
                '}'
            
                /**
                 * Returns the kind value of the enumerator, which is its string representation.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated NOT
                 */
                @Override
                public String toString() '{'
                    return kind;
                '}'
            
            } //Xmod_ExceptionKind
            """,
        projectName, projectClass);
    }
}
