package com.googlecahsi.model;

import java.util.ArrayList;
import java.util.function.Function;

public enum Aggregator {
    MIN {
        @Override
        public Function<ArrayList<Double>, Double> getFunction() {
            return values -> values.stream().min(Double::compare).orElse(Double.NaN);
        }
    },
    MAX {
        @Override
        public Function<ArrayList<Double>, Double> getFunction() {
            return values -> values.stream().max(Double::compare).orElse(Double.NaN);
        }
    },
    AVG {
        @Override
        public Function<ArrayList<Double>, Double> getFunction() {
            return values -> values.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
        }
    },
    SUM {
        @Override
        public Function<ArrayList<Double>, Double> getFunction() {
            return values -> values.stream().mapToDouble(Double::doubleValue).sum();
        }
    },
    COUNT {
        @Override
        public Function<ArrayList<Double>, Double> getFunction() {
            return values -> (double) values.size();
        }
    };

    public abstract Function<ArrayList<Double>, Double> getFunction();

    public double apply(ArrayList<Double> values) {
        return 0;
    }
}

