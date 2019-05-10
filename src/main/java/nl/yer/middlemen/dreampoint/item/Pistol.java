package nl.yer.middlemen.dreampoint.item;

public class Pistol extends Weapon {
    private long id;

    public Pistol() {
        super();
        this.setCanBeDamaged(false);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("You've picked up an pistol!");
    }

    @Override
    public boolean reactionToBeingShot() {
        return false;
    }

    @Override
    public void shoot(){}

    @Override
    public long getId() {
        return id;
    }
}