package com.company;

public class Originator {
    private ShapeState shapeState;

    public void set(ShapeState shapeState) {
        this.shapeState = shapeState;
    }

    public Memento storeInMemento() {
        return new Memento(shapeState);
    }

    public ShapeState restoreFromMemento(Memento memento) {
        return memento.getShapeState();
    }

}
