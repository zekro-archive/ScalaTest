/**
  * Created by zekro on 06.04.2017 / 14:13
  * ScalaTest/
  * © zekro 2017
  */

object Main {

  var URL = ""

  def main(args: Array[String]): Unit = {

    URL = "http://wyezee.deviantart.com/art/Cat-Swag-289233236"
    TweetSender.sendTweet()

  }

}
