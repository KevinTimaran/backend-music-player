package com.example.musicplayer.domain.player;

import com.example.musicplayer.domain.model.Song;

public class EmbeddedPlayer implements IMusicPlayer {

    private Song currentSong;
    private double volume;

    @Override
    public void play(Song song) {
        // TODO: Implement embedded playback.
    }

    @Override
    public void pause() {
        // TODO: Implement embedded pause.
    }

    @Override
    public void resume() {
        // TODO: Implement embedded resume.
    }

    @Override
    public void stop() {
        // TODO: Implement embedded stop.
    }

    @Override
    public void setVolume(double volume) {
        // TODO: Implement embedded volume control.
    }

    @Override
    public String getStatus() {
        // TODO: Implement status retrieval.
        return "TODO";
    }
}

