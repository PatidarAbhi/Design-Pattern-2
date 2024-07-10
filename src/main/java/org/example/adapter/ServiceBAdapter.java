package org.example.adapter;

public class ServiceBAdapter implements BackgroundRemovalService {
    private final ServiceB serviceB;

    public ServiceBAdapter(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Override
    public void removeBackground(String image) {
        System.out.println("Using Service B for background removal on image: " + image);
        serviceB.removeBackground(image);
    }
}
