package nl.yer.middlemen.dreampoint.obstacle;

public class Wall extends Obstacle {

    private long id;

    public Wall() {
        super();
        this.setCanBeDamaged(false);
        this.setCanContinueShootingAfterBeenShot(false);
    }

    @Override
    public boolean reactionToBeingShot() {
        return false;
    }

    @Override
    public long getId() {
        return id;
    }


}