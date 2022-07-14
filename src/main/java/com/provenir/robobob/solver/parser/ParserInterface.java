package com.provenir.robobob.solver.parser;

import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.lexer.tokens.Token;
import com.provenir.robobob.solver.parser.exception.ParserException;

/**
 * The interface Parser interface.
 */
public interface ParserInterface {

    /**
     * Parse expression token.
     *
     * @return the token
     * @throws ParserException the parser exception
     * @throws LexerException  the lexer exception
     */
    Token parseExpression() throws ParserException, LexerException;

    /**
     * Parse term token.
     *
     * @return the token
     * @throws ParserException the parser exception
     * @throws LexerException  the lexer exception
     */
    Token parseTerm() throws ParserException, LexerException;

    /**
     * Parse factor token.
     *
     * @return the token
     * @throws ParserException the parser exception
     * @throws LexerException  the lexer exception
     */
    Token parseFactor() throws ParserException, LexerException;

}
