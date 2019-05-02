package nl.yer.middlemen.dreampoint.obstacle;

public abstract class Obstacle {

    private int xPosition;
    private int yPosition;
    private long id;
    
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

    @Override
    public String toString() {
        return "\u274C";
    }

}
