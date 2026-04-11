package com.example.musicplayer.domain.theme;

import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;

public interface IThemeStrategy {

    UITheme generateTheme(Song song);
}

