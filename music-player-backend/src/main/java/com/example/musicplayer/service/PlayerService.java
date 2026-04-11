package com.example.musicplayer.service;

import com.example.musicplayer.domain.external.MusicDownloadAPI;
import com.example.musicplayer.domain.model.Playlist;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.player.IMusicPlayer;
import com.example.musicplayer.domain.theme.IThemeStrategy;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final Playlist playlist;
    private IMusicPlayer musicPlayer;
    private IThemeStrategy themeStrategy;
    private final MusicDownloadAPI musicDownloadAPI;

    public PlayerService(
            Playlist playlist,
            IMusicPlayer musicPlayer,
            IThemeStrategy themeStrategy,
            MusicDownloadAPI musicDownloadAPI) {
        this.playlist = playlist;
        this.musicPlayer = musicPlayer;
        this.themeStrategy = themeStrategy;
        this.musicDownloadAPI = musicDownloadAPI;
    }

    public void addSongToStart(Song song) {
        // TODO: Implement service orchestration.
    }

    public void addSongToEnd(Song song) {
        // TODO: Implement service orchestration.
    }

    public void addSongToPosition(Song song, int position) {
        // TODO: Implement service orchestration.
    }

    public void deleteSongById(String songId) {
        // TODO: Implement service orchestration.
    }

    public void deleteSongAt(int position) {
        // TODO: Implement service orchestration.
    }

    public void moveSong(int fromPosition, int toPosition) {
        // TODO: Implement service orchestration.
    }

    public void playCurrent() {
        // TODO: Implement service orchestration.
    }

    public void playNext() {
        // TODO: Implement service orchestration.
    }

    public void playPrevious() {
        // TODO: Implement service orchestration.
    }

    public void pausePlayback() {
        // TODO: Implement service orchestration.
    }

    public void resumePlayback() {
        // TODO: Implement service orchestration.
    }

    public void stopPlayback() {
        // TODO: Implement service orchestration.
    }

    public void selectSong(int position) {
        // TODO: Implement service orchestration.
    }

    public void changeThemeStrategy(IThemeStrategy strategy) {
        // TODO: Implement strategy switching.
    }
}

