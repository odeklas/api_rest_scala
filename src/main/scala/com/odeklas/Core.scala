package com.odeklas

/**
*  Created by Odeklas on 7/6/15.
*  Visit odeklas.com
*/

import akka.actor.ActorSystem


/**
 * Method override for the unique ActorSystem instance
 */
trait Core {
  implicit def system: ActorSystem
}

/**
 * Definition of the ActorSystem and the ExecutionContext
 */
trait BootedCore extends Core {
  import scala.concurrent.ExecutionContext

  implicit lazy val system = ActorSystem( "ms-service-executor" )
  implicit lazy val ex: ExecutionContext = system.dispatcher
  sys.addShutdownHook( system.shutdown( ) )
}

/**
 * Template project actors instantiation
 */
trait CoreActors { this: Core =>


}

/**
 * Template actor references
 */
object Actors extends BootedCore with CoreActors
