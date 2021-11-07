package com.company.commands;

import com.company.Command;
import com.company.Shape;

public class Move implements Command {
    private Shape shape;
    private int x;
    private int y;

    public Move(Shape shape, int x, int y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }
    @Override
    public void execute() {
        shape.setX(x);
        shape.setY(y);
    }
}
