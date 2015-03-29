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
   
   "should parse a function that uses parentesis" in {
     """functionA(bla)""" should beParsedTo(Function("functionA",List(Argument("bla"))))(function)
   }
   
   "should parse an anonymous function" in {
     """\x y -> ble""" should beParsedTo(Function("",List(Argument("x"),Argument("y"))))(function)
   }
   
 }
  
  "should parse compositions" - {
    
   "should parse a simple composition" in {
     """funcionA.funcionB""" should beParsedTo(Composition(Function("funcionA",Nil),Function("funcionB",Nil)))(composition)
   }
   
   "should parse a function composition, both with arguments" in {
     """funcionA ble . funcionB bli""" should beParsedTo(Composition(Function("funcionA",List(Argument("ble"))),Function("funcionB",List(Argument("bli")))))(composition)
   }
   
   
   
 }
}