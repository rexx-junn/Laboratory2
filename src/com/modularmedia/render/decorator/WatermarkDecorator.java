package com.modularmedia.render.decorator;

import com.modularmedia.render.Renderer;

public class WatermarkDecorator extends RendererDecorator {

    private String watermarkText;

    public WatermarkDecorator(Renderer renderer, String watermarkText) {
        super(renderer);
        this.watermarkText = watermarkText;
    }

    @Override
    public void render(String data) {
        super.render(data);
        System.out.println("[Watermark] Applied: " + watermarkText);
    }
}
