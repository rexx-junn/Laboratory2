package com.modularmedia.source;

public class StreamProxy implements MediaSource {
    private MediaSource realSource;
    private String cachedData;

    public StreamProxy(MediaSource realSource) {
        this.realSource = realSource;
    }

    @Override
    public String fetch() {
        if (cachedData == null) {
            System.out.println("[Proxy] Fetching and caching stream...");
            cachedData = realSource.fetch();
        } else {
            System.out.println("[Proxy] Returning cached stream...");
        }
        return cachedData;
    }
}
