package com.modularmedia.playlist;

import com.modularmedia.source.MediaSource;

public class MediaFileItem implements PlaylistItem {
    private MediaSource source;

    public MediaFileItem(MediaSource source) {
        this.source = source;
    }

    @Override
    public String getData() {
        return source.fetch();
    }
}
