package com.odeklas

/**
 * Created by odeklas on 7/6/15.
 */
import akka.actor.Props
import com.odeklas.web.TemplateServiceRest
import spray.routing._


trait Api extends RouteConcatenation with Core with CoreActors {


  implicit val _ = system.dispatcher

  val TemplateRoute = new TemplateServiceRest().route


  val rootService = system.actorOf(Props(new RoutedHttpService(TemplateRoute)))
}

  class RoutedHttpService(route: Route) extends HttpServiceActor {
    def receive = runRoute(route)
  }

