package com.example.musicplayer.config;

import com.example.musicplayer.domain.external.MusicDownloadAPI;
import com.example.musicplayer.domain.external.SongReference;
import com.example.musicplayer.domain.model.Playlist;
import com.example.musicplayer.domain.player.IMusicPlayer;
import com.example.musicplayer.domain.player.LocalAudioPlayer;
import com.example.musicplayer.domain.theme.DefaultThemeStrategy;
import com.example.musicplayer.domain.theme.IThemeStrategy;
import com.example.musicplayer.service.PlayerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Playlist playlist() {
        return new Playlist();
    }

    @Bean
    public IMusicPlayer musicPlayer() {
        return new LocalAudioPlayer();
    }

    @Bean
    public IThemeStrategy themeStrategy() {
        return new DefaultThemeStrategy();
    }

    @Bean
    public MusicDownloadAPI musicDownloadAPI() {
        return this::createFallbackSongReference;
    }

    private SongReference createFallbackSongReference(String queryOrUrl) {
        String normalizedQuery = (queryOrUrl == null || queryOrUrl.isBlank()) ? "unknown" : queryOrUrl.trim();

        return new SongReference(
                normalizedQuery,
                "Unknown Artist",
                "https://source.test/" + normalizedQuery,
                "https://source.test/default-cover.jpg");
    }

    @Bean
    public PlayerService playerService(
            Playlist playlist,
            IMusicPlayer musicPlayer,
            IThemeStrategy themeStrategy,
            MusicDownloadAPI musicDownloadAPI) {
        return new PlayerService(playlist, musicPlayer, themeStrategy, musicDownloadAPI);
    }
}