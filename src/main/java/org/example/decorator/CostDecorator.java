package org.example.decorator;

import org.example.command.Command;

public class CostDecorator extends CommandDecorator {
    public CostDecorator(Command decoratedCommand) {
        super(decoratedCommand);
    }

    @Override
    public void execute() {
        System.out.println("Cost calculation: This operation costs 5 units.");
        decoratedCommand.execute();
    }
}
