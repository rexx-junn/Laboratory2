package com.modularmedia.render.decorator;

import com.modularmedia.render.Renderer;

public abstract class RendererDecorator implements Renderer {
    protected Renderer wrappedRenderer;

    public RendererDecorator(Renderer renderer) {
        this.wrappedRenderer = renderer;
    }

    @Override
    public void render(String data) {
        wrappedRenderer.render(data);
    }
}
