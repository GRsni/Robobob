package com.provenir.robobob.solver.lexer.tokens;

/**
 * The type Value.
 */
public class Value implements Token {
    private Float aFloat;

    /**
     * Instantiates a new Value.
     *
     * @param aFloat the a float
     */
    public Value(Float aFloat) {
        this.aFloat = aFloat;
    }

    /**
     * Gets float.
     *
     * @return the float
     */
    public Float getaFloat() {
        return aFloat;
    }

    /**
     * Sets float.
     *
     * @param aFloat the float
     */
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
