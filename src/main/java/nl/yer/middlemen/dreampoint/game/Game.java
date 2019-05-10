package nl.yer.middlemen.dreampoint.game;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.playingfield.PlayingField;

import java.util.Scanner;

public class Game {
    private long id;
    private Player player;
    private PlayingField playingField = new PlayingField();
    public static int hiScore;

    // method to create player and start method to let user give information
    // after that de playingField wil start with the method to show the playingField and activates moving.
    public void runGame() {
        boolean runningGame = true;
        this.player = new Player();
        //this.player.createNewPlayer();
        playingField.createNewPlayingField();
        player.setRandomStartPositionPlayer();

        while(runningGame) {
            playingField.printPlayingField();
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
            playingField.moveEnemies();
        }
    }

    public long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayingField getPlayingField() {
        return playingField;
    }

    public void setPlayingField(PlayingField playingField) {
        this.playingField = playingField;
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
