package com.example.musicplayer.domain.theme;

import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;

public class CoverBasedThemeStrategy implements IThemeStrategy {

    @Override
    public UITheme generateTheme(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }

        return new UITheme("#00B8D4", "#263238", "#FFAB00", "#102027");
    }
}

