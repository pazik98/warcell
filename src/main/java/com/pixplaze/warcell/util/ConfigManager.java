package com.pixplaze.warcell.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.pixplaze.warcell.server.GameSettings;
import com.pixplaze.warcell.server.ServerSettings;

import java.io.File;
import java.io.IOException;

/**
 * The class is responsible for storing, loading and saving config files.
 */
public class ConfigManager {

    private ServerSettings serverSettings;
    private GameSettings gameSettings;

    private ObjectMapper mapper;

    public ConfigManager() {
        setupMapper();
        setupConfigs();
    }

    public ServerSettings getServerSettings() {
        return serverSettings;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    private ServerSettings readServerSettings() throws IOException {
        File serverSettingsFile = new File(Path.ServerSettingsConfig.getUri());
        return mapper.readValue(serverSettingsFile, ServerSettings.class);
    }

    private void writeServerSettings() throws IOException {
        File serverSettingsFile = new File(Path.ServerSettingsConfig.getUri());
        mapper.writeValue(serverSettingsFile, serverSettings);
    }

    private ServerSettings createServerSettings() {
        return new ServerSettings();
    }

    private GameSettings readGameSettings() throws IOException {
        File gameSettingsFile = new File(Path.GameSettingsConfig.getUri());
        return mapper.readValue(gameSettingsFile, GameSettings.class);
    }

    private void writeGameSettings() throws IOException {
        File gameSettingsFile = new File(Path.GameSettingsConfig.getUri());
        mapper.writeValue(gameSettingsFile, gameSettings);
    }

    private GameSettings createGameSettings() {
        return new GameSettings();
    }

    private void setupMapper() {
        this.mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        this.mapper.findAndRegisterModules();

    }

    private void setupConfigs() {
        if (serverSettingsExists()) {
            try {
                this.serverSettings = readServerSettings();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        else {
            this.serverSettings = createServerSettings();
            try {
                writeServerSettings();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

        }

        if (gameSettingsExists()) {
            try {
                this.gameSettings = readGameSettings();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        else {
            this.gameSettings = createGameSettings();
            try {
                writeGameSettings();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    private void writeConfigs() {
        try {
            writeServerSettings();
            writeGameSettings();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private boolean serverSettingsExists() {
        File file = new File(Path.ServerSettingsConfig.getUri());
        return file.exists();
    }

    private boolean gameSettingsExists() {
        File file = new File(Path.GameSettingsConfig.getUri());
        return file.exists();
    }
}
