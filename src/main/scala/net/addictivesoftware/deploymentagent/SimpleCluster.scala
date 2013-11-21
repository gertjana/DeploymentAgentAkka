package net.addictivesoftware.deploymentagent

import akka.actor._
import akka.event.Logging


import akka.cluster.Cluster;
import akka.cluster.ClusterEvent._
import akka.cluster.ClusterEvent.MemberUp
import akka.cluster.ClusterEvent.CurrentClusterState
import akka.cluster.ClusterEvent.MemberRemoved
;

object SimpleClusterApp {
  def main(args:Array[String]) {
    if (args.nonEmpty) System.setProperty("akka.remote.netty.tcp.port", args(0));

    val system = ActorSystem.create("ClusterSystem");
    val clusterListener = system.actorOf(Props[SimpleClusterListener], name="ClusterListener")

    // Add subscription of cluster events
    Cluster(system).subscribe(clusterListener, classOf[ClusterDomainEvent]);
  }
}


class SimpleClusterListener extends Actor with ActorLogging {
  def receive = {
    case state:CurrentClusterState =>
      log.info("Current Members: {}", state.members.mkString(" "))
    case MemberUp(member) =>
      log.info("Member is up: {}", member.address)
    case MemberRemoved(member, previousStatus) =>
      log.info("Member is removed: {} after {}", member.address, previousStatus)
    case UnreachableMember(member) =>
      log.info("Member detected as unreachable: {}", member)
    case _:ClusterDomainEvent => //ignore
  }

}
