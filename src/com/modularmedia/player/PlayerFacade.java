package com.modularmedia.player;

import com.modularmedia.playlist.*;
import com.modularmedia.render.Renderer;

public class PlayerFacade {
    private final Player player;
    private Playlist playlist;

    public PlayerFacade(Renderer renderer) {
        this.player = new Player(renderer);
    }

    public void setRenderer(Renderer renderer) {
        player.setRenderer(renderer);
    }

    public void loadPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void playAll() {
        if (playlist == null) {
            System.out.println("No playlist loaded.");
            return;
        }

        System.out.println("--- Playing " + playlist.getName() + " ---");
        for (PlaylistItem item : playlist.getItems()) {
            player.play(item);
        }
    }
}
