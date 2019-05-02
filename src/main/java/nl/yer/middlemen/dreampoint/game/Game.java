package nl.yer.middlemen.dreampoint.game;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.playingfield.PlayingField;

public class Game {
    private long id;
    private Player player;
    private PlayingField level = new PlayingField();
    public static int hiScore;

    // method to create player, which automatically starts the creation of the player (because of the constructor)
    // after that de playingField wil start with the method to show the level and activates moving.
    public void runGame() {
        player = new Player();
        level.moving();
    }

    public long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
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
