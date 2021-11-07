package com.company;

import com.company.commands.CreateCircle;
import com.company.commands.Draw;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Shape> shapes = new ArrayList<>();
        Controller controller;
        String command;
        Scanner sc = new Scanner(System.in);

        printMenu();
        while (sc.hasNext()) {
            command = sc.nextLine();
            processCommand(command);
        }

//        CreateCircle createCircle = new CreateCircle(shapes, 5);
//        controller = new Controller(createCircle);
//        controller.press();
//
//        Draw draw = new Draw(shapes.get(0));
//        controller = new Controller(draw);
//        controller.press();

    }

    static void processCommand(String command) {
        String[] tokens = command.split("\\]\\[|\\s*\\[|,|\\]");

        switch (tokens[0].toLowerCase()) {
            case "create rectangle":
                if (tokens.length != 3)
                    System.out.println("This command needs a [width] and [height]");
                break;
            case "create circle":
                if (tokens.length != 2)
                    System.out.println("This command needs a [radius]");
                break;
            case "select":
                if (tokens.length != 2)
                    System.out.println("This command needs a [shape #]");
                break;
            case "move":
                if (tokens.length != 3)
                    System.out.println("This command needs a [x] and [y]");
                break;
            case "draw":
                break;
            case "color":
                if (tokens.length != 2)
                    System.out.println("This command needs a [color]");
                break;
            case "delete":
                break;
            case "drawscene":
                break;
            case "undo":
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
