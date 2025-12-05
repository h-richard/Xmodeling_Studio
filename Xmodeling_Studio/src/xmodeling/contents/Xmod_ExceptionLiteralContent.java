package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ExceptionLiteralContent implements FileContent {
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
             * A representation of the literals of the enumeration ''<em><b>Xmod Exception Literal</b></em>'',
             * and utility methods for working with them.
             * <!-- end-user-doc -->
             * @see {0}.{1}Package#getXmod_ExceptionLiteral()
             * @model
             * @generated
             */
            public enum Xmod_ExceptionLiteral implements Enumerator '{'
                /**
                 * The ''<em><b>Ok</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OK_VALUE
                 * @generated
                 * @ordered
                 */
                OK(0, "ok", "ok"), /**
                 * The ''<em><b>Unknown Tag</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #UNKNOWN_TAG_VALUE
                 * @generated
                 * @ordered
                 */
                UNKNOWN_TAG(1, "unknownTag", "unknownTag"),
            
                /**
                 * The ''<em><b>Object Not Found</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OBJECT_NOT_FOUND_VALUE
                 * @generated
                 * @ordered
                 */
                OBJECT_NOT_FOUND(2, "objectNotFound", "objectNotFound"),
            
                /**
                 * The ''<em><b>Method Not Found</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_NOT_FOUND_VALUE
                 * @generated
                 * @ordered
                 */
                METHOD_NOT_FOUND(3, "methodNotFound", "methodNotFound"),
            
                /**
                 * The ''<em><b>Parameters Not Matching</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #PARAMETERS_NOT_MATCHING_VALUE
                 * @generated
                 * @ordered
                 */
                PARAMETERS_NOT_MATCHING(4, "parametersNotMatching", "parametersNotMatching"),
            
                /**
                 * The ''<em><b>Return Type Not Matching</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #RETURN_TYPE_NOT_MATCHING_VALUE
                 * @generated
                 * @ordered
                 */
                RETURN_TYPE_NOT_MATCHING(5, "returnTypeNotMatching", "returnTypeNotMatching"),
            
                /**
                 * The ''<em><b>Method Exception</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_EXCEPTION_VALUE
                 * @generated
                 * @ordered
                 */
                METHOD_EXCEPTION(6, "methodException", "methodException"), /**
                 * The ''<em><b>Other</b></em>'' literal object.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OTHER_VALUE
                 * @generated
                 * @ordered
                 */
                OTHER(7, "other", "other");
            
                /**
                 * The ''<em><b>Ok</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OK
                 * @model name="ok"
                 * @generated
                 * @ordered
                 */
                public static final int OK_VALUE = 0;
            
                /**
                 * The ''<em><b>Unknown Tag</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #UNKNOWN_TAG
                 * @model name="unknownTag"
                 * @generated
                 * @ordered
                 */
                public static final int UNKNOWN_TAG_VALUE = 1;
            
                /**
                 * The ''<em><b>Object Not Found</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OBJECT_NOT_FOUND
                 * @model name="objectNotFound"
                 * @generated
                 * @ordered
                 */
                public static final int OBJECT_NOT_FOUND_VALUE = 2;
            
                /**
                 * The ''<em><b>Method Not Found</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_NOT_FOUND
                 * @model name="methodNotFound"
                 * @generated
                 * @ordered
                 */
                public static final int METHOD_NOT_FOUND_VALUE = 3;
            
                /**
                 * The ''<em><b>Parameters Not Matching</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #PARAMETERS_NOT_MATCHING
                 * @model name="parametersNotMatching"
                 * @generated
                 * @ordered
                 */
                public static final int PARAMETERS_NOT_MATCHING_VALUE = 4;
            
                /**
                 * The ''<em><b>Return Type Not Matching</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #RETURN_TYPE_NOT_MATCHING
                 * @model name="returnTypeNotMatching"
                 * @generated
                 * @ordered
                 */
                public static final int RETURN_TYPE_NOT_MATCHING_VALUE = 5;
            
                /**
                 * The ''<em><b>Method Exception</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #METHOD_EXCEPTION
                 * @model name="methodException"
                 * @generated
                 * @ordered
                 */
                public static final int METHOD_EXCEPTION_VALUE = 6;
            
                /**
                 * The ''<em><b>Other</b></em>'' literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @see #OTHER
                 * @model name="other"
                 * @generated
                 * @ordered
                 */
                public static final int OTHER_VALUE = 7;
            
                /**
                 * An array of all the ''<em><b>Xmod Exception Literal</b></em>'' enumerators.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                private static final Xmod_ExceptionLiteral[] VALUES_ARRAY =
                    new Xmod_ExceptionLiteral[] '{'
                        OK,
                        UNKNOWN_TAG,
                        OBJECT_NOT_FOUND,
                        METHOD_NOT_FOUND,
                        PARAMETERS_NOT_MATCHING,
                        RETURN_TYPE_NOT_MATCHING,
                        METHOD_EXCEPTION,
                        OTHER,
                    '}';
            
                /**
                 * A public read-only list of all the ''<em><b>Xmod Exception Literal</b></em>'' enumerators.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                public static final List<Xmod_ExceptionLiteral> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
            
                /**
                 * Returns the ''<em><b>Xmod Exception Literal</b></em>'' literal with the specified literal value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param literal the literal.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated
                 */
                public static Xmod_ExceptionLiteral get(String literal) '{'
                    for (int i = 0; i < VALUES_ARRAY.length; ++i) '{'
                        Xmod_ExceptionLiteral result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal))
                            return result;
                    '}'
                    return null;
                '}'
            
                /**
                 * Returns the ''<em><b>Xmod Exception Literal</b></em>'' literal with the specified name.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param name the name.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated
                 */
                public static Xmod_ExceptionLiteral getByName(String name) '{'
                    for (int i = 0; i < VALUES_ARRAY.length; ++i) '{'
                        Xmod_ExceptionLiteral result = VALUES_ARRAY[i];
                        if (result.getName().equals(name))
                            return result;
                    '}'
                    return null;
                '}'
            
                /**
                 * Returns the ''<em><b>Xmod Exception Literal</b></em>'' literal with the specified integer value.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @param value the integer value.
                 * @return the matching enumerator or <code>null</code>.
                 * @generated
                 */
                public static Xmod_ExceptionLiteral get(int value) '{'
                    switch (value) '{'
                        case OK_VALUE: return OK;
                        case UNKNOWN_TAG_VALUE: return UNKNOWN_TAG;
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
                 * @generated
                 */
                private final int value;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                private final String name;
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                private final String literal;
            
                /**
                 * Only this class can construct instances.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                private Xmod_ExceptionLiteral(int value, String name, String literal) '{'
                    this.value = value;
                    this.name = name;
                    this.literal = literal;
                '}'
            
                /**
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public int getValue() '{'
                  return value;
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
                public String getLiteral() '{'
                  return literal;
                '}'
            
                /**
                 * Returns the literal value of the enumerator, which is its string representation.
                 * <!-- begin-user-doc -->
                 * <!-- end-user-doc -->
                 * @generated
                 */
                @Override
                public String toString() '{'
                    return literal;
                '}'
            
            } //Xmod_ExceptionLiteral
            """,
        projectName, projectClass);
    }
}
