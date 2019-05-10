package nl.yer.middlemen.dreampoint.obstacle;

public class Tree extends Obstacle {

    private long id;

    public Tree() {
        super();
        this.setCanBeDamaged(true);
        this.setCanTakeAmountOfShots(1);
        this.setCanContinueShootingAfterBeenShot(false);
    }

    @Override
    public boolean reactionToBeingShot() {
        if (this.isCanBeDamaged()) {
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
    public String toString() {
        return "\u2663";
    }

    @Override
    public long getId() {
        return id;
    }

}