package com.provenir.robobob.storage;

import java.util.Collections;

import java.util.Map;

/**
 * The type Base storage.
 */
public abstract class BaseStorage implements StorageInterface {
    @Override
    public Map<String, String> getQuestionList() {
        return Collections.emptyMap();
    }
}
