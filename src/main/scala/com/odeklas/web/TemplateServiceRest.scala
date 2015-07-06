package com.odeklas.web

import com.odeklas.Actors
import spray.json.DefaultJsonProtocol
import spray.routing.Directives
import spray.http.StatusCodes._

import scala.concurrent.ExecutionContext

/**
 * Created by diego.gamboa on 7/6/15.
 */
class TemplateServiceRest extends Directives
with DefaultJsonProtocol {

  import akka.util.Timeout

  import scala.concurrent.duration._

  implicit val ec: ExecutionContext = Actors.ex
  implicit val timeout = Timeout( 120.seconds )

  val route =
    path( "suma" / Segment/ Segment) {
      (primerParametro , segundoParametro ) =>
          get {
            ctx =>
              print(s""" sumar $primerParametro + $segundoParametro""")
                // Marshelling con Jackson y se añade el hal
                ctx.complete(OK, primerParametro + segundoParametro)
              }
          }

}
