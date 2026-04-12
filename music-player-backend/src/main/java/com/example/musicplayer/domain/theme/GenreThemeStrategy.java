package com.example.musicplayer.domain.theme;

import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;

public class GenreThemeStrategy implements IThemeStrategy {

    @Override
    public UITheme generateTheme(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song must not be null.");
        }

        String genre = song.getGenre();
        if (genre == null || genre.isBlank()) {
            return new UITheme("#1DB954", "#191414", "#FFFFFF", "#121212");
        }

        if (genre.equalsIgnoreCase("rock")) {
            return new UITheme("#B71C1C", "#212121", "#FF5252", "#121212");
        }
        if (genre.equalsIgnoreCase("pop")) {
            return new UITheme("#EC407A", "#7B1FA2", "#F8BBD0", "#FCE4EC");
        }
        if (genre.equalsIgnoreCase("jazz")) {
            return new UITheme("#8D6E63", "#3E2723", "#D7CCC8", "#EFEBE9");
        }

        return new UITheme("#1DB954", "#191414", "#FFFFFF", "#121212");
    }
}

