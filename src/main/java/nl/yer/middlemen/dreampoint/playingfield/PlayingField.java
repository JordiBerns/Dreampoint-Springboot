package nl.yer.middlemen.dreampoint.playingfield;
import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.item.Item;
import nl.yer.middlemen.dreampoint.obstacle.Obstacle;
import nl.yer.middlemen.dreampoint.obstacle.Tree;

import java.util.Scanner;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class PlayingField {
    private long id;
    private int fieldWidth;
    private int fieldHeight;
    private Player player;
    private int playerYpos;
    private int playerXpos;

    private static Object[][] map ;

    public PlayingField(){
        this.fieldWidth = 10;
        this.fieldHeight = 10;
        map = new Object[fieldHeight][fieldWidth];

        //Setting items, obstacles and random player position
        setObstacles(23, 55, 34, 77, 89);
        setItems(22, 13, 50, 90, 64);
        setRandomStartPlayerPosition();
    }

    public void setObstacles(int first, int... rest) {
        Obstacle tree = new Tree();
        int xPos = first % 10;
        int yPos = first / 10;
        map[yPos][xPos] = tree;

        for (int pos : rest) {
            xPos = pos % 10;
            yPos = pos / 10;
            map[yPos][xPos] = tree;
        }
    }

    public void setItems(int first, int... rest){
        Item item = new Item();
        int xPos = first % 10;
        int yPos = first / 10;
        map[yPos][xPos] = item;

        for(int pos : rest){
            xPos = pos % 10;
            yPos = pos / 10;
            map[yPos][xPos] = item;
        }
    }

    /** FOR FUTURE: Player created in function below needs to be coupled to player created in Game class.*/
    public void setRandomStartPlayerPosition(){    //Sets random start position of player
        this.player = new Player();
        int pos;
        int xPos;
        int yPos;
        do {    //do while loop ensures player isn't placed on an Obstacle or Item.
            pos = (int) (Math.random() * 100);  //Random position between 0 and 99
            xPos = pos % 10;
            yPos = pos / 10;
        } while(map[yPos][xPos] != null);

        map[yPos][xPos] = this.player;
        this.playerXpos = xPos;
        this.playerYpos = yPos;
    }

    public void moving(){ //Needs to be in player or in game?
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
            System.out.println("Your score is: " + hiScore);

            try {
                switch (move.charAt(0)) {
                    case 'w':
                        if (!hasCollision(playerYpos - 1, playerXpos)) {
                            map[playerYpos][playerXpos] = null;
                            map[--playerYpos][playerXpos] = this.player;
                        }
                        break;

                    case 's':
                        if (!hasCollision(playerYpos + 1, playerXpos)) {
                            map[playerYpos][playerXpos] = null;
                            map[++playerYpos][playerXpos] = this.player;
                        }
                        break;

                    case 'd':
                        if (!hasCollision(playerYpos, playerXpos + 1)) {
                            map[playerYpos][playerXpos] = null;
                            map[playerYpos][++playerXpos] = this.player;
                        }
                        break;

                    case 'a':
                        if (!hasCollision(playerYpos, playerXpos - 1)) {
                            map[playerYpos][playerXpos] = null;
                            map[playerYpos][--playerXpos] = this.player;
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

    /**FOR FUTURE: instanceof is bad style, need different way of checking collision.
     * Maybe the object array map needs to be an 'Entity' array which is a parent class of all classes that can appear on the grid.
     * The Entity class could then have a field: boolean collision = false. Then the obstacle could hide this field
     * with boolean collision = true and the hasCollision function would simply be: return map[ypos][xpos].getCollision()*/
    public boolean hasCollision(int ypos, int xpos) { //Checks if there is anything on (ypos, xpos)
        if (map[ypos][xpos] == null) return false;
        else if (map[ypos][xpos] instanceof Obstacle) {
            System.out.println("Can't move through obstacle!");
            return true;
        }
        else if (map[ypos][xpos] instanceof Item) {
            hiScore += 10;
            System.out.println("Picked up an item!");
            return false;
        } else return false;
    }

    public void levelViewer(){ //Displays the level

        for(Object[] row : map){
            for(Object element: row){
                if (element ==null) System.out.print("\u25A1 \t");
                else System.out.print(element+ "\t");
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
    public int getFieldHeight() {
        return fieldHeight;
    }
    public void setFieldHeight(int fieldHeight) {
        this.fieldHeight = fieldHeight;
    }
    public long getId() {
        return id;
    }
}