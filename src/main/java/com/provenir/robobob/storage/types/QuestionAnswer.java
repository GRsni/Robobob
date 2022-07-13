package com.provenir.robobob.storage.types;

/**
 * The type Question answer.
 */
public class QuestionAnswer {
    /**
     * The Question.
     */
    String question;
    /**
     * The Answer.
     */
    String answer;

    /**
     * Instantiates a new Question answer.
     *
     * @param question the question
     * @param answer   the answer
     */
    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets answer.
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Sets answer.
     *
     * @param answer the answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
