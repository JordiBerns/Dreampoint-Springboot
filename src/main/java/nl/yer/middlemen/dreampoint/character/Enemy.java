package nl.yer.middlemen.dreampoint.character;

public abstract class Enemy extends Character {

    private long id;
    private int hp = 100;

    @Override
    public long getId() {
        return id;
    }

    public int getHp() {return hp;}

    public void setHp(int hp) {this.hp = hp;}

}
