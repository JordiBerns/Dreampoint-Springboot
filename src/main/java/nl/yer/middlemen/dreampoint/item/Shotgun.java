package nl.yer.middlemen.dreampoint.item;

public class Shotgun extends Weapon {
    private long id;

    public Shotgun() {
        super();
        this.setCanBeDamaged(false);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("You've picked up an shotgun!");
    }

    @Override
    public boolean reactionToBeingShot() {
        return false;
    }

    @Override
    public void shoot() { }

    @Override
    public long getId() {
        return id;
    }

}
