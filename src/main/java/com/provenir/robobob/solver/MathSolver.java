package com.provenir.robobob.solver;

import com.provenir.robobob.solver.lexer.Lexer;
import com.provenir.robobob.solver.lexer.exception.LexerException;
import com.provenir.robobob.solver.lexer.tokens.Token;
import com.provenir.robobob.solver.parser.Parser;
import com.provenir.robobob.solver.parser.ParserInterface;
import com.provenir.robobob.solver.parser.exception.ParserException;

import java.util.logging.Logger;


/**
 * The type Math solver.
 */
public class MathSolver extends BaseSolver {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * Instantiates a new Math solver.
     */
    public MathSolver() {
        super();
    }

    @Override
    public String evaluateExpression(String expression) {
        try {
            ParserInterface parser = new Parser(new Lexer(expression));
            Token expressionTree = parser.parseExpression();
            if (expressionTree != null) {
                //System.out.println(expressionTree.print());
                return String.valueOf(expressionTree.eval());
            }
        } catch (ParserException | LexerException e) {
            LOGGER.severe("[Error]: Exception while evaluating expression: " + e.getMessage());
        }
        return "Could not resolve arithmetic expression.";
    }

}
