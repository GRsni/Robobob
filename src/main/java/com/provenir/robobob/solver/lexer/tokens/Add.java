package com.provenir.robobob.solver.lexer.tokens;

/**
 * The type Add.
 */
public class Add implements Token {

    private Token left;
    private Token right;

    /**
     * Instantiates a new Add.
     *
     * @param left  the left
     * @param right the right
     */
    public Add(Token left, Token right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public Token getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(Token left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Token getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(Token right) {
        this.right = right;
    }

    @Override
    public String print() {
        return "( " + left.print() + " + " + right.print() + " )";
    }

    @Override
    public Float eval() {
        return left.eval() + right.eval();
    }
}
