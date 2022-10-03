package com.lyrecotest;

import com.lyrecotest.Model.Player;
import com.lyrecotest.Service.PlayerService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private final Logger logger = LoggerFactory.getLogger(PlayerTest.class);
    PlayerService playerService=new PlayerService();
    @Test
    public void addPlayers(){
        assertTrue(playerService.add("Chayma"));
        assertTrue(playerService.add("Safia"));
    }
    @Test
    public void numbersPlayers(){
        int expectedInt =2;
        playerService.add("Chayma");
        playerService.add("Safia");
        assertEquals(playerService.howManyPlayers(),expectedInt);
    }
    @Test
    public void CurrentPlayer(){
        playerService.add("Chayma");
        playerService.add("Safia");
        Player player = new Player("Safia", 0,0 , false);
        assertEquals(player.getPlayerName(),playerService.getCurrentPlayer(1).getPlayerName());
    }

    @Test
    public void winPlayer(){
        playerService.add("Chayma");
        playerService.add("Safia");
        playerService.didPlayerWin(1);
        assertTrue(playerService.didPlayerWin(1));
    }
}
