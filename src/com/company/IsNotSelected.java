package com.company;

public class IsNotSelected implements Selectable {

    @Override
    public boolean selected() {
        return false;
    }
}
