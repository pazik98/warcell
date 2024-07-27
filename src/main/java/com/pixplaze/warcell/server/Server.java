package com.pixplaze.warcell.server;

import com.pixplaze.warcell.control.Commander;

import java.util.Random;

public class Server implements Commander {

    private static Server instance;
    private Session session;
    private final ServerSettings serverSettings;

    private Random random;

    public Server(ServerSettings serverSettings) {
        this.serverSettings = serverSettings;
        this.random = new Random(10101);
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server(new ServerSettings());
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String getName() {
        return "Server";
    }

    public Random getRandom() {
        return random;
    }
}
