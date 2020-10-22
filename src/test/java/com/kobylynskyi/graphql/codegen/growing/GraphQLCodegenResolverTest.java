package com.kobylynskyi.graphql.codegen.growing;

import com.kobylynskyi.graphql.codegen.GraphQLCodegen;
import com.kobylynskyi.graphql.codegen.TestUtils;
import com.kobylynskyi.graphql.codegen.model.MappingConfig;
import com.kobylynskyi.graphql.codegen.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static com.kobylynskyi.graphql.codegen.TestUtils.assertSameTrimmedContent;
import static com.kobylynskyi.graphql.codegen.TestUtils.getFileByName;
import static java.util.Collections.singletonList;

class GraphQLCodegenResolverTest {
    private final File outputBuildDir = new File("build/generated");
    private final File outputJavaClassesDir = new File("build/generated");
    private final File implOutputJavaClassesDir = new File("build/generated/impl");
    private final File outputJavaClassesDirPackage = new File("build/generated");
    private final File implOutputJavaClassesDirPackage = new File("build/generated/com/github/growing/impl");
    private final MappingConfig mappingConfig = new MappingConfig();

    @BeforeEach
    void init() {
        mappingConfig.setGenerateParameterizedFieldsResolvers(false);
        mappingConfig.setGenerateClient(true);
    }

    @AfterEach
    void cleanup() {
        Utils.deleteDir(outputBuildDir);
    }

    @Test
    void generate_Origin_Impl() throws Exception {
        new GraphQLCodegen(singletonList("src/test/resources/schemas/github.graphqls"),
                outputBuildDir, mappingConfig, TestUtils.getStaticGeneratedInfo()).generate();

        File[] files = Objects.requireNonNull(outputJavaClassesDir.listFiles());

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/AcceptTopicSuggestionMutationResolver.java.txt"),
                getFileByName(files, "AcceptTopicSuggestionMutationResolver.java"));

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/ViewerQueryResolver.java.txt"),
                getFileByName(files, "ViewerQueryResolver.java"));
    }

    @Test
    void generate_Default_Impl() throws Exception {
        mappingConfig.setGenerateDefaultResolverImpl(true);
        new GraphQLCodegen(singletonList("src/test/resources/schemas/github.graphqls"),
                outputBuildDir, mappingConfig, TestUtils.getStaticGeneratedInfo()).generate();

        File[] files = Objects.requireNonNull(implOutputJavaClassesDir.listFiles());

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/DefaultAcceptTopicSuggestionMutationResolver.java.txt"),
                getFileByName(files, "DefaultAcceptTopicSuggestionMutationResolver.java"));

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/DefaultViewerQueryResolver.java.txt"),
                getFileByName(files, "DefaultViewerQueryResolver.java"));
    }

    @Test
    void generate_Default_Impl_Package() throws Exception {
        mappingConfig.setPackageName("com.github.growing");
        mappingConfig.setGenerateDefaultResolverImpl(true);

        new GraphQLCodegen(singletonList("src/test/resources/schemas/github.graphqls"),
                outputJavaClassesDirPackage, mappingConfig, TestUtils.getStaticGeneratedInfo()).generate();

        File[] files = Objects.requireNonNull(implOutputJavaClassesDirPackage.listFiles());

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/with-package/DefaultAcceptTopicSuggestionMutationResolver.java.txt"),
                getFileByName(files, "DefaultAcceptTopicSuggestionMutationResolver.java"));

        assertSameTrimmedContent(new File("src/test/resources/expected-classes/growing/resolvers/with-package/DefaultViewerQueryResolver.java.txt"),
                getFileByName(files, "DefaultViewerQueryResolver.java"));
    }

}