package com.googlecahsi.model;

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

    public String getAttribute() {
        return attribute;
    }

    public Function<Double, Integer> getFunction() {
        // Implement the function to check constraints based on Aggregator type
        // Example implementation for AVG:
        return value -> {
            if (value < lowBound) {
                return -1;
            } else if (value > upBound) {
                return 1;
            } else {
                return 0;
            }
        };
    }

// other implementations

