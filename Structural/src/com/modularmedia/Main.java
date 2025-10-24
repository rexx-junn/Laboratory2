package com.modularmedia;

import com.modularmedia.player.PlayerFacade;
import com.modularmedia.playlist.MediaFileItem;
import com.modularmedia.playlist.Playlist;
import com.modularmedia.source.LocalFileSource;
import com.modularmedia.source.RemoteApiSource;
import com.modularmedia.source.MediaSource;
import com.modularmedia.render.Renderer;
import com.modularmedia.render.SoftwareRenderer;
import com.modularmedia.render.HardwareRenderer;
import com.modularmedia.render.decorator.WatermarkDecorator;
import com.modularmedia.render.decorator.SubtitleDecorator;
import com.modularmedia.render.decorator.EqualizerDecorator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Modular Media Streaming Suite\n");

        // 1. Create media sources
        MediaSource local = new LocalFileSource("song.mp3");
        MediaSource remote = new RemoteApiSource("https://example.com/stream/lofi");

        // 2. Create a playlist
        Playlist playlist = new Playlist("My Playlist");
        playlist.addItem(new MediaFileItem(local));
        playlist.addItem(new MediaFileItem(remote));

        // 3. Create base renderer (software)
        Renderer renderer = new SoftwareRenderer();

        // 4. Add decorator layers (plugins)
        renderer = new WatermarkDecorator(renderer, "© ModularMedia");
        renderer = new SubtitleDecorator(renderer, "Now Playing...");
        renderer = new EqualizerDecorator(renderer, "Bass Boost");

        // 5. Initialize PlayerFacade
        PlayerFacade player = new PlayerFacade(renderer);
        player.loadPlaylist(playlist);

        // 6. Play all media using decorated software renderer
        player.playAll();

        // 7. Switch renderer at runtime (HardwareRenderer)
        System.out.println("\n>>> Switching to Hardware Renderer...\n");
        Renderer hardware = new HardwareRenderer();
        player.setRenderer(hardware);
        player.playAll();

        System.out.println("\n=== Demo Finished ===");
    }
}
