package com.provenir.robobob.solver.lexer.tokens;

public class Value implements Token {
    private Float aFloat;

    public Value(Float aFloat) {
        this.aFloat = aFloat;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    @Override
    public String print() {
        return aFloat.toString();
    }

    @Override
    public Float eval() {
        return aFloat;
    }
}
