package tutorial
import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.BindingSeq

package object webapp {

    implicit def makeIntellijHappy(x: scala.xml.Node): Binding[org.scalajs.dom.raw.Node] = ???
    implicit def makeIntellijHappy(x: scala.xml.NodeBuffer): Binding[BindingSeq[org.scalajs.dom.raw.Node]] = ???


}
