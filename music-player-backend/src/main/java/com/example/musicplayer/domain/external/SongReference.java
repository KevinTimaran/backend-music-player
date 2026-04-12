package com.example.musicplayer.domain.external;

public class SongReference {

    private String title;
    private String artist;
    private String sourceUrl;
    private String coverUrl;

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


