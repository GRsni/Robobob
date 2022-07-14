package com.provenir.robobob.solver.lexer;

import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.parser.exception.ParserException;

/**
 * The interface Lexer interface.
 */
public interface LexerInterface {

    /**
     * Scan token.
     *
     * @throws ParserException the parser exception
     * @throws LexerException  the lexer exception
     */
    void scanToken() throws ParserException, LexerException;
}
