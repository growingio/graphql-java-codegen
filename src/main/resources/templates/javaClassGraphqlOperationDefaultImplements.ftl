<#if package?has_content>
package ${package};

</#if>
import com.kobylynskyi.graphql.codegen.extension.GrowingIOConfig;
import com.kobylynskyi.graphql.codegen.extension.utils.JavaCollectionUtils;
import com.kobylynskyi.graphql.codegen.extension.utils.OkHttpUtil;
import com.kobylynskyi.graphql.codegen.model.graphql.GraphQLRequest;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
<#list imports as import>
<#if import?has_content>
import ${import}.*;
</#if>
</#list>

<#if javaDoc?has_content>
/**
<#list javaDoc as javaDocLine>
 * ${javaDocLine}
</#list>
 */
</#if>
<#if generatedInfo.getGeneratedType()?has_content>
@${generatedInfo.getGeneratedType()}(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "${generatedInfo.getDateTime()}"
)
</#if>
final public class ${className} implements ${className?substring(defaultResolverImplPrefix?length, className?length)} {

    private GrowingIOConfig growingIOConfig;

    public ${className}(GrowingIOConfig growingIOConfig) {
        this.growingIOConfig = growingIOConfig;
    }

    private ${className}() {}

<#list operations as operation>
<#if operation.javaDoc?has_content>
    /**
    <#list operation.javaDoc as javaDocLine>
     * ${javaDocLine}
    </#list>
     */
</#if>
<#if operation.deprecated>
    @Deprecated
</#if>
<#list operation.annotations as annotation>
    @${annotation}
</#list>
    @Override
    public ${operation.type} ${operation.name}(<#list operation.parameters as param>${param.type} ${param.name}<#if param_has_next>, </#if></#list>) throws Exception {
        ${operateNameRequestName} request = new ${operateNameRequestName}();
       <#list operation.parameters as param>
        List<String> keys = Arrays.asList(<#list operation.parameters as param>"${param.originalName}"<#if param_has_next>, </#if></#list>);
        List<?> values = Arrays.asList(<#list operation.parameters as param>${param.name}<#if param_has_next>, </#if></#list>);
        Map<String, ?> parameters = JavaCollectionUtils.listToMap(keys, values);
        request.getInput().putAll(parameters);
        </#list>
        <#if operateNameProjectionName?has_content>
        ${operateNameProjectionName} projection = new ${operateNameProjectionName}().all$(growingIOConfig.getResponseProjectionMaxDepth());
        GraphQLRequest graphQLRequest = new GraphQLRequest(request, projection);
        <#else>
        GraphQLRequest graphQLRequest = new GraphQLRequest(request, null);
        </#if>
        return OkHttpUtil.executeGraphQLRemote(growingIOConfig, graphQLRequest, new TypeReference<${operation.type}>() {});
    }

</#list>
}