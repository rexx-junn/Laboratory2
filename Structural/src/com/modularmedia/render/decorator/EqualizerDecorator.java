package com.modularmedia.render.decorator;

import com.modularmedia.render.Renderer;

public class EqualizerDecorator extends RendererDecorator {
    private String profile;

    public EqualizerDecorator(Renderer renderer, String profile) {
        super(renderer);
        this.profile = profile;
    }

    @Override
    public void render(String data) {
        super.render(data);
        System.out.println("[Equalizer] Applied: " + profile);
    }
}
