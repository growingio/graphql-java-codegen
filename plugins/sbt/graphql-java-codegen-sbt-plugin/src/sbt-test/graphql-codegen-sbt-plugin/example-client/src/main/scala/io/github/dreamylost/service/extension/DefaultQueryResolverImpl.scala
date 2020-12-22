package io.github.dreamylost.service.extension

import com.kobylynskyi.graphql.codegen.extension.GrowingIOConfig
import io.github.dreamylost.api.impl._
import io.github.dreamylost.model.EpisodeDO

/**
 *
 * @author liguobin@growingio.com
 * @version 1.0,2020/10/22
 */
object DefaultQueryResolverImpl extends App {

  var url = "http://localhost:8080/graphql"
  val defaultDroidQueryResolver = new $DroidQueryResolver(new GrowingIOConfig(url))
  println(defaultDroidQueryResolver.droid("2001"))

  val defaultHeroQueryResolver = new $HeroQueryResolver(new GrowingIOConfig(url))
  println(defaultHeroQueryResolver.hero(EpisodeDO.EMPIRE))

  val defaultHumanQueryResolver = new $HumanQueryResolver(new GrowingIOConfig(url))
  println(defaultHumanQueryResolver.human("1002"))

  val defaultHumansQueryResolver = new $HumansQueryResolver(new GrowingIOConfig(url))
  println(defaultHumansQueryResolver.humans())

}
