package com.company.commands;

import com.company.Command;
import com.company.Shape;

public class Draw implements Command {
    private Shape shape;

    public Draw(Shape shape) {
        this.shape = shape;
    }
    @Override
    public void execute() {
        System.out.println(shape);
    }
}
