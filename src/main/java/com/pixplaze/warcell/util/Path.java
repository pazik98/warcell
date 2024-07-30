package com.pixplaze.warcell.util;

public enum Path {
    ServerSettingsConfig("src\\main\\resources\\config\\ServerSettings.yml"),
    GameSettingsConfig("src\\main\\resources\\config\\GameSettings.yml"),
    SaveDirectory("src\\main\\resources\\save");

    private final String uri;

    Path(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
