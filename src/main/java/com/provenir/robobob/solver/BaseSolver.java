package com.provenir.robobob.solver;

import com.provenir.robobob.storage.StorageInterface;

public abstract class BaseSolver implements SolverInterface {

    StorageInterface storageInterface;

    protected BaseSolver() {

    }

    protected BaseSolver(StorageInterface storageInterface) {
        this.storageInterface = storageInterface;
    }

    @Override
    public String evaluateExpression(String expression) {
        return null;
    }
}
