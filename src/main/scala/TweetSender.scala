import sys.process._
import java.net.URL
import java.io.File
import java.nio.file.{Paths, Files}

import scala.concurrent._
import ExecutionContext.Implicits.global
import com.danielasfregola.twitter4s.{TwitterRestClient, TwitterStreamingClient}

/**
  * Created by zekro on 06.04.2017 / 14:59
  * ScalaTest/
  * © zekro 2017
  */

object TweetSender {

  val client = TwitterRestClient(SECRETS.TWITTER_CONSUMER_TOKEN, SECRETS.TWITTER_ACCESS_TOKEN)

  def sendTweet(): Unit = {

    val assambled = "\"" + HTMLGetter.title() + "\" by " + HTMLGetter.artist()

    new URL(HTMLGetter.picUrl()) #> new File("pic.jpg") !!

    for {
      up <- client.uploadMediaFromPath("pic.jpg")
      tweet <- client.createTweet(status = assambled, media_ids = Seq(up.media_id))
    } yield tweet
  }
}
