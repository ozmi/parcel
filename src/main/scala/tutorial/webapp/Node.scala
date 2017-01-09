package tutorial.webapp

sealed trait Node

object Node {

    case class Elem (name : String, children : Seq [Node] = Seq.empty) extends Node

    case class Text (text : String) extends Node

}