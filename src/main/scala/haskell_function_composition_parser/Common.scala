package haskell_function_composition_parser

case class ParseException(message: String) extends RuntimeException(message)