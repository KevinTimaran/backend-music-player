package com.example.musicplayer.domain.model;

public class UITheme {

    private final String primaryColor;
    private final String secondaryColor;
    private final String accentColor;
    private final String backgroundColor;

    public UITheme(String primaryColor, String secondaryColor, String accentColor, String backgroundColor) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.accentColor = accentColor;
        this.backgroundColor = backgroundColor;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}

