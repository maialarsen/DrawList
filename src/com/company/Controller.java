package com.company;

public class Controller {
    private Command command;

    public Controller(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }
}
