package com.modularmedia.render;

public class HardwareRenderer implements Renderer {

    @Override
    public void render(String data) {
        System.out.println("[HardwareRenderer] GPU rendering: " + data);
    }
}
