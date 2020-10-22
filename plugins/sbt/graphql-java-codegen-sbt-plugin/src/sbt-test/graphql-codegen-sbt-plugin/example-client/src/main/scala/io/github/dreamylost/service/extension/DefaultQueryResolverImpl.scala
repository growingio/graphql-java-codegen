package io.github.dreamylost.service.extension

import com.kobylynskyi.graphql.codegen.extension.GrowingIOConfig
import io.github.dreamylost.model.EpisodeDO
import io.github.dreamylost.resolver.impl.{ DefaultDroidQueryResolver, DefaultHeroQueryResolver, DefaultHumanQueryResolver, DefaultHumansQueryResolver }

/**
 *
 * @author liguobin@growingio.com
 * @version 1.0,2020/10/22
 */
object DefaultQueryResolverImpl extends App {

  var url = "http://localhost:8080/graphql"
  val defaultDroidQueryResolver = new DefaultDroidQueryResolver(new GrowingIOConfig(url))
  println(defaultDroidQueryResolver.droid("2001"))

  val defaultHeroQueryResolver = new DefaultHeroQueryResolver(new GrowingIOConfig(url))
  println(defaultHeroQueryResolver.hero(EpisodeDO.EMPIRE))

  val defaultHumanQueryResolver = new DefaultHumanQueryResolver(new GrowingIOConfig(url))
  println(defaultHumanQueryResolver.human("1002"))

  val defaultHumansQueryResolver = new DefaultHumansQueryResolver(new GrowingIOConfig(url))
  println(defaultHumansQueryResolver.humans())

}
