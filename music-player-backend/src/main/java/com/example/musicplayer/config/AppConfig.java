package com.example.musicplayer.config;

import com.example.musicplayer.domain.external.MusicDownloadAPI;
import com.example.musicplayer.domain.model.Playlist;
import com.example.musicplayer.domain.player.IMusicPlayer;
import com.example.musicplayer.domain.player.LocalAudioPlayer;
import com.example.musicplayer.domain.theme.DefaultThemeStrategy;
import com.example.musicplayer.domain.theme.IThemeStrategy;
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
        return queryOrUrl -> {
            // TODO: Integrate remote song reference provider.
            return null;
        };
    }
}


