package com.company.commands;

import com.company.Command;
import com.company.Shape;

import java.util.List;

public class Select implements Command {
    private List<Shape> shapes;
    int index;

    public Select(List<Shape> shapes, int index) {
        this.shapes = shapes;
        this.index = index;
    }

    @Override
    public void execute() {
        System.out.println(shapes.get(index));
    }
}
