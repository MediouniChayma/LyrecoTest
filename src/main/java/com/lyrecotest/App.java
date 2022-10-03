package com.lyrecotest;

import com.lyrecotest.Service.PlayerService;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    private static boolean notAWinner;
    public static void main( String[] args )
    {
        Game game=new Game();
        PlayerService playerService=new PlayerService();

        playerService.add("Chet");
        playerService.add("Pat");
        playerService.add("Sue");

        Random rand = new Random();
        do {
            game.roll(rand.nextInt(5) + 1);
            if (rand.nextInt(9) == 7) {
                notAWinner = game.wrongAnswer();
            } else {
                notAWinner = game.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }
}
