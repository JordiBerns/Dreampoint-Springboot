package nl.yer.middlemen.dreampoint.character;

public class SmallEnemy extends Enemy {

    private long id;

    public SmallEnemy() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
        this.setAddToHiScore(10);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2622";}
}
