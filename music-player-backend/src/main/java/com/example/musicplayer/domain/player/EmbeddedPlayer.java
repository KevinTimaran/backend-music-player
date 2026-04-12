package com.example.musicplayer.domain.player;

import com.example.musicplayer.domain.model.Song;

public class EmbeddedPlayer implements IMusicPlayer {

    private Song currentSong;
    private double volume;
    private String status;

    public EmbeddedPlayer() {
        this.volume = 50.0;
        this.status = "STOPPED";
    }

    @Override
    public void play(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }

        currentSong = song;
        status = "PLAYING";
    }

    @Override
    public void pause() {
        if ("PLAYING".equals(status)) {
            status = "PAUSED";
        }
    }

    @Override
    public void resume() {
        if ("PAUSED".equals(status)) {
            status = "PLAYING";
        }
    }

    @Override
    public void stop() {
        status = "STOPPED";
        currentSong = null;
    }

    @Override
    public void setVolume(double volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100.");
        }

        this.volume = volume;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public double getVolume() {
        return volume;
    }
}

