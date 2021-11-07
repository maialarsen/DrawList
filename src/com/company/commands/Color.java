package com.company.commands;

import com.company.Command;
import com.company.Shape;

public class Color implements Command {
    private Shape shape;
    private String color;

    public Color(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void execute() {
        shape.setColor(color);
    }
}
