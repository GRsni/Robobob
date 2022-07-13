package com.provenir.robobob.solver.parser.tokens;

public class Negate extends Node{

    private Node arg;

    public Node getArg() {
        return arg;
    }

    public void setArg(Node arg) {
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
