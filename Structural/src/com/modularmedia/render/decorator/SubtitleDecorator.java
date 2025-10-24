package com.modularmedia.render.decorator;

import com.modularmedia.render.Renderer;

public class SubtitleDecorator extends RendererDecorator {
    private String subtitleText;

    public SubtitleDecorator(Renderer renderer, String subtitleText) {
        super(renderer);
        this.subtitleText = subtitleText;
    }

    @Override
    public void render(String data) {
        // Call the wrapped renderer first
        super.render(data);  // ✅ This now works
        // Then add subtitles
        System.out.println("[Subtitle] " + subtitleText);
    }
}
