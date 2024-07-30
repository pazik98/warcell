package com.pixplaze.warcell.server;

import com.pixplaze.warcell.util.Path;

public class ServerSettings {

    private String savePath;

    public ServerSettings() {
        savePath = Path.SaveDirectory.getUri();
    }

    public String getSavePath() {
        return savePath;
    }
}
