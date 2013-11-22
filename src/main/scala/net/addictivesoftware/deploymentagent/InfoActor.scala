package net.addictivesoftware.deploymentagent

class InfoActor extends ComposableActor {
  private final def address:String = java.net.InetAddress.getLocalHost.toString
  private final val version = "1.0"

  receiveBuilder += {
    case RequestInfo => {
      sender ! Info("name", address, version)
    }
    case Info(name, address, version) => {
      log.info("{} at {} has version {}", name, address, version)
    }
  }
}
