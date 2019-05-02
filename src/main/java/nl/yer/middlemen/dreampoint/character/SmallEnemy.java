package nl.yer.middlemen.dreampoint.character;

public class SmallEnemy extends Enemy {

    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2622";}
}
