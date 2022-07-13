package com.provenir.robobob.storage;

import com.provenir.robobob.storage.types.QuestionAnswer;

import java.util.List;

public interface StorageInterface {

    /**
     * Returns the list of Questions and answers read from storage.
     * @return The list of questions with their corresponding answers.
     */
    List<QuestionAnswer> getQuestionList();
}
