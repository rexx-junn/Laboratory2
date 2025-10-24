package com.modularmedia.render;

public class SoftwareRenderer implements Renderer {
    @Override
    public void render(String data) {
        System.out.println("[SoftwareRenderer] Rendering: " + data);
    }
}
