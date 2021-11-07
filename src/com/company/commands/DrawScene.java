package com.company.commands;

import com.company.Command;
import com.company.Shape;

import java.util.List;

public class DrawScene implements Command {
    private List<Shape> shapes;

    public DrawScene(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void execute() {
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
