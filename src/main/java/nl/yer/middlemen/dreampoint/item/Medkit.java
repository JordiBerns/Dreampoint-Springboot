package nl.yer.middlemen.dreampoint.item;

public class Medkit extends Item {
    private long id;
    private int hp;

    public int increaseHp(){
        return 0;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
