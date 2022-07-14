package com.provenir.robobob.solver.parser;

import com.provenir.robobob.solver.lexer.Lexer;
import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.lexer.tokens.*;
import com.provenir.robobob.solver.parser.exception.ParserException;

public class Parser implements ParserInterface {

    private final Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public Token parseExpression() throws ParserException, LexerException {
        Token a = parseTerm();
        if (a == null) {
            return null;
        }
        while (true) {
            if (lexer.getNextToken().equals("+")) {
                lexer.scanToken();
                Token b = parseTerm();
                if (b == null) {
                    return null;
                }
                a = new Add(a, b);
            } else if (lexer.getNextToken().equals("-")) {
                lexer.scanToken();
                Token b = parseTerm();
                if (b == null) {
                    return null;
                }
                a = new Subtract(a, b);
            } else {
                return a;
            }
        }
    }

    public Token parseTerm() throws ParserException, LexerException {
        Token a = parseFactor();
        if (a == null) {
            return null;
        }
        while (true) {
            if (lexer.getNextToken().equals("*")) {
                lexer.scanToken();
                Token b = parseTerm();
                if (b == null) {
                    return null;
                }
                a = new Multiply(a, b);
            } else if (lexer.getNextToken().equals("/")) {
                lexer.scanToken();
                Token b = parseTerm();
                if (b == null) {
                    return null;
                }
                a = new Divide(a, b);
            } else {
                return a;
            }
        }
    }

    public Token parseFactor() throws ParserException, LexerException {
        if (isValueToken(lexer.getNextToken())) {
            String currentToken = lexer.getNextToken();
            lexer.scanToken();
            return new Value(Float.parseFloat(currentToken));
        } else if (lexer.getNextToken().equals("(")) {
            lexer.scanToken();
            Token a = parseExpression();
            if (a == null) {
                throw new ParserException("Error while parsing factor");
            }
            if (lexer.getNextToken().equals(")")) {
                lexer.scanToken();
                return a;
            } else {
                throw new ParserException("Error while parsing factor: Extra tokens after closing parenthesis");
            }
        } else if (lexer.getNextToken().equals("-")) {
            lexer.scanToken();
            return new Negate(parseFactor());
        }
        return null;
    }

    private boolean isValueToken(String token) {
        return token.matches("[-+]?\\d*\\.?\\d+");
    }
}
