package com.provenir.robobob.solver.parser;

import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.lexer.tokens.Token;
import com.provenir.robobob.solver.parser.exception.ParserException;

public interface ParserInterface {

    Token parseExpression() throws ParserException, LexerException;

    Token parseTerm() throws ParserException, LexerException;

    Token parseFactor() throws ParserException, LexerException;

}
