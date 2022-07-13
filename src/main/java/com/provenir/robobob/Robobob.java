package com.provenir.robobob;

import com.provenir.robobob.logger.AppLogger;
import com.provenir.robobob.solver.BaseSolver;
import com.provenir.robobob.solver.MathSolver;
import com.provenir.robobob.solver.SolverInterface;
import com.provenir.robobob.solver.QuestionSolver;
import com.provenir.robobob.storage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Robobob {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final String FILEPATH = "lines.txt";

    private static final StorageInterface storage = new FileStorage(FILEPATH);

    public static void main(String[] args) {
        AppLogger.setup();
        LOGGER.setLevel(Level.INFO);

        LOGGER.info("[General information]: Started application.");

        System.out.println("Welcome to Robobob");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Question >");
            try {
                String input = bufferedReader.readLine();
                if (input.equals("exit")) {
                    break;
                }

                String response = selectSolver(input).evaluateExpression(input);

                System.out.println(response);

            } catch (IOException e) {
                LOGGER.severe("[Error]: " + e.getMessage());
            }
        }
        System.out.println("Exiting Robobob application.");
        LOGGER.info("[General information]: Finished application.");
    }

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
