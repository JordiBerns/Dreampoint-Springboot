package nl.yer.middlemen.dreampoint.character;

public abstract class Enemy extends Character {

    private long id;
    private int addToHiScore;
    private int xPos;
    private int yPos;

    public Enemy() {
        super();
    }

    public abstract void move();

    @Override
    public abstract boolean reactionToBeingShot();

    @Override
    public long getId() {
        return id;
    }

    public int getAddToHiScore() {
        return addToHiScore;
    }

    public void setAddToHiScore(int addToHiScore) {
        this.addToHiScore = addToHiScore;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

}
