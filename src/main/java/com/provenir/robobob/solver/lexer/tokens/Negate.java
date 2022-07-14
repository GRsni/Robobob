package com.provenir.robobob.solver.lexer.tokens;

/**
 * The type Negate.
 */
public class Negate implements Token {

    private Token arg;

    /**
     * Instantiates a new Negate.
     *
     * @param arg the arg
     */
    public Negate(Token arg) {
        this.arg = arg;
    }

    /**
     * Gets arg.
     *
     * @return the arg
     */
    public Token getArg() {
        return arg;
    }

    /**
     * Sets arg.
     *
     * @param arg the arg
     */
    public void setArg(Token arg) {
        this.arg = arg;
    }


    @Override
    public String print() {
        return "( - " + arg.print() + " )";
    }

    @Override
    public Float eval() {
        return arg.eval() * -1;
    }
}
