package com.provenir.robobob.solver.lexer.tokens;

public class Negate implements Token {

    private Token arg;

    public Negate(Token arg) {
        this.arg = arg;
    }

    public Token getArg() {
        return arg;
    }

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
