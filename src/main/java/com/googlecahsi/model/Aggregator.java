package com.googlecahsi.model;

import java.util.ArrayList;
import java.util.function.Function;

public class Aggregator {
    MIN,
    MAX,
    AVG,
    SUM,
    COUNT;

    public Function<ArrayList<Double>, Double> getFunction() {
        // implementation based on aggregator type
        // Example implementation for AVG:
        return values -> values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
