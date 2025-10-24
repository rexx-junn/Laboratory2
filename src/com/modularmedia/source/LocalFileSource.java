package com.modularmedia.source;

public class LocalFileSource implements MediaSource {
    private String filename;

    public LocalFileSource(String filename) {
        this.filename = filename;
    }

    @Override
    public String fetch() {
        return "File:" + filename;
    }
}
