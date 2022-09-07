package com.pixplaze.warcell.server;

import com.pixplaze.warcell.control.Player;
import com.pixplaze.warcell.world.Simulation;

import java.util.List;

public class Session {

    private Simulation simulation;
    private List<Player> players;

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
