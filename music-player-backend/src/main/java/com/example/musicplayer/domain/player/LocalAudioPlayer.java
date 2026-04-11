package com.example.musicplayer.domain.player;

import com.example.musicplayer.domain.model.Song;

public class LocalAudioPlayer implements IMusicPlayer {

    private Song currentSong;
    private double volume;

    @Override
    public void play(Song song) {
        // TODO: Implement local audio playback.
    }

    @Override
    public void pause() {
        // TODO: Implement local audio pause.
    }

    @Override
    public void resume() {
        // TODO: Implement local audio resume.
    }

    @Override
    public void stop() {
        // TODO: Implement local audio stop.
    }

    @Override
    public void setVolume(double volume) {
        // TODO: Implement local audio volume control.
    }

    @Override
    public String getStatus() {
        // TODO: Implement status retrieval.
        return "TODO";
    }
}

