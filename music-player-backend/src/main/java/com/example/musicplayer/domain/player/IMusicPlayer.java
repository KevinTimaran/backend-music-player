package com.example.musicplayer.domain.player;

import com.example.musicplayer.domain.model.Song;

public interface IMusicPlayer {

    void play(Song song);

    void pause();

    void resume();

    void stop();

    void setVolume(double volume);

    String getStatus();
}

