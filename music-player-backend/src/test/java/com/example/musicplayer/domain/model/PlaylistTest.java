package com.example.musicplayer.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaylistTest {

    private final Playlist playlist = new Playlist();

    @Test
    void addFirstWhenSongIsNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> playlist.addFirst(null));
    }

    @Test
    void addFirstWithValidSongThrowsUnsupportedUntilImplemented() {
        Song song = createSong();

        UnsupportedOperationException exception =
                assertThrows(UnsupportedOperationException.class, () -> playlist.addFirst(song));

        assertNotNull(exception.getMessage());
    }

    @Test
    void addAtWithInvalidPositionThrowsException() {
        Song song = createSong();

        assertThrows(IndexOutOfBoundsException.class, () -> playlist.addAt(song, 1));
    }

    @Test
    void containsWithBlankSongIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> playlist.contains(" "));
    }

    @Test
    void emptyPlaylistHasNeutralState() {
        assertTrue(playlist.isEmpty());
        assertEquals(0, playlist.getSize());
        assertNull(playlist.getCurrentSong());
        assertNull(playlist.getFirstSong());
        assertNull(playlist.getLastSong());
        assertEquals(0, playlist.toArray().length);
        assertFalse(playlist.contains("song-id"));
    }

    @Test
    void removeAtOnEmptyPlaylistThrowsIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> playlist.removeAt(0));
    }

    private Song createSong() {
        return new Song(
                "song-id",
                "Song Title",
                180,
                "Artist",
                "https://source.test/song.mp3",
                "https://source.test/cover.jpg",
                "rock");
    }
}

