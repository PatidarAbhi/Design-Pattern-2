package org.example;

import org.example.adapter.*;
import org.example.command.Command;
import org.example.command.CropCommand;
import org.example.command.RemoveBgCommand;
import org.example.command.ResizeCommand;
import org.example.decorator.CostDecorator;
import org.example.decorator.LoggingDecorator;
import org.example.strategy.CreditCardPayment;
import org.example.strategy.PayPalPayment;
import org.example.strategy.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        String image = "image.jpg";

        Command resizeCommand = new ResizeCommand(image, 800, 600);
        Command cropCommand = new CropCommand(image, 10, 10, 50, 50);

        // Create instances of third-party services
        ServiceA serviceA = new ServiceA();
        ServiceB serviceB = new ServiceB();

        // Create adapters for services A and B
        BackgroundRemovalService adapterA = new ServiceAAdapter(serviceA);
        BackgroundRemovalService adapterB = new ServiceBAdapter(serviceB);

        // Use adapter A for background removal
        Command removeBgCommandA = new RemoveBgCommand(image, adapterA);
        Command decoratedRemoveBgCommandA = new LoggingDecorator(
                new CostDecorator(removeBgCommandA));


        // Use adapter B for background removal
        Command removeBgCommandB = new RemoveBgCommand(image, adapterB);
        Command decoratedRemoveBgCommandB = new LoggingDecorator(
                new CostDecorator(removeBgCommandB));

        // Decorate resize and crop commands
        Command decoratedResizeCommand = new LoggingDecorator(
                new CostDecorator(resizeCommand));
        Command decoratedCropCommand = new LoggingDecorator(
                new CostDecorator(cropCommand));

        System.out.println("Executing Commands with Adapter A:");
        decoratedResizeCommand.execute();
        decoratedCropCommand.execute();
        decoratedRemoveBgCommandA.execute();

        System.out.println("\nExecuting Commands with Adapter B:");
        decoratedResizeCommand.execute();
        decoratedCropCommand.execute();
        decoratedRemoveBgCommandB.execute();

        // Payment processing
        PaymentStrategy paymentStrategy = new CreditCardPayment("1234-5678-9101-1121");
        paymentStrategy.pay(20.0);

        paymentStrategy = new PayPalPayment("user@example.com");
        paymentStrategy.pay(20.0);









    }
}