package com.modularmedia.player;

import com.modularmedia.playlist.PlaylistItem;
import com.modularmedia.render.Renderer;

public class Player {
    private Renderer renderer;

    public Player(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void play(PlaylistItem item) {
        renderer.render(item.getData());
    }
}
