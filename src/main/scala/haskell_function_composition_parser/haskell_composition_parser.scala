package haskell_function_composition_parser

import scala.util.parsing.combinator._

object HaskellCompositionParser extends HaskellCompositionParser
trait HaskellCompositionParser extends RegexParsers {

  case class Composition(first: Function, second: Function)
  case class Function(id: String, arguments: List[Argument])
  case class Argument(id: String)
  
  def mayBeBetweenParentesis[U](body: Parser[U]) = "(".? >> {result => if (result.isDefined) {(body <~ ")")} else {body}}

  lazy protected val composition = (function <~ ".") ~ function ^^ { case funcion ~ funcion1 => Composition(funcion, funcion1) }
  lazy protected val commentSkipper = "-{2,}(.*)$".r
  lazy protected val function = normalFunction | anonymousFunction
  lazy protected val normalFunction = identifier ~ mayBeBetweenParentesis(repsep(argument,"")) ^^ { case id ~ arguments => Function(id, arguments) }
  lazy protected val anonymousFunction = mayBeBetweenParentesis("\\" ~> repsep(argument,""  ) <~ "->" <~ functionBody) ^^ {case arguments => Function("",arguments)}
  lazy protected val argument = identifier ^^ { r => Argument(r) }
  lazy protected val identifier = """[A-Za-z]+""".r
  lazy protected val functionBody = identifier.+
  
  
  def apply(input: String) = parseAll(???, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, _)  => throw ParseException(msg)
  }
}