package com.example.musicplayer.controller;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.musicplayer.MusicPlayerApplication;
import com.example.musicplayer.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = MusicPlayerApplication.class)
@AutoConfigureMockMvc
class PlayerControllerSmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

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
}

