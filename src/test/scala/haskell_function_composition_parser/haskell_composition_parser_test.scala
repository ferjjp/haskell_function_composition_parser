package haskell_function_composition_parser
import org.uqbar.testing.ParserTest
import org.scalatest.FreeSpec


class haskell_composition_parser_test extends FreeSpec with ParserTest[HaskellCompositionParser] with HaskellCompositionParser {
  "should parse functions" - { 
    
   "should parse a simple function" in {
     """functionA""" should beParsedTo(Function("functionA",Nil))(function)
   }
   
   "should parse a function with arguments" in {
     """functionA bla ble bli""" should beParsedTo(Function("functionA",List(Argument("bla"),Argument("ble"),Argument("bli"))))(function)
   }
   
 }
  
  "should parse compositions" - {
   "should parse a simple composition" in {
     """funcionA.funcionB""" should beParsedTo(Composition(Function("funcionA",Nil),Function("funcionB",Nil)))(composition)
   }
   
   
   
 }
}