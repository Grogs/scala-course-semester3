package controllers

import javax.inject.Inject

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.stream.Materializer
import play.api.Logger
import play.api.mvc._
import play.api.libs.streams._
import play.api.mvc.Results.Ok

class UserTrackingController @Inject()(implicit system: ActorSystem, materializer: Materializer, webJarAssets: WebJarAssets) {

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef(out => UserActor.props(out))
  }

  def track() = Action{
    Ok(
      views.html.track(LiveUsers.counts)(webJarAssets)
    )
  }
}

object UserActor {
  def props(out: ActorRef) = Props(new UserActor(out))
}

object LiveUsers {
  var counts = Map.empty[String, Int].withDefaultValue(0)

  def inc(destination: String) =
    counts += (destination -> (counts(destination) + 1))

  def dec(destination: String) =
    counts += destination -> (counts(destination) - 1)
}

class UserActor(out: ActorRef) extends Actor {
  Logger.info(s"WebSocket created: $out")

  var previousDestination: Option[String] = None

  def receive = {
    case msg: String =>
      out ! ("I received your message: " + msg)

      LiveUsers.inc(msg)

      previousDestination foreach LiveUsers.dec

      previousDestination

      Logger.info(s"Received '$msg' from $out")
  }

  override def postStop(): Unit = {
    Logger.info(s"WebSocket closed: $out")
  }
}
