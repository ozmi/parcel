package tutorial.webapp

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import com.thoughtworks.binding.Binding.{ BindingSeq, Var, Vars }
import com.thoughtworks.binding.{ Binding, dom }
import org.scalajs.dom.{ Event, Node, document }

object TutorialApp extends JSApp {

    implicit def makeIntellijHappy(x: scala.xml.Node): Binding[org.scalajs.dom.raw.Node] = ???
    implicit def makeIntellijHappy(x: scala.xml.NodeBuffer): Binding[BindingSeq[org.scalajs.dom.raw.Node]] = ???

    case class Contact(name: Var[String], email: Var[String])

    val data = Vars.empty[Contact]

    @dom
    def table: Binding[BindingSeq[Node]] = {
        <div>
            <button
            onclick={ event: Event =>
                data.get += Contact(Var("Yang Bo"), Var("yang.bo@rea-group.com"))
            }
            >
                Add a contact
            </button>
        </div>
        <table border="1" cellPadding="5">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>E-mail</th>
                </tr>
            </thead>
            <tbody>
                {
                for (contact <- data) yield {
                    <tr>
                        <td>
                            {contact.name.bind}
                        </td>
                        <td>
                            {contact.email.bind}
                        </td>
                        <td>
                            <button
                            onclick={ event: Event =>
                                contact.name := "Modified Name"
                            }
                            >
                                Modify the name
                            </button>
                        </td>
                    </tr>
                }
                }
            </tbody>
        </table>
    }

    @JSExport
    def main() : Unit = {
        dom.render (document.body, table)
    }

}