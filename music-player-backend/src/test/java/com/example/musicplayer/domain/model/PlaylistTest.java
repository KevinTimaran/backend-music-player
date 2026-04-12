package com.example.musicplayer.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    void addFirstWithValidSongAddsSongAtHead() {
        Song song = createSong();

        playlist.addFirst(song);

        assertFalse(playlist.isEmpty());
        assertEquals(1, playlist.getSize());
        assertEquals(song, playlist.getFirstSong());
        assertEquals(song, playlist.getCurrentSong());
        assertTrue(playlist.contains(song.getId()));
    }

    @Test
    void addFirstWithTwoSongsUpdatesHeadTailAndCurrentCorrectly() {
        Song firstInserted = createSong("song-1", "First Song");
        Song secondInserted = createSong("song-2", "Second Song");

        playlist.addFirst(firstInserted);
        playlist.addFirst(secondInserted);

        assertEquals(2, playlist.getSize());
        assertEquals(secondInserted, playlist.getFirstSong());
        assertEquals(firstInserted, playlist.getLastSong());
        assertEquals(firstInserted, playlist.getCurrentSong());

        Song[] songs = playlist.toArray();
        assertEquals(2, songs.length);
        assertEquals(secondInserted, songs[0]);
        assertEquals(firstInserted, songs[1]);
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
        return createSong("song-id", "Song Title");
    }

    private Song createSong(String id, String title) {
        return new Song(
                id,
                title,
                180,
                "Artist",
                "https://source.test/song.mp3",
                "https://source.test/cover.jpg",
                "rock");
    }
}

