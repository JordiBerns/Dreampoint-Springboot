package nl.yer.middlemen.dreampoint.obstacle;

public class Tree extends Obstacle {

    private long id;

    public Tree() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
        this.setCanContinueShooting(false);
    }

    @Override
    public boolean determineIfCanShoot() {
        if (this.isCanDamage()) {
            if (this.getCanTakeAmountOfShots() > 1) {
                this.setCanTakeAmountOfShots(this.getCanTakeAmountOfShots() - 1);
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\u2663";
    }
}