package org.example.strategy;

public class S3Storage implements CloudStorageStrategy{

    @Override
    public void upload(String filePath, String destinationPath) {
        System.out.println("Uploading " + filePath + " to AWS S3 at " + destinationPath);
    }

    @Override
    public void download(String sourcePath, String localDestinationPath) {
        System.out.println("Downloading from AWS Actual download code using s3Client");
    }
}
