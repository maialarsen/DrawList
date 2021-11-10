package com.company.commands;

import com.company.*;

public class Undo implements Command {
    @Override
    public void execute() {
        if (Main.getCareTaker().getSavedStates().size() == 0) {
            System.out.println("Nothing to undo");
            return;
        }
        Memento memento = Main.getCareTaker().getMemento();
        ShapeState prevState = Main.getOriginator().restoreFromMemento(memento);

        switch (prevState.getCommand().getClass().getSimpleName().toLowerCase()) {
            case "createrectangle":
            case "createcircle":
                Main.getShapes().remove(prevState.getIndex());
                break;
            case "select":
                Main.findSelected().setIsSelected(new IsNotSelected());
                if (prevState.getShapeState() != null)
                    Main.getShapes().get(prevState.getIndex()).setIsSelected(new IsSelected());
                break;
            case "move":
                Main.getShapes().get(prevState.getIndex()).setX(prevState.getShapeState().getX());
                Main.getShapes().get(prevState.getIndex()).setY(prevState.getShapeState().getY());
                break;
            case "color":
                Main.getShapes().get(prevState.getIndex()).setColor(prevState.getShapeState().getColor());
                break;
            case "delete":
                if (Main.findSelected() != null)
                    Main.findSelected().setIsSelected(new IsNotSelected());
                Main.getShapes().add(prevState.getIndex(), prevState.getShapeState());
                break;
        }
    }
}
