package com.example.musicplayer.controller;

import com.example.musicplayer.controller.dto.CreateSongRequest;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.domain.model.UITheme;
import com.example.musicplayer.service.PlayerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return playerService.getPlayerStatus();
    }

    @GetMapping("/current")
    public Song getCurrentSong() {
        return playerService.getCurrentSong();
    }

    @GetMapping("/songs")
    public Song[] getSongs() {
        return playerService.getPlaylistSongs();
    }

    @GetMapping("/theme")
    public UITheme getTheme() {
        return playerService.getThemeForCurrentSong();
    }

    @PostMapping("/play")
    public String playCurrent() {
        playerService.playCurrent();
        return "Playback started";
    }

    @PostMapping("/next")
    public Song playNext() {
        return playerService.playNext();
    }

    @PostMapping("/previous")
    public Song playPrevious() {
        return playerService.playPrevious();
    }

    @PostMapping("/pause")
    public String pause() {
        playerService.pausePlayback();
        return "Playback paused";
    }

    @PostMapping("/resume")
    public String resume() {
        playerService.resumePlayback();
        return "Playback resumed";
    }

    @PostMapping("/stop")
    public String stop() {
        playerService.stopPlayback();
        return "Playback stopped";
    }

    @PostMapping("/songs/start")
    public String addSongToStart(@RequestBody CreateSongRequest request) {
        Song song = new Song(
                request.getId(),
                request.getTitle(),
                request.getDuration(),
                request.getArtist(),
                request.getSourceUrl(),
                request.getCoverUrl(),
                request.getGenre());
        playerService.addSongToStart(song);
        return "Song added to start";
    }

    @PostMapping("/songs/end")
    public String addSongToEnd(@RequestBody CreateSongRequest request) {
        Song song = new Song(
                request.getId(),
                request.getTitle(),
                request.getDuration(),
                request.getArtist(),
                request.getSourceUrl(),
                request.getCoverUrl(),
                request.getGenre());
        playerService.addSongToEnd(song);
        return "Song added to end";
    }

    @PostMapping("/songs/position/{position}")
    public String addSongAtPosition(@RequestBody CreateSongRequest request, @PathVariable int position) {
        Song song = new Song(
                request.getId(),
                request.getTitle(),
                request.getDuration(),
                request.getArtist(),
                request.getSourceUrl(),
                request.getCoverUrl(),
                request.getGenre());
        playerService.addSongToPosition(song, position);
        return "Song added at position";
    }

    @DeleteMapping("/songs/position/{position}")
    public String deleteSongAtPosition(@PathVariable int position) {
        playerService.deleteSongAt(position);
        return "Song deleted at position";
    }

    @PostMapping("/move")
    public String moveSong(@RequestParam int from, @RequestParam int to) {
        playerService.moveSong(from, to);
        return "Song moved";
    }

    @PostMapping("/select/{position}")
    public Song selectSong(@PathVariable int position) {
        return playerService.selectSong(position);
    }

    @DeleteMapping("/songs/{songId}")
    public String deleteSong(@PathVariable String songId) {
        playerService.deleteSongById(songId);
        return "Song deleted";
    }
}

