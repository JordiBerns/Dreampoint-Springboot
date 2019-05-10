package nl.yer.middlemen.dreampoint.item;

public abstract class Weapon extends Item {
    private long id;
    private int magSize;

    public Weapon() {
        super();
    }

    public abstract void shoot();

    @Override
    public abstract boolean reactionToBeingShot();

    @Override
    public long getId() {
        return id;
    }

    public int getMagSize() {
        return magSize;
    }

    public void setMagSize(int magSize) {
        this.magSize = magSize;
    }

}
