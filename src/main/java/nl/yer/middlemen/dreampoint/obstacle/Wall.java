package nl.yer.middlemen.dreampoint.obstacle;

public class Wall extends Obstacle {

    private long id;

    public Wall() {
        this.setCanDamage(false);
        this.setCanContinueShooting(false);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean determineIfCanShoot() {
        return false;
    }
}