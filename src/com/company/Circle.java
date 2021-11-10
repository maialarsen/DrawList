package com.company;

public class Circle extends Shape{
    private int radius;

    public Circle(int radius) {
        super("Blue");
        this.radius = radius;
    }

    public Circle (Circle circle) {
        super(circle.getColor());
        setX(circle.getX());
        setY(circle.getY());
        setIsSelected(circle.isSelected);
        radius = circle.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle, Color: " + getColor() + ", Origin: (" + getX() + ","
                + getY() + "), Radius: " + getRadius();
    }
}
