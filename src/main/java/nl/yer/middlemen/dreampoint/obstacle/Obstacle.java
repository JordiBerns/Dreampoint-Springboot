package nl.yer.middlemen.dreampoint.obstacle;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Obstacle extends PiecesOnPlayingField {

    private long id;
    private int xPosition;
    private int yPosition;

    public Obstacle() {
        this.setCanCollideWithOtherPiece(false);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("You can't move through an obstacle!");
    }

    @Override
    public abstract boolean reactionToBeingShot();

    public long getId() {
        return id;
    }

    public int getXPosition() {
        return xPosition;
    }
    
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    
    public int getYPosition() {
        return yPosition;
    }
    
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

}