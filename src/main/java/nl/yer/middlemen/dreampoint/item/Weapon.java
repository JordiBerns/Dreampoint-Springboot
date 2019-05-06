package nl.yer.middlemen.dreampoint.item;

public abstract class Weapon extends Item {
    private long id;
    private int magSize;

    public abstract void shoot();

    @Override
    public abstract boolean determineIfCanShoot();

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
