package haskell_function_composition_parser

import scala.util.parsing.combinator._


object HaskellCompositionParser extends HaskellCompositionParser
trait HaskellCompositionParser extends RegexParsers {

  case class Composition(first: Function , second: Function)
  case class Function(id: String)
  
  lazy protected val composition_parser = (function <~ ".") ~ function ^^ {case funcion ~ funcion1 => Composition(funcion,funcion1)}
  lazy protected val commentSkipper = "-{2,}(.*)$".r
  lazy protected val function = """[A-Za-z]+""".r ^^ {r => Function(r)}
  
  def apply(input: String) = parseAll(???, input) match {
    case Success(result, _) => result
    case NoSuccess(msg, _)  => throw ParseException(msg)
  }
}