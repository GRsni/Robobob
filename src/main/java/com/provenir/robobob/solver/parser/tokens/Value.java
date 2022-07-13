package com.provenir.robobob.solver.parser.tokens;

public class Value extends Node {
    private Float aFloat;

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
