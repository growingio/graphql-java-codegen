# GraphQL Codegen #

![Build](https://github.com/growingio/graphql-java-codegen/workflows/Build/badge.svg)
[![Gitter](https://badges.gitter.im/graphql-java-codegen/community.svg)](https://gitter.im/graphql-java-codegen/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

GraphQL Java Codegen makes it easy to make your Java application to follow a schema-first approach whether it is a server or client application.


Following classes can be generated based on your GraphQL schema:
* Interfaces for GraphQL queries, mutations and subscriptions.
* Interfaces for GraphQL unions.
* POJO classes for GraphQL types and inputs.
* Enum classes for GraphQL enums.
* Interface Resolvers for GraphQL type fields (e.g. for parametrized fields).
* Client Request classes for GraphQL queries, mutations and subscriptions.

## Update logs

This is a mirror repository, which aims to add some customization functions that are not convenient to implement on the source repository.

**2020-10-22** 
    - support to generate default resolver's impl.

## Supported plugins

* Gradle plugin: [graphql-java-codegen-gradle-plugin](plugins/gradle)
* Maven plugin: [grapqhl-java-codegen-maven-plugin](plugins/maven) 
* SBT plugin: [grapqhl-java-codegen-sbt-plugin](plugins/sbt) 


## Contributing

Please see [CONTRIBUTING.md](CONTRIBUTING.md).


## Inspired by

[swagger-codegen](https://github.com/swagger-api/swagger-codegen)