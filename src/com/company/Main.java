package com.company;

import com.company.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Shape> shapes;
    static CareTaker careTaker;
    static Originator originator;

    public static void main(String[] args) {
        shapes = new ArrayList<>();
        careTaker = new CareTaker();
        originator = new Originator();

        String command;
        Scanner sc = new Scanner(System.in);

        printMenu();
        while (sc.hasNext()) {
            command = sc.nextLine();
            processCommand(command);
        }
    }

    public static Shape findSelected() {
        for (Shape shape: shapes) {
            if (shape.getIsSelected().selected())
                return shape;
        }
        return null;
    }

    public static int findShape(Shape shape) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shape.equals(shapes.get(i)))
                return i;
        }
        return -1;
    }

    static void processCommand(String input) {
        Controller controller;
        Command command;
        Shape shape = findSelected();
        String[] tokens = input.split("\\]\\[|\\s*\\[|,|\\]");

        switch (tokens[0].toLowerCase()) {
            case "create rectangle":
                if (tokens.length != 3)
                    System.out.println("This command needs a [width] and [height]");
                else {
                    command = new CreateRectangle(shapes, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    originator.set(new ShapeState(command, null, shapes.size()));
                    careTaker.addMemento(originator.storeInMemento());
                    controller = new Controller(command);
                    controller.press();
                }
                break;
            case "create circle":
                if (tokens.length != 2)
                    System.out.println("This command needs a [radius]");
                else {
                    command = new CreateCircle(shapes, Integer.parseInt(tokens[1]));
                    originator.set(new ShapeState(command, null, shapes.size()));
                    careTaker.addMemento(originator.storeInMemento());
                    controller = new Controller(command);
                    controller.press();
                }
                break;
            case "select":
                if (tokens.length != 2)
                    System.out.println("This command needs a [shape #]");
                else {
                    if (shape != null)
                        shape.setIsSelected(new IsNotSelected());
                    command = new Select(shapes, Integer.parseInt(tokens[1]));
                    originator.set(new ShapeState(command, Shape.copyShape(shape), shapes.indexOf(shape)));
                    careTaker.addMemento(originator.storeInMemento());
                    controller = new Controller(command);
                    controller.press();
                }
                break;
            case "move":
                if (tokens.length != 3)
                    System.out.println("This command needs a [x] and [y]");
                else {
                    if (shape != null) {
                        command = new Move(shape, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                        originator.set(new ShapeState(command, Shape.copyShape(shape), shapes.indexOf(shape)));
                        careTaker.addMemento(originator.storeInMemento());
                        controller = new Controller(command);
                        controller.press();
                    } else System.out.println("No shape selected.");
                }
                break;
            case "draw":
                if (shape != null) {
                    command = new Draw(shape);
                    originator.set(new ShapeState(command, Shape.copyShape(shape), shapes.indexOf(shape)));
                    careTaker.addMemento(originator.storeInMemento());
                    controller = new Controller(command);
                    controller.press();
                } else System.out.println("No shape selected");
                break;
            case "color":
                if (tokens.length != 2)
                    System.out.println("This command needs a [color]");
                else {
                    if (shape != null) {
                        command = new Color(shape, tokens[1]);
                        originator.set(new ShapeState(command, Shape.copyShape(shape), shapes.indexOf(shape)));
                        careTaker.addMemento(originator.storeInMemento());
                        controller = new Controller(command);
                        controller.press();
                    } else System.out.println("No shape selected");
                }
                break;
            case "delete":
                if (shape != null) {
                    command = new Delete(shapes, shape);
                    originator.set(new ShapeState(command, Shape.copyShape(shape), shapes.indexOf(shape)));
                    careTaker.addMemento(originator.storeInMemento());
                    controller = new Controller(command);
                    controller.press();
                } else System.out.println("No shape selected");
                break;
            case "drawscene":
                command = new DrawScene(shapes);
                originator.set(new ShapeState(command, null, -1));
                careTaker.addMemento(originator.storeInMemento());
                controller = new Controller(command);
                controller.press();
                break;
            case "undo":
                command = new Undo();
                controller = new Controller(command);
                controller.press();
                break;
            default:
                System.out.println("The command: " + tokens[0] + " is not valid");
                printMenu();
                break;
        }
    }
    static void printMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("Please select a command from the following");
        System.out.println("CREATE RECTANGLE [width][height]");
        System.out.println("CREATE CIRCLE [radius]");
        System.out.println("SELECT [shape #]");
        System.out.println("MOVE [x][y]");
        System.out.println("DRAW");
        System.out.println("COLOR [color]");
        System.out.println("DELETE");
        System.out.println("DRAWSCENE");
        System.out.println("UNDO");
        System.out.println("------------------------------------------\n");
    }

    public static List<Shape> getShapes() {
        return shapes;
    }
    public static CareTaker getCareTaker() {
        return careTaker;
    }
    public static Originator getOriginator() {
        return originator;
    }
}