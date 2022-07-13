package com.provenir.robobob.storage;

import com.provenir.robobob.storage.types.QuestionAnswer;

import java.util.List;

public abstract class BaseStorage implements StorageInterface{
    @Override
    public List<QuestionAnswer> getQuestionList() {
        return null;
    }
}
