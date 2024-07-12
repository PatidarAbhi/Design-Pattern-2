package org.example.strategy;

public class GoogleDriveStorage implements CloudStorageStrategy {

    @Override
    public void upload(String filePath, String destinationPath) {
        System.out.println("Uploading " + filePath + " to Google Drive at " + destinationPath);
    }

    @Override
    public void download(String sourcePath, String localDestinationPath) {
        System.out.println("Downloading from Google Drive at " + sourcePath + " to " + localDestinationPath);
    }
}
