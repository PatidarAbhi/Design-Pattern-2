package org.example.command;

import org.example.strategy.CloudStorageStrategy;

public class DownloadResultCommand implements Command{

    private String sourcePath;
    private CloudStorageStrategy storageStrategy;
    private String localDestinationPath;


    public DownloadResultCommand(String sourcePath, CloudStorageStrategy storageStrategy, String localDestinationPath) {
        this.sourcePath = sourcePath;
        this.storageStrategy = storageStrategy;
        this.localDestinationPath = localDestinationPath;
    }

    @Override
    public void execute() {
        System.out.println("Downloading result from: " + sourcePath + " to " + localDestinationPath);
        storageStrategy.download(sourcePath, localDestinationPath);
    }


}
