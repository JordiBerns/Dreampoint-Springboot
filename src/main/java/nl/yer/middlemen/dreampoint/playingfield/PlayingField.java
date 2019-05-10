package nl.yer.middlemen.dreampoint.playingfield;
import nl.yer.middlemen.dreampoint.character.BigEnemy;
import nl.yer.middlemen.dreampoint.character.Enemy;
import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.character.SmallEnemy;
import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;
import nl.yer.middlemen.dreampoint.item.Medkit;
import nl.yer.middlemen.dreampoint.obstacle.Tree;
import java.util.ArrayList;
import java.util.List;

public class PlayingField {
    private long id;
    private int fieldWidth;
    private int fieldHeight;
    private Player player;
    private static PiecesOnPlayingField[][] level;
    private List<Enemy> enemiesOnPlayingField = new ArrayList<>();

    public PiecesOnPlayingField[][] createNewPlayingField() {
        this.fieldWidth = 10;
        this.fieldHeight = 10;
        level = new PiecesOnPlayingField[fieldHeight][fieldWidth];

        //Setting items, obstacles and random player position
        putTreesOnPlayingField(23, 55, 34, 77, 89);
        putMedKitsOnPlayingField(22, 13, 50, 90, 64);
        putEnemiesOnPlayingField(44, 69, 99);
        return level;
    }

    public void putTreesOnPlayingField(int first, int... rest) {
        Tree tree = new Tree();
        int xPos = first % 10;
        int yPos = first / 10;
        level[yPos][xPos] = tree;

        for (int pos : rest) {
            xPos = pos % 10;
            yPos = pos / 10;
            level[yPos][xPos] = tree;
        }
    }

    public void putMedKitsOnPlayingField(int first, int... rest){
        Medkit medkit = new Medkit();
        int xPos = first % 10;
        int yPos = first / 10;
        level[yPos][xPos] = medkit;

        for(int pos : rest){
            xPos = pos % 10;
            yPos = pos / 10;
            level[yPos][xPos] = medkit;
        }
    }

    public void putEnemiesOnPlayingField(int first, int... rest) {
        BigEnemy bigEnemy = new BigEnemy();
        int xPos = first % 10;
        int yPos = first / 10;
        bigEnemy.setxPos(xPos);
        bigEnemy.setyPos(yPos);
        level[yPos][xPos] = bigEnemy;
        enemiesOnPlayingField.add(bigEnemy);

        SmallEnemy smallEnemy;
        for (int pos : rest) {
            smallEnemy = new SmallEnemy();
            xPos = pos % 10;
            yPos = pos / 10;
            smallEnemy.setxPos(xPos);
            smallEnemy.setyPos(yPos);
            level[yPos][xPos] = smallEnemy;
            enemiesOnPlayingField.add(smallEnemy);
        }
    }

    /*
     * Checks if the index (of the arrays) won't go out of bounds, returns a boolean true if both indexes are inbound
     * Otherwise it will always return false.
     */
    public boolean notMovingOutOfBounds(int ypos, int xpos) {
        boolean possible = false;
        if ((ypos < level.length) && (ypos >= 0)) {
            if ((xpos < level[0].length) && (xpos >= 0)) {
                possible = true;
            }
        }
        return possible;
    }

    /*FOR FUTURE: instanceof is bad style, need different way of checking collision.
     * Maybe the object array level needs to be an 'Entity' array which is a parent class of all classes that can appear on the grid.
     * The Entity class could then have a field: boolean collision = false. Then the obstacle could hide this field
     * with boolean collision = true and the canHaveCollisionWithOtherPiece function would simply be: return level[ypos][xpos].getCollision()
     */
    public boolean canHaveCollisionWithOtherPiece(int ypos, int xpos) { //Checks if there is anything on (ypos, xpos)
        PiecesOnPlayingField pieceOnField = level[ypos][xpos];

        if (pieceOnField == null) return true;
        else if (pieceOnField.isCanCollideWithOtherPiece()) {
            pieceOnField.reactionToCollision();
            return true;
        }
        else {
            pieceOnField.reactionToCollision();
            return false;
        }
    }

    /*
     * Check to see what Object is on the field. Every Object has an interaction and returns true if it can shoot the
     * Object. If it can't shoot the Object, it will return false.
     */
    public boolean canPieceBeShotAt(int ypos, int xpos) {
        boolean possible = true;
        PiecesOnPlayingField pieceOnField;

        if (level[ypos][xpos] != null) {
            pieceOnField = level[ypos][xpos];
            if (level[ypos][xpos].isCanContinueShootingAfterBeenShot()) {
                possible = pieceOnField.reactionToBeingShot();
            } else if ((!level[ypos][xpos].isCanContinueShootingAfterBeenShot()) && (level[ypos][xpos].isCanBeDamaged())) {
                putNullOnPlayingField(ypos, xpos);
                possible = false;
            }
        }
        return possible;
    }

    /*
     * Displays the level.
     */
    public void printPlayingField(){

        for(PiecesOnPlayingField[] row : level){
            for(PiecesOnPlayingField element: row){
                if (element ==null) System.out.print("\u25A1\t");
                else System.out.print(element+ "\t");
            }
            System.out.println();
        }
    }

    public void moveEnemies(){
        for (Enemy e : enemiesOnPlayingField){
            e.move();
        }
    }
    public static void putObjectOnPlayingField(int yPos, int xPos, PiecesOnPlayingField piece){
        level[yPos][xPos] = piece;
    }

    public static void putNullOnPlayingField(int yPos, int xPos){
        level[yPos][xPos] = null;
    }

    public static PiecesOnPlayingField checkObjectOnPlayingField(int yPos, int xPos){
        return level[yPos][xPos];
    }

    public long getId() {
        return id;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemiesOnPlayingField() {
        return enemiesOnPlayingField;
    }

    public void setEnemiesOnPlayingField(List<Enemy> enemiesOnPlayingField) {
        this.enemiesOnPlayingField = enemiesOnPlayingField;
    }



}