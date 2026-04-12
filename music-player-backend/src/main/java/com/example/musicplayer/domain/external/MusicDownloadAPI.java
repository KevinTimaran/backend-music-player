package com.example.musicplayer.domain.external;


public interface MusicDownloadAPI {

    SongReference requestSongReference(String queryOrUrl);
}

