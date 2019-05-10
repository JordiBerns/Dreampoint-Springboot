package nl.yer.middlemen.dreampoint.item;

public class RocketLauncher extends Weapon {
    private long id;

    public RocketLauncher() {
        super();
        this.setCanBeDamaged(false);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("You've picked up an rocketlauncher!");
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
