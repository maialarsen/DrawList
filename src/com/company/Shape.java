package com.company;

import org.w3c.dom.css.Rect;

public class Shape {
    private int x;
    private int y;
    private String color;

    public Selectable isSelected;

    public Shape(String color) {
        this.color = color;
        this.x = 0;
        this.y = 0;

        isSelected = new IsNotSelected();
    }

    public static Shape copyShape(Shape shape) {
        Shape newShape;
        if (shape instanceof Circle)
            shape = new Circle((Circle) shape);
        else if (shape instanceof Rectangle)
            shape = new Rectangle((Rectangle) shape);

        return shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Selectable getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Selectable isSelected) {
        this.isSelected = isSelected;
    }
}
