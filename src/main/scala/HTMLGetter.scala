import net.ruippeixotog.scalascraper.model.Element
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

/**
  * Created by zekro on 06.04.2017 / 14:19
  * ScalaTest/
  * © zekro 2017
  */

object HTMLGetter {

  var URL = Main.URL
  var browser = JsoupBrowser()
  var doc = browser.get(URL)

  def title(): String = {
    val title = doc >> extractor(".title", text)
    return title
  }

  def artist(): String = {
    val artist = doc >> extractor(".username", text)
    return artist
  }

  def picUrl(): String = {
    val picElement = doc >> extractor(".dev-content-normal", element)
    val url = picElement.attr("src")
    return url
  }
}
