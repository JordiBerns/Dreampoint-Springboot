package nl.yer.middlemen.dreampoint.game;

public abstract class PiecesOnPlayingField {

    private int canTakeAmountOfShots;
    private boolean canDamage;

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
}
