package com.example.musicplayer.controller;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.musicplayer.MusicPlayerApplication;
import com.example.musicplayer.domain.model.Song;
import com.example.musicplayer.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = MusicPlayerApplication.class)
@AutoConfigureMockMvc
class PlayerControllerSmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    void resetPlaylist() {
        for (Song song : playerService.getPlaylistSongs()) {
            playerService.deleteSongById(song.getId());
        }
    }

    @Test
    void contextLoadsWithControllerAndService() {
        org.junit.jupiter.api.Assertions.assertNotNull(mockMvc);
        org.junit.jupiter.api.Assertions.assertNotNull(playerService);
    }

    @Test
    void getStatusReturnsOkAndNonEmptyBody() throws Exception {
        mockMvc.perform(get("/api/player/status"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(blankOrNullString())));
    }

    @Test
    void getHealthReturnsOk() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Music Player backend is running"));
    }

    @Test
    void playerEndpointsRespondForTheMinimumApiFlow() throws Exception {
        String startSongJson = """
                {
                  "id": "song-1",
                  "title": "Demo Song",
                  "duration": 180,
                  "artist": "Demo Artist",
                  "sourceUrl": "https://example.com/demo-song.mp3",
                  "coverUrl": "https://example.com/demo-song.jpg",
                  "genre": "Pop"
                }
                """;

        String endSongJson = """
                {
                  "id": "song-2",
                  "title": "Second Song",
                  "duration": 200,
                  "artist": "Another Artist",
                  "sourceUrl": "https://example.com/second-song.mp3",
                  "coverUrl": "https://example.com/second-song.jpg",
                  "genre": "Rock"
                }
                """;

        mockMvc.perform(get("/api/player/status"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(blankOrNullString())));

        mockMvc.perform(post("/api/player/songs/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(startSongJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Song added to start"));

        mockMvc.perform(get("/api/player/songs"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Demo Song")));

        mockMvc.perform(get("/api/player/current"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Demo Song")));

        mockMvc.perform(post("/api/player/play"))
                .andExpect(status().isOk())
                .andExpect(content().string("Playback started"));

        mockMvc.perform(get("/api/player/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("PLAYING"));

        mockMvc.perform(post("/api/player/songs/end")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(endSongJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Song added to end"));

        mockMvc.perform(get("/api/player/songs"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Demo Song")))
                .andExpect(content().string(containsString("Second Song")));
    }
}

