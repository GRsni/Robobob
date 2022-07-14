package com.provenir.robobob.solver;

import com.provenir.robobob.storage.StorageInterface;

import java.util.Locale;
import java.util.Map;

/**
 * The type Question solver.
 */
public class QuestionSolver extends BaseSolver {

    private final StorageInterface storage;

    /**
     * Instantiates a new Question solver.
     *
     * @param storageInterface the storage interface
     */
    public QuestionSolver(StorageInterface storageInterface) {
        this.storage = storageInterface;
    }

    @Override
    public String evaluateExpression(String expression) {
        return findAnswerFromQuestion(expression, storage.getQuestionList());
    }

    private String findAnswerFromQuestion(String expression, Map<String, String> questionAnswers) throws NullPointerException {
        return questionAnswers.getOrDefault(expression.toLowerCase(Locale.ROOT), "Could not find an answer to your question");
    }
}
