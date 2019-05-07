package nl.yer.middlemen.dreampoint.game;

public abstract class PiecesOnPlayingField {

    private int canTakeAmountOfShots;
    private boolean canDamage;
    private boolean canContinueShooting;

    public abstract boolean determineIfCanShoot();

    public int getCanTakeAmountOfShots() {
        return canTakeAmountOfShots;
    }

    public void setCanTakeAmountOfShots(int canTakeAmountOfShots) {
        this.canTakeAmountOfShots = canTakeAmountOfShots;
    }

    public boolean isCanDamage() {
        return canDamage;
    }

    public void setCanDamage(boolean canDamage) {
        this.canDamage = canDamage;
    }

    public boolean isCanContinueShooting() {
        return canContinueShooting;
    }

    public void setCanContinueShooting(boolean canContinueShooting) {
        this.canContinueShooting = canContinueShooting;
    }
}
