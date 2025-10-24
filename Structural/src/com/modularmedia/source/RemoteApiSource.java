package com.modularmedia.source;

public class RemoteApiSource implements MediaSource {
    private String url;

    public RemoteApiSource(String url) {
        this.url = url;
    }

    @Override
    public String fetch() {
        return "API Stream:" + url;
    }
}
