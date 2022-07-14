package com.provenir.robobob.solver.lexer.tokens;

public class Multiply implements Token {

    private Token left;
    private Token right;

    public Multiply(Token left, Token right) {
        this.left = left;
        this.right = right;
    }

    public Token getLeft() {
        return left;
    }

    public void setLeft(Token left) {
        this.left = left;
    }

    public Token getRight() {
        return right;
    }

    public void setRight(Token right) {
        this.right = right;
    }


    @Override
    public String print() {
        return "( " + left.print() + " * " + right.print() + " )";
    }

    @Override
    public Float eval() {
        return left.eval() * right.eval();
    }
}
