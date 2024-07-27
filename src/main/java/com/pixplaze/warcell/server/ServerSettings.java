package com.pixplaze.warcell.server;

public class ServerSettings {

    private String savePath;

    public ServerSettings() {
        savePath = "src\\main\\resources\\save";
    }

    public String getSavePath() {
        return savePath;
    }
}
