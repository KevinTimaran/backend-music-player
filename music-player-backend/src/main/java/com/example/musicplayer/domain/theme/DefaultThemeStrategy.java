package com.example.musicplayer.domain.theme;

import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;

public class DefaultThemeStrategy implements IThemeStrategy {

    @Override
    public UITheme generateTheme(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }

        return new UITheme("#1DB954", "#191414", "#FFFFFF", "#121212");
    }
}

