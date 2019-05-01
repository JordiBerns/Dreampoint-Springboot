package nl.yer.dreampoint.game;

import nl.yer.dreampoint.character.Player;
import nl.yer.dreampoint.playingfield.PlayingField;

public class Game {
    private long id;
    private Player player;
    private PlayingField level = new PlayingField();
    public static int highScore;

    // method to create player, which automatically starts the creation of the player (because of the constructor)
    // after that de playingField wil start with the method to show the level and activates moving.
    public void runGame() {
        player = new Player();
        level.moving();
    }

    public long getId() {
        return id;
    }

    /*
    private boolean gameOver;

    public void gameOver(){
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    } */
}
