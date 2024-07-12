package org.example;

import org.example.adapter.*;
import org.example.command.*;
import org.example.composite.CompositeCommand;
import org.example.decorator.CostDecorator;
import org.example.decorator.LoggingDecorator;
import org.example.strategy.*;

public class Main {
    public static void main(String[] args) {
        String image = "image.jpg";

        Command resizeCommand = new ResizeCommand(image, 800, 600);
        Command cropCommand = new CropCommand(image, 10, 10, 50, 50);

        // Create instances of third-party services
        ServiceB serviceB = new ServiceB();

        // Create adapters for services A and B
        BackgroundRemovalService normalBgRemoveService = new NormalBgRemoveService();
        BackgroundRemovalService adapterB = new ServiceBAdapter(serviceB);

        // Use adapter A for background removal
        Command removeBgCommandA = new RemoveBgCommand(image, normalBgRemoveService);
        Command decoratedRemoveBgCommandA = new LoggingDecorator(
                new CostDecorator(removeBgCommandA));


//        // Use adapter B for background removal
        Command removeBgCommandB = new RemoveBgCommand(image, adapterB);
        Command decoratedRemoveBgCommandB = new LoggingDecorator(
                new CostDecorator(removeBgCommandB));

        // Decorate resize and crop commands
        Command decoratedResizeCommand = new LoggingDecorator(
                new CostDecorator(resizeCommand));
        Command decoratedCropCommand = new LoggingDecorator(
                (cropCommand));

        System.out.println("Executing Commands with Adapter A:");
        decoratedResizeCommand.execute();
        decoratedCropCommand.execute();
        decoratedRemoveBgCommandA.execute();

        //we can add  multiple commands
        CompositeCommand compositeCommand = new CompositeCommand();
        compositeCommand.addCommand(decoratedResizeCommand);
        compositeCommand.addCommand(cropCommand);
        compositeCommand.addCommand(decoratedRemoveBgCommandA);
        compositeCommand.execute();

       System.out.println("\nExecuting Commands with Adapter B:");
        decoratedResizeCommand.execute();
        decoratedCropCommand.execute();
        decoratedRemoveBgCommandB.execute();

       // Payment processing
        PaymentStrategy paymentStrategy = new CreditCardPayment("1234-5678-9101-1121");
        paymentStrategy.pay(20.0);

        paymentStrategy = new PayPalPayment("user@example.com");
        paymentStrategy.pay(20.0);

        //downloading file via se service
        CloudStorageStrategy s3Service = new S3Storage();
        Command downloadFromS3 = new DownloadResultCommand("mybucket/result.jpg", s3Service, "local/path/to/result.jpg");
        downloadFromS3.execute();

    }
}