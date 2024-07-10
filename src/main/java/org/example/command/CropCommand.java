package org.example.command;

public class CropCommand implements Command {
    private String image;
    private int top;
    private int right;
    private int bottom;
    private int left;

    public CropCommand(String image, int top, int right, int bottom, int left) {
        this.image = image;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    @Override
    public void execute() {
        System.out.println("Cropping image " + image + " with top " + top + ", right " + right + ", bottom " + bottom + ", left " + left);
    }
}
