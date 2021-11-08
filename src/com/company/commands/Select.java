package com.company.commands;

import com.company.*;

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
        if (index > shapes.size())
            System.out.println("ERROR: invalid shape for SELECT");
        else
            shapes.get(index - 1).setIsSelected(new IsSelected());
    }
}
