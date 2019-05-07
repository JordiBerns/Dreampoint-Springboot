package nl.yer.middlemen.dreampoint.playingfield;
import nl.yer.middlemen.dreampoint.character.BigEnemy;
import nl.yer.middlemen.dreampoint.character.Enemy;
import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.character.SmallEnemy;
import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;
import nl.yer.middlemen.dreampoint.item.Item;
import nl.yer.middlemen.dreampoint.obstacle.Obstacle;
import nl.yer.middlemen.dreampoint.obstacle.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class PlayingField {
    private long id;
    private int fieldWidth;
    private int fieldHeight;
    private Player player;
    private static PiecesOnPlayingField[][] map;
    private List<Enemy> enemies = new ArrayList<>();
    public PlayingField(){
    }

    public PiecesOnPlayingField[][] makeLevel() {
        this.fieldWidth = 10;
        this.fieldHeight = 10;
        map = new PiecesOnPlayingField[fieldHeight][fieldWidth];

        //Setting items, obstacles and random player position
        setObstacles(23, 55, 34, 77, 89);
        setItems(22, 13, 50, 90, 64);
        setEnemies(44, 69, 99);
        return map;
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

    public void setEnemies(int first, int... rest) {
        BigEnemy bigEnemy = new BigEnemy();
        int xPos = first % 10;
        int yPos = first / 10;
        bigEnemy.setxPos(xPos);
        bigEnemy.setyPos(yPos);
        map[yPos][xPos] = bigEnemy;
        enemies.add(bigEnemy);

        SmallEnemy smallEnemy;
        for (int pos : rest) {
            smallEnemy = new SmallEnemy();
            xPos = pos % 10;
            yPos = pos / 10;
            smallEnemy.setxPos(xPos);
            smallEnemy.setyPos(yPos);
            map[yPos][xPos] = smallEnemy;
            enemies.add(smallEnemy);
        }
    }


    /*
     * Checks if the index (of the arrays) won't go out of bounds, returns a boolean true if both indexes are inbound
     * Otherwise it will always return false.
     */
    public boolean checkBoundaries (int ypos, int xpos) {
        boolean possible = false;
        if ( (ypos < map.length) && (ypos >= 0) ) {
            if ( (xpos < map[0].length) && (xpos >= 0) ) possible = true;
        }
        return possible;
    }

    /*FOR FUTURE: instanceof is bad style, need different way of checking collision.
     * Maybe the object array map needs to be an 'Entity' array which is a parent class of all classes that can appear on the grid.
     * The Entity class could then have a field: boolean collision = false. Then the obstacle could hide this field
     * with boolean collision = true and the hasCollision function would simply be: return map[ypos][xpos].getCollision()
     */
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
        }
        else if (map[ypos][xpos] instanceof SmallEnemy) {
            System.out.println("Can't move through enemies!");
            return true;
        } else return false;
    }

    /*
     * Check to see what Object is on the field. Every Object has an interaction and returns true if it can shoot the
     * Object. If it can't shoot the Object, it will return false.
     */
    public boolean canShoot(int ypos, int xpos) {
        boolean possible;
        PiecesOnPlayingField pieceOnField;

        if (map[ypos][xpos] != null) {
            pieceOnField = map[ypos][xpos];
            possible = pieceOnField.determineIfCanShoot();
        }
        else {
            possible = true;
        }
        return possible;
    }


    /*
     * Displays the level.
     */
    public void levelViewer(){

        for(PiecesOnPlayingField[] row : map){
            for(PiecesOnPlayingField element: row){
                if (element ==null) System.out.print("\u25A1\t");
                else System.out.print(element+ "\t");
            }
            System.out.println();
        }
    }

    public void moveEnemies(){
        for (Enemy e : enemies){
            e.move();
        }
    }
    public static void setObjectOnMap(int yPos, int xPos, PiecesOnPlayingField piece){
        map[yPos][xPos] = piece;
    }

    public static void setNullOnMap(int yPos, int xPos){
        map[yPos][xPos] = null;
    }
    public static PiecesOnPlayingField checkObjectOnMap(int yPos, int xPos){
        return map[yPos][xPos];
    }

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