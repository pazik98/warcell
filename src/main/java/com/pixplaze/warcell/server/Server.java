package com.pixplaze.warcell.server;

import com.pixplaze.warcell.control.Commander;

public class Server implements Commander {

    private static Server instance;

    private Session session;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
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
}
