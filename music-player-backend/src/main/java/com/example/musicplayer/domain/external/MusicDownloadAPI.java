package com.example.musicplayer.domain.external;

import com.example.musicplayer.domain.model.SongReference;

public interface MusicDownloadAPI {

    SongReference requestSongReference(String queryOrUrl);
}

