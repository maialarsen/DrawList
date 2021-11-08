package com.company.commands;

import com.company.Command;
import com.company.Shape;

import java.util.List;

public class Delete implements Command {
    private List<Shape> shapes;
    private Shape shape;

    public Delete(List<Shape> shapes, Shape shape) {
        this.shapes = shapes;
        this.shape = shape;
    }

    @Override
    public void execute() {
        shapes.remove(shape);
    }
}
