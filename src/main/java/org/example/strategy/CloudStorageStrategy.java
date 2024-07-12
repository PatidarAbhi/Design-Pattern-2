package org.example.strategy;


public interface CloudStorageStrategy {
    void upload(String filePath, String destinationPath);
    void download(String sourcePath, String localDestinationPath);
}
