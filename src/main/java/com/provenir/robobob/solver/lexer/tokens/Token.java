package com.provenir.robobob.solver.lexer.tokens;

/**
 * The interface Token.
 */
public interface Token {
     /**
      * Print string.
      *
      * @return the string
      */
     String print();

     /**
      * Eval float.
      *
      * @return the float
      */
     Float eval();
}
