package com.kobylynskyi.graphql.codegen.model;

/**
 * Freemarker data model field names
 *
 * @author kobylynskyi
 */
public final class DataModelFields {

    public static final String PACKAGE = "package";
    public static final String IMPORTS = "imports";
    public static final String CLASS_NAME = "className";
    public static final String NAME = "name";
    public static final String FIELDS = "fields";
    public static final String IMPLEMENTS = "implements";
    public static final String OPERATIONS = "operations";
    public static final String BUILDER = "builder";
    public static final String EQUALS_AND_HASH_CODE = "equalsAndHashCode";
    public static final String IMMUTABLE_MODELS = "immutableModels";
    public static final String TO_STRING = "toString";
    public static final String TO_STRING_FOR_REQUEST = "toStringForRequest";
    public static final String JAVA_DOC = "javaDoc";
    public static final String DEPRECATED = "deprecated";
    public static final String ANNOTATIONS = "annotations";
    public static final String OPERATION_TYPE = "operationType";
    public static final String OPERATION_NAME = "operationName";
    public static final String METHOD_NAME = "methodName";
    public static final String RETURN_TYPE_NAME = "returnTypeName";
    public static final String GENERATED_INFO = "generatedInfo";
    public static final String RESPONSE_PROJECTION_MAX_DEPTH = "responseProjectionMaxDepth";


    /**
     * growing extension
     */
    public static final String DEFAULT_RESOLVER_IMPL_PREFIX = "defaultResolverImplPrefix";
    public static final String OPERATE_NAME_REQUEST_NAME = "operateNameRequestName";
    public static final String OPERATE_NAME_PROJECTION_NAME = "operateNameProjectionName";
    public static final String OPERATE_NAME_RESPONSE_NAME = "operateNameResponseName";


    private DataModelFields() {
    }

}
