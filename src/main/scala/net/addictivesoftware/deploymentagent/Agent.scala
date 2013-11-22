package net.addictivesoftware.deploymentagent

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

object Agent {
  def main(args:Array[String]) {
    val system = ActorSystem.create("AgentSystem");

    val agentActor = system.actorOf(Agent.props("Agent"))

    val dispatcher = args(0) match {
      case "master" => agentActor ! BecomeMaster
      case "_" => agentActor | BecomeSlave
  }
    def props(name: String): Props = Props(classOf[Agent], name)
}

class Agent extends Actor with ActorLogging {
  def receive = {
    case BecomeMaster => {
      context.actorOf(Dispatcher.props("RootDispatcher"))
    }
    case BecomeSlave => {
      context.actorOf(Dispatcher.props("Dispatcher"))
    }
  }
  }
}

