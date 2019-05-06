package nl.yer.middlemen.dreampoint.item;

public class Shotgun extends Weapon {
    private long id;

    public Shotgun() {
        this.setCanDamage(false);
    }

    @Override
    public void shoot() { }

    @Override
    public boolean determineIfCanShoot() {
        return false;
    }

    @Override
    public long getId() {
        return id;
    }
}
