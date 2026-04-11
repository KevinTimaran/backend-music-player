package com.example.musicplayer.domain.model;

public class Song extends MediaItem {

    private final String artist;
    private final String sourceUrl;
    private final String coverUrl;
    private final String genre;

    public Song(
            String id,
            String title,
            int duration,
            String artist,
            String sourceUrl,
            String coverUrl,
            String genre) {
        super(id, title, duration);
        this.artist = artist;
        this.sourceUrl = sourceUrl;
        this.coverUrl = coverUrl;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public String getDisplayName() {
        return getTitle() + " - " + artist;
    }
}

