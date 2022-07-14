package com.provenir.robobob.solver.lexer;

import com.provenir.robobob.solver.lexer.exception.LexerException;

/**
 * The type Lexer.
 */
public class Lexer implements LexerInterface {

    private static final String ALL_TOKENS = "0123456789.()+-*/";

    private static final String FLOAT_TOKENS = "0123456789.";
    private final String input;
    private int pointer;
    private String nextToken;

    /**
     * Instantiates a new Lexer.
     *
     * @param input the input
     * @throws LexerException the lexer exception
     */
    public Lexer(String input) throws LexerException {
        this.input = input;
        nextToken = null;
        pointer = 0;
        scanToken();
    }

    /**
     * Gets next token.
     *
     * @return the next token
     */
    public String getNextToken() {
        return nextToken;
    }

    @Override
    public void scanToken() throws LexerException {
        if (pointer <= input.length() - 1) {
            char charToken = input.charAt(pointer);
            if (isTokenValid(charToken)) {
                if (isTokenValidFloat(charToken)) {
                    String nextFloatEntry = scanNextFloat(input, pointer);
                    nextToken = nextFloatEntry;
                    pointer += nextFloatEntry.length();
                } else {
                    nextToken = String.valueOf(charToken);
                    pointer++;
                }
            } else {
                throw new LexerException("Unexpected token: Unknown character [ " + charToken + " ]");
            }
        }
    }

    private boolean isTokenValid(char token) {
        return ALL_TOKENS.indexOf(token) >= 0;
    }

    private boolean isTokenValidFloat(char token) {
        return FLOAT_TOKENS.indexOf(token) >= 0;
    }

    private String scanNextFloat(String input, int pointer) throws LexerException {
        boolean foundDot = false;
        char currentChar = input.charAt(pointer);
        StringBuilder nextFloat = new StringBuilder();

        do {
            if (isTokenValid(currentChar)) {
                if (currentChar == '.') {
                    if (foundDot) {
                        throw new LexerException("Unexpected token: Multiple decimal dots.");
                    }
                    foundDot = true;
                }
                nextFloat.append(currentChar);
                if (++pointer <= input.length() - 1) {
                    currentChar = input.charAt(pointer);
                }
            } else {
                throw new LexerException("Unexpected token: Unknown character [ " + currentChar + " ]");
            }
        } while (isTokenValidFloat(currentChar) && pointer <= input.length() - 1);
        return nextFloat.toString();
    }


}

