package nl.yer.middlemen.dreampoint.character;

public abstract class Enemy extends Character {

    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2620";}
}
