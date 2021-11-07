package com.company.commands;

import com.company.Circle;
import com.company.Command;
import com.company.Shape;

import java.util.List;

public class CreateCircle implements Command {
    private List<Shape> shapes;
    private int radius;

    public CreateCircle(List<Shape> shapes, int r) {
        this.shapes = shapes;
        radius = r;
    }

    @Override
    public void execute() {
        Circle circle = new Circle(radius);
        shapes.add(circle);
    }
}
