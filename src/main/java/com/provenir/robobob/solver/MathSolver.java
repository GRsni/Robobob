package com.provenir.robobob.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MathSolver extends BaseSolver {

    private static final String PATTERN_ALL_ELEMENTS = "[^0-9\\.x\\-\\+\\/]";

    private static final String PATTERN_OPS = "\\d+\\.?\\d*";
    private static final String PATTERN_TOKENS = "[x\\-\\+\\/]";

    public MathSolver() {
        super();
    }

    @Override
    public String evaluateExpression(String expression) {
        if (isExpressionValid(expression)) {
            List<Float> tokens = parseNumericTokens(tokenizeExpression(expression, PATTERN_TOKENS));
            System.out.println(tokens);
            List<String> ops = tokenizeExpression(expression, PATTERN_OPS);
            ops.remove(0);
            System.out.println(ops);
            return calculateExpression(tokens, ops);
        }
        return null;
    }

    private List<Float> parseNumericTokens(List<String> tokens) {
        return tokens.stream().map(Float::parseFloat).collect(Collectors.toList());
    }

    private boolean isExpressionValid(String expression) {
        Pattern pattern = Pattern.compile(PATTERN_ALL_ELEMENTS);
        Matcher matcher = pattern.matcher(expression);
        return !matcher.find();
    }

    private List<String> tokenizeExpression(String expression, String pattern) {
        return new ArrayList<>(Arrays.asList(expression.split(pattern)));
    }

    private String calculateExpression(List<Float> tokens, List<String> ops) {

        // Execute multiplication and division first.
        reduceExpression(tokens, ops, new ArrayList<>(Arrays.asList("x", "/")));

        // Execute summation and subtraction second.
       reduceExpression(tokens, ops, new ArrayList<>(Arrays.asList("+", "-")));
        return String.valueOf(tokens.get(0));
    }
    private void reduceExpression(List<Float> tokens, List<String> ops, List<String> options){
        for (int opIndex = ops.size() - 1; opIndex >= 0; opIndex--) {
            String op = ops.get(opIndex);
            Float firstToken = tokens.get(opIndex);
            Float secondToken = tokens.get(opIndex + 1);

            if (options.contains(op)) {
                Float result = executeOperation(op.charAt(0), firstToken, secondToken);
                tokens.remove(opIndex + 1);
                tokens.set(opIndex, result);
            }
        }
    }

    private Float executeOperation(char op, Float first, Float second) throws UnsupportedOperationException {
        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case 'x':
                return first * second;
            case '/':
                return first / second;
        }
        throw new UnsupportedOperationException("Operation is not allowed.");
    }

}
