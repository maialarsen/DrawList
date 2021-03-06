package com.company;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        super("Red");
        this.width = width;
        this.height = height;
    }

    public Rectangle (Rectangle rectangle) {
        super(rectangle.getColor());
        setX(rectangle.getX());
        setY(rectangle.getY());
        setIsSelected(rectangle.isSelected);
        width = rectangle.width;
        height = rectangle.height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle, Color: " + getColor() + ", Origin: (" + getX() + ","
                + getY() + "), Width: " + getWidth() + ", Height: " + getHeight();
    }
}
