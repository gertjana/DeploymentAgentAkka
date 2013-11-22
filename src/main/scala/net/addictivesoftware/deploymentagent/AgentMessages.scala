package net.addictivesoftware.deploymentagent

trait AgentMessages

case class RequestInfo() extends AgentMessages
case class Info(name:String, address:String, version:String) extends AgentMessages

case class Broadcast(obj:Any) extends AgentMessages

case class BecomeMaster() extends AgentMessages
case class BecomeSlave() extends AgentMessages