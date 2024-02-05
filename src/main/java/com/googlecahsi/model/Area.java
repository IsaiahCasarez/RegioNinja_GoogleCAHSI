package com.googlecahsi.model;

import java.util.HashMap;
import java.util.stream.Stream;
import com.googlecahsi.model.Geometry;
import com.googlecahsi.model.Point;

public class Area {
    private int id;
    private Geometry polygon;
    private HashMap<String, Double> attributes;
    private double dissimilarity;
    private Region region;

    // Constructor
    public Area(int id, Geometry polygon, HashMap<String, Double> attributes, double dissimilarity) {
        this.id = id;
        this.polygon = polygon;
        this.attributes = attributes;
        this.dissimilarity = dissimilarity;
        this.region = null; // Initially unassigned
    }

    // Getter methods

    public int getId() {
        return id;
    }

    public Geometry getPolygon() {
        return polygon;
    }

//    public Point getCentroid() {
//       return Point();
//    }

    public double getDissimilarity() {
        return dissimilarity;
    }

    // Other methods
    public boolean isArticulationArea(Region region) {
        // Implementation based on spatial contiguity check
        // For example, using JTS library's touches() method for Geometry
        // Logic to check if removing the area breaks spatial contiguity of the given region
        // Implement as needed
        return region.getAreas().stream().anyMatch(this::isNeighbor);
    }

    public boolean isAssigned() {
        return region != null;
    }

    public boolean isNeighbor(Area area) {

       // return polygon.touches(otherArea.getPolygon());
        return false;
    }

    public Double test(Constraint constraint) {
        // Implementation based on applying the constraint's function to the relevant attribute
        // Adjust this based on specific requirements and the Constraint class
       // return constraint.getFunction().apply(attributes.get(constraint.getAttribute()));
        return 2.0;
    }

    // Additional methods for handling region assignment
    public void assignToRegion(Region region) {
        this.region = region;
      //  region.addArea(this);
    }

    public void removeFromRegion() {
        if (isAssigned()) {
           // region.removeArea(this);
            this.region = null;
        }
    }
}

