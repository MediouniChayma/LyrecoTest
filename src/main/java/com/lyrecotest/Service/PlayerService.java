package com.lyrecotest.Service;

import com.lyrecotest.Model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerService {
    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    public boolean add(String playerName) {
        GameService.players.add(new Player(playerName, 0,0 , false));
        logger.info("{} was added", playerName);
        logger.info("They are player number {}", GameService.players.size());
        return true;
    }
    public int howManyPlayers() {
        return GameService.players.size();
    }
    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }
    public Player getCurrentPlayer(int currentPlayer){
        return GameService.players.get(currentPlayer);
    }
    public boolean didPlayerWin(int currentPlayer) {
        Player player = getCurrentPlayer(currentPlayer);
        return player.getPurses() != 6;
    }
}
