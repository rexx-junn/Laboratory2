package com.modularmedia.source;

public class HLSStreamSource implements MediaSource {
    private String streamUrl;

    public HLSStreamSource(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @Override
    public String fetch() {
        // Simulate connecting to a live HLS stream
        return "HLS Stream: " + streamUrl;
    }
}
