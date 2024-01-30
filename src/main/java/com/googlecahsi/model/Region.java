package com.googlecahsi.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Region {
    private ArrayList<Area> areas;

    public Region() {
        this.areas = new ArrayList<>();
    }

    // Other constructors, getters, and setters for areas

    public void add(Area area) {
        areas.add(area);
        area.setRegion(this);
        // Implement logic to update compactness and dissimilarity if stored
    }

    public boolean contains(Area area) {
        return areas.contains(area);
    }

    public int getCardinality() {
        return areas.size();
    }

    public double getCompactness() {
        // Implement logic to calculate the compactness of the region
        // based on the areas
        return 0.0;
    }

    public double getDissimilarity() {
        // Implement logic to calculate the dissimilarity of the region
        // based on the areas
        return 0.0;
    }

    // Implement other methods
    //add here:
}

