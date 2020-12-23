sys.props.get("plugin.version").orElse(Some("gio-3.1.3-SNAPSHOT")) match {
  case Some(x) => addSbtPlugin("io.growing" % "graphql-codegen-sbt-plugin" % x)
  case _ => sys.error("""|The system property 'plugin.version' is not defined.
                         |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}
