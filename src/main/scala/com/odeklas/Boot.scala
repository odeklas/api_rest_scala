package com.odeklas

import java.net.InetAddress

/**
 * Created by odeklas on 7/6/15.
 */
object Boot extends App with Api with BootedCore with HostBinding  {
  import akka.io.IO
  import spray.can.Http

  IO( Http )( system ) ! Http.Bind( rootService, interface = machineIp( ), port = portNumber )
}

trait HostBinding {

  def portNumber: Int =8081

  def machineIp(): String =
    "0.0.0.0"
  //    NetworkInterface.getByName( s"eth0" ).getInetAddresses.map( matchIp ).flatten.mkString

//  private def matchIp( address: InetAddress ): Option[ String ] =
//    """\b(?:\d{1,3}\.){3}\d{1,3}\b""".r.findFirstIn( address.getHostAddress( ) )

  private def matchIp( address: InetAddress ): Option[ String ] =Some(address.getHostAddress( ))
}
