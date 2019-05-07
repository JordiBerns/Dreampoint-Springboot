package nl.yer.middlemen.dreampoint.game;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.playingfield.PlayingField;

import java.util.Scanner;

public class Game {
    private long id;
    private Player player;
    private PlayingField level = new PlayingField();
    public static int hiScore;

    // method to create player and start method to let user give information
    // after that de playingField wil start with the method to show the level and activates moving.
    public void runGame() {
        boolean runningGame = true;
        this.player = new Player();
        //this.player.initializePlayer();
        level.makeLevel();
        player.setRandomStartPlayerPosition();

        while(runningGame) {
            level.levelViewer();
            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine().toLowerCase();
            if(input.length() <=0) {
                System.out.println("Enter key is not valid, please enter 'w', 'a', 's', 'd' // 'i', 'j', 'k', 'l' // 'p'");
            } else if (input.charAt(0) == 'w' || input.charAt(0) == 'a' || input.charAt(0) == 's' || input.charAt(0) == 'd') {
                player.move(input);
            } else if (input.charAt(0) == 'i' || input.charAt(0) == 'j' || input.charAt(0) == 'k' || input.charAt(0) == 'l') {
                player.shoot(input);
            } else if (input.charAt(0) == 'p') {
                runningGame = false;
            } else {
                System.out.println("Something went wrong, please enter 'w', 'a', 's', 'd' // 'i', 'j', 'k', 'l' // 'p'");
            }
            level.moveEnemies();
        }
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
