package com.example.musicplayer.service;

import com.example.musicplayer.domain.external.MusicDownloadAPI;
import com.example.musicplayer.domain.model.Playlist;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;
import com.example.musicplayer.domain.player.IMusicPlayer;
import com.example.musicplayer.domain.theme.IThemeStrategy;

public class PlayerService {

    private final Playlist playlist;
    private final IMusicPlayer player;
    private IThemeStrategy themeStrategy;
    private final MusicDownloadAPI downloadService;

    public PlayerService(
            Playlist playlist,
            IMusicPlayer player,
            IThemeStrategy themeStrategy,
            MusicDownloadAPI downloadService) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist must not be null.");
        }
        if (player == null) {
            throw new IllegalArgumentException("Player must not be null.");
        }
        if (themeStrategy == null) {
            throw new IllegalArgumentException("Theme strategy must not be null.");
        }

        this.playlist = playlist;
        this.player = player;
        this.themeStrategy = themeStrategy;
        this.downloadService = downloadService;
    }

    public void addSongToStart(Song song) {
        playlist.addFirst(song);
    }

    public void addSongToEnd(Song song) {
        playlist.addLast(song);
    }

    public void addSongToPosition(Song song, int position) {
        playlist.addAt(song, position);
    }

    public void deleteSongById(String songId) {
        playlist.removeById(songId);
    }

    public void deleteSongAt(int position) {
        playlist.removeAt(position);
    }

    public void moveSong(int fromPosition, int toPosition) {
        playlist.move(fromPosition, toPosition);
    }

    public void playCurrent() {
        Song song = playlist.getCurrentSong();
        if (song != null) {
            player.play(song);
        }
    }

    public Song playNext() {
        Song song = playlist.nextSong();
        if (song != null) {
            player.play(song);
        }
        return song;
    }

    public Song playPrevious() {
        Song song = playlist.previousSong();
        if (song != null) {
            player.play(song);
        }
        return song;
    }

    public void pausePlayback() {
        player.pause();
    }

    public void resumePlayback() {
        player.resume();
    }

    public void stopPlayback() {
        player.stop();
    }

    public Song selectSong(int position) {
        playlist.setCurrent(position);
        Song song = playlist.getCurrentSong();
        if (song != null) {
            player.play(song);
        }
        return song;
    }

    public void changeThemeStrategy(IThemeStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Theme strategy must not be null.");
        }

        themeStrategy = strategy;
    }

    public UITheme getThemeForCurrentSong() {
        Song song = playlist.getCurrentSong();
        if (song == null) {
            return null;
        }

        return themeStrategy.generateTheme(song);
    }

    public Song[] getPlaylistSongs() {
        return playlist.toArray();
    }

    public Song getCurrentSong() {
        return playlist.getCurrentSong();
    }

    public String getPlayerStatus() {
        return player.getStatus();
    }
}

