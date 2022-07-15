package com.provenir.robobob.storage;

import java.util.Map;

/**
 * The interface Storage interface.
 */
public interface StorageInterface {

    /**
     * Returns the map of questions and answers read from storage.
     *
     * @return The list of questions with their corresponding answers.
     */
    Map<String, String> getQuestionList();
}
