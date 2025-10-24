package com.modularmedia.playlist;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements PlaylistItem {
    private String name;
    private final List<PlaylistItem> items = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public void addItem(PlaylistItem item) {
        items.add(item);
    }

    public List<PlaylistItem> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getData() {
        return "Playlist: " + name;
    }
}
