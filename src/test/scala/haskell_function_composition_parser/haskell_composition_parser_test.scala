package haskell_function_composition_parser
import org.uqbar.testing.ParserTest
import org.scalatest.FreeSpec


class haskell_composition_parser_test extends FreeSpec with ParserTest[HaskellCompositionParser] with HaskellCompositionParser {
 implicit val parser: Parser[Composition] = composition_parser
  "should parse compositions" - {
   "should parse a simple composition" in {
     """funcionA.funcionB""" should beParsedTo(Composition(Function("funcionA",Nil),Function("funcionB",Nil)))
   }
   
 }
}