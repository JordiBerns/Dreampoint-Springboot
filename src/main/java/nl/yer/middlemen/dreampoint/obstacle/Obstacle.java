package nl.yer.middlemen.dreampoint.obstacle;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Obstacle extends PiecesOnPlayingField {

    private int xPosition;
    private int yPosition;
    private long id;

    @Override
    public abstract boolean determineIfCanShoot();

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
    
    public long getId() {
        return id;
    }
}