package com.googlecahsi.model;

import java.util.ArrayList;
import java.util.function.Function;

public class Constraint {
    public Aggregator function;
    private String attribute;
    private double lowBound;
    private double upBound;

    public Constraint(Aggregator function, String attribute, double lowBound, double upBound) {
        this.function = function;
        this.attribute = attribute;
        this.lowBound = lowBound;
        this.upBound = upBound;
    }

    // Getters
    public String getAttribute() {

        return attribute;
    }

    public Aggregator getFunction() {
        return function;
    }

    public Function<Double, Integer> getComparisonFunction() {
        return values -> {
            double result = function.getFunction().apply(values);
            if (result < lowBound) {
                return -1; // Fails lower bound
            } else if (result > upBound) {
                return 1;  // Fails upper bound
            } else {
                return 0;  // Passes both bounds
            }
        };
    }
}

// other if necessary

