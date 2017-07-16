package tutorial.webapp

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import com.thoughtworks.binding.Binding.{ BindingSeq, Constants, Var, Vars }
import com.thoughtworks.binding.{ Binding, dom }
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.raw.KeyboardEvent
import org.scalajs.dom.{ Event, Node, document, html }

object TutorialApp extends JSApp {

    val types = Constants("boolean", "string", "integer", "decimal")

    case class Field(name : Var[String], valueType : Var[String])

    val fields = Vars.empty[Field]

    @dom
    val typeList =
        <datalist id="typs">
            {
            for (tpe <- types) yield <option value={tpe} />
            }
        </datalist>

    @dom
    def table: Binding[Node] = {

        <table border="1" cellPadding="5">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                {
                for (field <- fields) yield {
                    <tr>
                        <td>
                            {field.name.bind}
                        </td>
                        <td>
                            <input type="text" list="typs"></input>
                        </td>
                        <td>
                            <button
                            onclick={ event: Event =>
                                fields.get.remove (fields.get.indexOf (field))
                            }
                            >
                                Remove
                            </button>
                        </td>
                    </tr>
                }
                }
                <tr>
                    <td>
                        <input
                        onkeydown = { event : KeyboardEvent =>
                            (event.currentTarget, event.keyCode) match {
                                case (input : html.Input, KeyCode.Enter) =>
                                    fields.get += Field (Var (input.value), Var (""))
                                    input.value = ""
                                case _ =>
                            }
                        }
                        >
                        </input>
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                </tr>
            </tbody>
        </table>
    }

    @JSExport
    def main() : Unit = {
        dom.render (document.body, table)
    }

}