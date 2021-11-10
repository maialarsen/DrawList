package com.company;

public class Memento {
    private ShapeState shapeState;

    public Memento(ShapeState shapeState) {
        this.shapeState = shapeState;
    }

    public ShapeState getShapeState() {
        return shapeState;
    }
}
