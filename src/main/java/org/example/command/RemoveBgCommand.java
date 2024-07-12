package org.example.command;

import org.example.adapter.BackgroundRemovalService;

public class RemoveBgCommand implements Command {
    private String image;

    private BackgroundRemovalService backgroundRemovalService;

    public RemoveBgCommand(String image,BackgroundRemovalService backgroundRemovalService) {
        this.image = image;
        this.backgroundRemovalService=backgroundRemovalService;
    }

    @Override
    public void execute() {
        backgroundRemovalService.removeBackground(image);
    }
}
