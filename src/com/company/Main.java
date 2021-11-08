package com.company;

import com.company.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Shape> shapes;

    public static void main(String[] args) {
        shapes = new ArrayList<>();
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

    static void processCommand(String command) {
        Controller controller;
        Shape shape = findSelected();
        String[] tokens = command.split("\\]\\[|\\s*\\[|,|\\]");

        switch (tokens[0].toLowerCase()) {
            case "create rectangle":
                if (tokens.length != 3)
                    System.out.println("This command needs a [width] and [height]");
                else {
                    controller = new Controller(new CreateRectangle(shapes, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
                    controller.press();
                }
                break;
            case "create circle":
                if (tokens.length != 2)
                    System.out.println("This command needs a [radius]");

                else {
                    controller = new Controller(new CreateCircle(shapes, Integer.parseInt(tokens[1])));
                    controller.press();
                }
                break;
            case "select":
                if (tokens.length != 2)
                    System.out.println("This command needs a [shape #]");
                else {
                    if (shape != null)
                        shape.setIsSelected(new IsNotSelected());
                    controller = new Controller(new Select(shapes, Integer.parseInt(tokens[1])));
                    controller.press();
                }
                break;
            case "move":
                if (tokens.length != 3)
                    System.out.println("This command needs a [x] and [y]");
                else {
                    if (shape != null) {
                        controller = new Controller(new Move(shape, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
                        controller.press();
                    } else System.out.println("No shape selected.");
                }
                break;
            case "draw":
                if (shape != null) {
                    controller = new Controller(new Draw(shape));
                    controller.press();
                } else System.out.println("No shape selected");
                break;
            case "color":
                if (tokens.length != 2)
                    System.out.println("This command needs a [color]");
                else {
                    if (shape != null) {
                        controller = new Controller(new Color(shape, tokens[1]));
                        controller.press();
                    } else System.out.println("No shape selected");
                }
                break;
            case "delete":
                if (shape != null) {
                    controller = new Controller(new Delete(shapes, shape));
                    controller.press();
                } else System.out.println("No shape selected");
                break;
            case "drawscene":
                controller = new Controller(new DrawScene(shapes));
                controller.press();
                break;
            case "undo":
                controller = new Controller(new Undo());
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
}
