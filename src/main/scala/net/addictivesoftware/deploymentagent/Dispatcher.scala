package net.addictivesoftware.deploymentagent

import akka.actor._
import akka.routing.Listeners

object Dispatcher {
  def props(name: String): Props = Props(classOf[Dispatcher], name)
}

class Dispatcher extends ComposableActor with Listeners {
  receiveBuilder += {
    case Broadcast(obj:Dispatcher) => {
      //withListeners {
      //  become {
      //    obj
      //  }
      //}
    }
  }
}
