package org.example.decorator;

import org.example.command.Command;

public abstract class CommandDecorator implements Command {
    protected Command decoratedCommand;

    public CommandDecorator(Command decoratedCommand) {
        this.decoratedCommand = decoratedCommand;
    }

    @Override
    public void execute() {
        decoratedCommand.execute();
    }
}
