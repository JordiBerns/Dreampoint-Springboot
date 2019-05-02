package nl.yer.middlemen.dreampoint.character;

public class BigEnemy extends Enemy {

    private long id;

    public void getShotAt(int hpGone) {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2620";}
}
