package com.googlecahsi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Region {
    private ArrayList<Area> areas;
    // Additional fields for compactness and dissimilarity may be added here

    // Constructor
    public Region() {
        this.areas = new ArrayList<>();
        // Initialize additional fields if needed
    }

    public Region(ArrayList<Area> areas) {
        this.areas = new ArrayList<>(areas);
        // Initialize additional fields if needed
    }

    // Add area to the region
    public void add(Area area) {
        areas.add(area);
        // Update compactness and dissimilarity if stored
    }

    public boolean contains(Area area) {
        return areas.contains(area);
    }

    public int getCardinality() {
        return areas.size();
    }

    public double getCompactness() {
        // Implement compactness calculation based on Definition 5
        public static double calculateCompactness(double area, double momentOfInertia) {
            return area / (2 * Math.PI * momentOfInertia);
        }

        public static void main(String[] args) {
            // Example: placeholder values
            double regionArea = 50.0; // Replace with the actual area of the region
            double momentOfInertia = 30.0; // Replace with the actual moment of inertia of the region

            double compactness = calculateCompactness(regionArea, momentOfInertia);
            System.out.println("Compactness of the region: " + compactness);
        }
    }

    public double getDissimilarity(String objective,
                                          HashMap<Integer, Area> areas) {

        double dissimilarity = 0;

        if (objective == "heterogeneous") {

            for (int i = 0; i < this.areas.size(); i++) {

                for (int j = i + 1; j < this.areas.size(); j++) {
                    dissimilarity += Math.abs(Math.abs(areas.get(i).get_dissimilarity_attr())
                            - Math.abs(Math.abs(areas.get(j).get_dissimilarity_attr())));
                }

            }
        }
        return dissimilarity;
    }


    public boolean isBoundary(Area area) {
        Set<Area> regionNeighbors = new HashSet<>();
        Set<Area> allNeighbors = new HashSet<>();

        for (Area currentArea : areas) {
            if (currentArea.isNeighbor(area)) {
                allNeighbors.add(currentArea);

                if (!contains(currentArea)) {
                    regionNeighbors.add(currentArea);
                }
            }
        }

        return contains(area) && !regionNeighbors.isEmpty() && !allNeighbors.equals(regionNeighbors);
    }

    public boolean isNeighbor(Area area) {
        for (Area currentArea : areas) {
            if (currentArea.isNeighbor(area) && !contains(area)) {
                return true;
            }
        }
        return false;
    }

    public Area remove(Area area) {
        Iterator<Area> iterator = areas.iterator();
        while (iterator.hasNext()) {
            Area currentArea = iterator.next();
            if (currentArea.equals(area)) {
                iterator.remove();
                // Update compactness and dissimilarity if stored
                // Implement as needed based on your requirements
                return currentArea;
            }
        }
        return null;
    }

    // Test a constraint over all areas in a region

    public double test(Constraint constraint) {
        ArrayList<Double> values = new ArrayList<>();
        for (Area area : areas) {
            values.add(area.test(constraint));
        }
        return constraint.getFunction().apply(values);
    }

    // Test a constraint's function with an additional area
    public double testWith(Constraint constraint, Area area) {
        ArrayList<Double> values = new ArrayList<>();
        for (Area currentArea : areas) {
            values.add(currentArea.test(constraint));
        }
        values.add(area.test(constraint));
        return constraint.getFunction().apply(values);
    }

    // Test a constraint's function without a specific area
    public double testWithout(Constraint constraint, Area area) {
        ArrayList<Double> values = new ArrayList<>();
        for (Area currentArea : areas) {
            if (!currentArea.equals(area)) {
                values.add(currentArea.test(constraint));
            }
        }
        return constraint.getFunction().apply(values);
    }
}

