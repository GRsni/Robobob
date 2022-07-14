package com.provenir.robobob.solver.lexer;

import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.parser.exception.ParserException;

public interface LexerInterface {

    void scanToken() throws ParserException, LexerException;
}
