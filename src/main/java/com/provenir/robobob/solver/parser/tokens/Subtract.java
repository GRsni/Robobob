package com.provenir.robobob.solver.parser.tokens;

public class Subtract extends Node{

    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
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
