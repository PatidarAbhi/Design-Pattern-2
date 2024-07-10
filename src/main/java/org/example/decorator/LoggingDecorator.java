package org.example.decorator;

import org.example.command.Command;

public class LoggingDecorator extends CommandDecorator {
    public LoggingDecorator(Command decoratedCommand) {
        super(decoratedCommand);
    }

    @Override
    public void execute() {
        System.out.println("Logging: Starting operation...");
        decoratedCommand.execute();
        System.out.println("Logging: Operation completed.");
    }
}



