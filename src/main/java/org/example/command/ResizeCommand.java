package org.example.command;

public class ResizeCommand implements Command{

    private final String image;
    private final int width;
    private final int height;

    public ResizeCommand(String image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        System.out.println("Resizing image " + image + " to " + width + "x" + height);
    }
}
