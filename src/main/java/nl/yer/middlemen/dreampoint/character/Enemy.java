package nl.yer.middlemen.dreampoint.character;

public abstract class Enemy extends Character {

    private long id;
    private int addToHiScore;

    @Override
    public abstract boolean determineIfCanShoot();

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

}
