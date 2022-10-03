package com.lyrecotest.Model;

public class Player {
    private String playerName;
    private int place;
    private int purses;
    private boolean inPenaltyBox;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public Player(String playerName, int place, int purses, boolean inPenaltyBox) {
        this.playerName = playerName;
        this.place = place;
        this.purses = purses;
        this.inPenaltyBox = inPenaltyBox;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", place=" + place +
                ", purses=" + purses +
                ", inPenaltyBox=" + inPenaltyBox +
                '}';
    }
}
