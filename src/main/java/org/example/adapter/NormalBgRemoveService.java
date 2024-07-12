package org.example.adapter;

public class NormalBgRemoveService implements BackgroundRemovalService {
    @Override
    public void removeBackground(String image) {

        System.out.println("Using Normal Service for background removal on image: " + image);

    }
}
