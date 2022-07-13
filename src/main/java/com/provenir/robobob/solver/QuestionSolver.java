package com.provenir.robobob.solver;

import com.provenir.robobob.storage.StorageInterface;
import com.provenir.robobob.storage.types.QuestionAnswer;

import java.util.List;

public class QuestionSolver extends BaseSolver {

    public QuestionSolver(StorageInterface storageInterface) {
        super(storageInterface);
    }

    @Override
    public String evaluateExpression(String expression) {
        return findAnswerFromQuestion(expression, storageInterface.getQuestionList());
    }

    private String findAnswerFromQuestion(String expression, List<QuestionAnswer> questionAnswers) throws NullPointerException {
        QuestionAnswer solution = questionAnswers.stream()
                .filter(questionAnswer -> expression.equals(questionAnswer.getQuestion()))
                .findAny()
                .orElse(new QuestionAnswer("", "Could not find an answer to your question"));

        return solution.getAnswer();
    }
}
