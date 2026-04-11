package com.example.musicplayer.domain.model;

public class SongReference {

    private final String title;
    private final String artist;
    private final String sourceUrl;
    private final String coverUrl;

    public SongReference(String title, String artist, String sourceUrl, String coverUrl) {
        this.title = title;
        this.artist = artist;
        this.sourceUrl = sourceUrl;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}

