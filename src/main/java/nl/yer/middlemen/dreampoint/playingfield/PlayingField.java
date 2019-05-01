package nl.yer.dreampoint.playingfield;
import java.util.Scanner;

import static nl.yer.dreampoint.game.Game.highScore;

public class PlayingField {
    private long id;
    private int fieldWidth;
    private int fieldLength;
    private int playerYpos;
    private int playerXpos;

    private static int[][] map= {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,3,0,0,0,0,3,0},
            {0,3,0,0,0,5,0,0,0,0},
            {0,5,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,5,0,0},
            {0,0,5,0,0,0,0,0,0,0},
            {3,0,0,0,0,0,3,0,0,0},
            {0,0,0,1,0,0,0,5,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}};

    public PlayingField(){
        setStartPlayerPosition();
    }

    public void setStartPlayerPosition(){    //Finds the start position of the player
        int x = 0;
        int y = 0;

        loop:
        for(int[] row : map) {
            for (int element : row) {
                if (element == 1) {
                    this.playerXpos = x;
                    this.playerYpos = y;
                    break loop;
                }
                x++;
            }
            y++;
            x = 0;
        }
    }

    public void moving(){ //Needs to be in player?
        boolean walking = true;

        Scanner input = new Scanner(System.in);
        String move;

        //Displays the level so the player can see where he should move
        System.out.println();
        levelViewer();

        while(walking){

            do{
                move = input.nextLine();
            } while(move.length() == 0);

            System.out.println();

            System.out.println("You're score is: " + highScore);
            try {
                switch (move.charAt(0)) {
                    case 'w':
                        if (!hasCollision(playerYpos - 1, playerXpos)) {
                            map[playerYpos][playerXpos] = 0;
                            map[--playerYpos][playerXpos] = 1;
                        }
                        break;

                    case 's':
                        if (!hasCollision(playerYpos + 1, playerXpos)) {
                            map[playerYpos][playerXpos] = 0;
                            map[++playerYpos][playerXpos] = 1;
                        }
                        break;

                    case 'd':
                        if (!hasCollision(playerYpos, playerXpos + 1)) {
                            map[playerYpos][playerXpos] = 0;
                            map[playerYpos][++playerXpos] = 1;
                        }
                        break;

                    case 'a':
                        if (!hasCollision(playerYpos, playerXpos - 1)) {
                            map[playerYpos][playerXpos] = 0;
                            map[playerYpos][--playerXpos] = 1;
                        }
                        break;

                    case 'p':
                        System.out.println();
                        walking = false;
                        break;

                    default:
                        System.out.println("Wrong input. Please use wasd");
                        break;
                }
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Out of bounds error
                    System.out.println("Can't move here: Out of bounds!");
                }


            if(walking) levelViewer();
        }
    }

    public boolean hasCollision(int ypos, int xpos){ //Checks if there is anything on (ypos, xpos)
        if (map[ypos][xpos] != 0) {
            switch (map[ypos][xpos]){
                case 3:
                    System.out.println("Picked up an item!");
                    highScore += 10;
                    return false;

                case 5:
                    System.out.println("Can't move: Obstacle in the way!");
                    return true;

                default:
                    return false;
            }
        }

        else return false;
    }


    public void levelViewer(){ //Displays the level

        for(int[] row : map){
            for(int element: row){
                System.out.print(element + "  ");
            }
            System.out.println();
        }
    }



    public void playerSpawn(){}
    public void enemySpawn(){}
    public int getFieldWidth() {
        return fieldWidth;
    }
    public void setFieldWidth(int fieldWidth) {
        this.fieldWidth = fieldWidth;
    }
    public int getFieldLength() {
        return fieldLength;
    }
    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }
    public long getId() {
        return id;
    }
}

