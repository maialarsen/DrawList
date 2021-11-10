package com.company;

import java.util.ArrayList;

public class CareTaker {
    ArrayList<Memento> savedStates = new ArrayList<>();
    public void addMemento(Memento m) {
        savedStates.add(m);
    }
    public Memento getMemento() {
        Memento m = savedStates.get(savedStates.size() - 1);
        savedStates.remove(m);
        return m;
    }
    public ArrayList<Memento> getSavedStates() {
        return savedStates;
    }
}
