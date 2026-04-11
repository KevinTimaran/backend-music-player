package com.example.musicplayer.domain.model;

public abstract class MediaItem {

    private final String id;
    private final String title;
    private final int duration;

    protected MediaItem(String id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}

