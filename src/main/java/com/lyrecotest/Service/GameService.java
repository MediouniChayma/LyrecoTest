package com.lyrecotest.Service;
import com.lyrecotest.Model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Logger logger = LoggerFactory.getLogger(GameService.class);
    public static List<Player> players = new ArrayList<>();
    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;
    private QuestionService questionService;
    private PlayerService playerService;

    public GameService(){
        questionService = new QuestionService();
        playerService = new PlayerService();
    }

    public void movePlayer(int roll, Player player) {
        player.setPlace(player.getPlace()+ roll);
        if (player.getPlace() > 11)
            player.setPlace(player.getPlace() - 12);
        logger.info("{} 's new location is {}",player.getPlayerName(),player.getPlace());
        logger.info("The category is {}" , questionService.currentCategory(currentPlayer));
        questionService.askQuestion(currentPlayer);
    }
    public void roll(int roll) {
        Player player=playerService.getCurrentPlayer(currentPlayer);
        logger.info(player + " is the current player");
        logger.info("They have rolled a {}" ,roll);
        if (player.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                logger.info("{} is getting out of the penalty box",player.getPlayerName());
                movePlayer(roll, player);
            } else {
                logger.info("{} is not getting out of the penalty box",player.getPlayerName());
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            movePlayer(roll, player);
        }

    }

    public void playerAnswer(Player player, boolean winner){
        logger.info("Answer was correct!!!!");
        player.setPurses(player.getPurses() + 1);
        logger.info("{} now has {} Gold Coins", player.getPlayerName(), player.getPurses());
        winner = playerService.didPlayerWin(currentPlayer);
    }
    public boolean wasCorrectlyAnswered() {
        Player player = playerService.getCurrentPlayer(currentPlayer);
        boolean winner = true;
        if(player.isInPenaltyBox()){
            if(isGettingOutOfPenaltyBox) {
                logger.info("Answer was correct!!!!");
                player.setPurses(player.getPurses() + 1);
                logger.info("{} now has {} Gold Coins", player.getPlayerName(), player.getPurses());
                winner = playerService.didPlayerWin(currentPlayer);
            }
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return winner;
        }else {
            logger.info("Answer was correct!!!!");
            player.setPurses(player.getPurses() + 1);
            logger.info("{} now has {} Gold Coins", player.getPlayerName(), player.getPurses());
            winner = playerService.didPlayerWin(currentPlayer);
        }
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;
            return winner;
    }


    public boolean wrongAnswer(){
        logger.info("Question was incorrectly answered");
        logger.info(players.get(currentPlayer)+ " was sent to the penalty box {}");
        playerService.getCurrentPlayer(currentPlayer).setInPenaltyBox(true);
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

}
