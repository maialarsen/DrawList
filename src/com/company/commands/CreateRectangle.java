package com.company.commands;

import com.company.Command;
import com.company.Rectangle;
import com.company.Shape;

import java.util.List;

public class CreateRectangle implements Command {
    private List<Shape> shapes;
    private int width;
    private int height;

    public CreateRectangle(List<Shape> shapes, int w, int h) {
        this.shapes = shapes;
        width = w;
        height = h;
    }

    @Override
    public void execute() {
        Rectangle rect = new Rectangle(width, height);
        shapes.add(rect);
    }
}
