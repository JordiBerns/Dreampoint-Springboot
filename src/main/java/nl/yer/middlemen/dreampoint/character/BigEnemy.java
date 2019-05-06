package nl.yer.middlemen.dreampoint.character;

public class BigEnemy extends Enemy {

    private long id;

    public BigEnemy() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(2);
        this.setAddToHiScore(20);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2620";}
}
