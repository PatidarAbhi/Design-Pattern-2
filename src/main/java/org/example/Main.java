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

        BackgroundRemovalService normalBgRemoveService = new NormalBgRemoveService();

        Command removeBgCommandWithNormalService = new RemoveBgCommand(image, normalBgRemoveService);

        //executing commands with normal services
        resizeCommand.execute();
        cropCommand.execute();
        removeBgCommandWithNormalService.execute();

        // Create instances of third-party services
        ServiceA serviceA = new ServiceA();

        // Create adapters for services A
        BackgroundRemovalService adapterA = new ServiceAAdapter(serviceA);

        // Use adapter A for background removal
        Command removeBgCommandB = new RemoveBgCommand(image, adapterA);
        removeBgCommandB.execute();


        //decorate commands with some new operation like login ,cost
        Command decoratedResizeCommand = new LoggingDecorator(
                (resizeCommand));
        decoratedResizeCommand.execute();

        Command decoratedCropCommand = new LoggingDecorator(
                (cropCommand));
        decoratedCropCommand.execute();

        Command decoratedRemoveBgCommandA = new LoggingDecorator(
                new CostDecorator(removeBgCommandB));
        decoratedRemoveBgCommandA.execute();

        System.out.println("Executing multiple commands using composite pattern");
          //we can add  multiple commands
        CompositeCommand compositeCommand = new CompositeCommand();
        compositeCommand.addCommand(decoratedResizeCommand);
        compositeCommand.addCommand(decoratedCropCommand);
        compositeCommand.addCommand(decoratedRemoveBgCommandA);
        compositeCommand.execute();

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