package com.provenir.robobob;

import com.provenir.robobob.logger.AppLogger;
import com.provenir.robobob.solver.BaseSolver;
import com.provenir.robobob.solver.MathSolver;
import com.provenir.robobob.solver.QuestionSolver;
import com.provenir.robobob.storage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Robobob.
 */
public class Robobob {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final String STORAGE_FILENAME = "lines.txt";

    private static final StorageInterface storage = new FileStorage(STORAGE_FILENAME);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AppLogger.setup();
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("[General information]: Started application.");

        System.out.println("Welcome to Robobob. Type a simple question or an arithmetic expression:\n(Type \"exit\" to end the program)\n");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Question > ");
            try {
                String input = bufferedReader.readLine();
                if (input.equals("exit")) {
                    break;
                }

                System.out.println("Answer: " + selectSolver(input).evaluateExpression(input) + "\n");

            } catch (IOException e) {
                LOGGER.severe("[Error]: " + e.getMessage());
            }
        }
        System.out.println("Exiting Robobob application.");
        LOGGER.info("[General information]: Finished application.");
    }

    /**
     * Select solver base solver.
     *
     * @param expression the expression
     * @return the base solver
     */
    static BaseSolver selectSolver(String expression) {
        //Math expression can start with a digit, the minus sign or an open parenthesis.
        char firstCharacter = expression.charAt(0);
        if (Character.isDigit(firstCharacter) || firstCharacter == '-' || firstCharacter == '(') {
            return new MathSolver();
        } else {
            return new QuestionSolver(Robobob.storage);
        }
    }


}
