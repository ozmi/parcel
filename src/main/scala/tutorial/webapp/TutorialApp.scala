package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import org.scalajs.jquery.{ JQuery, jQuery }
import tutorial.webapp.Node.{ Elem, Text }

object TutorialApp extends JSApp {

    def main(): Unit = {
        jQuery(setupUI _)
    }

    def setupUI(): Unit = {
//        jQuery("""<button type="button">Click me!</button>""")
//            .click(addClickedMessage _)
//            .appendTo(jQuery("body"))
//        jQuery("body").append("<p>Hello World</p>")
        renderNode (
            document.body,
            document.body.firstElementChild,
            None,
            Some (Elem ("b", Seq (Text ("hi"))))
        )
    }

    def addClickedMessage(): Unit = {
        jQuery("body").append("<p>You clicked the button!</p>")
    }

    def renderNode (parent : dom.Node, current : dom.Node, from : Option [Node], to : Option [Node]) : Unit = {
        (from, to) match {
            case (Some (Elem (fromName, fromChildren)), Some (Elem (toName, toChildren))) if fromName == toName =>
                ???
            case (_, Some (Elem (name, children))) =>
                val elemNode = document.createElement (name)
                for (child <- children) {
                    renderNode (current, elemNode, None, Some (child))
                }
                parent.replaceChild (elemNode, current)
            case (_, Some (Text (text))) =>
                current.appendChild (document.createTextNode (text))
        }
    }

}