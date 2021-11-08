package com.company;

import java.util.List;

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
