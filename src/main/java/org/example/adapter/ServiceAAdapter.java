package org.example.adapter;

public class ServiceAAdapter implements BackgroundRemovalService {
    private ServiceA serviceA;

    public ServiceAAdapter(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public void removeBackground(String image) {
        System.out.println("Using Service A for background removal on image: " + image);
        serviceA.performBackgroundRemoval(image);
    }
}
