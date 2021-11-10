package com.company;

public class ShapeState {
    private Command command;
    private Shape shapeState;
    private int index;

    public ShapeState(Command command, Shape shapeState, int index) {
        this.command = command;
        this.shapeState = shapeState;
        this.index = index;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Shape getShapeState() {
        return shapeState;
    }

    public void setShapeState(Shape shapeState) {
        this.shapeState = shapeState;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
