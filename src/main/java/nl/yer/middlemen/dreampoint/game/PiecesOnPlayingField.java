package nl.yer.middlemen.dreampoint.game;

public abstract class PiecesOnPlayingField {

    private int canTakeAmountOfShots;
    private boolean canBeDamaged;
    private boolean canContinueShootingAfterBeenShot;
    private boolean canCollideWithOtherPiece;

    public abstract boolean reactionToBeingShot();

    public abstract void reactionToCollision();

    public int getCanTakeAmountOfShots() {
        return canTakeAmountOfShots;
    }

    public void setCanTakeAmountOfShots(int canTakeAmountOfShots) {
        this.canTakeAmountOfShots = canTakeAmountOfShots;
    }

    public boolean isCanBeDamaged() {
        return canBeDamaged;
    }

    public void setCanBeDamaged(boolean canBeDamaged) {
        this.canBeDamaged = canBeDamaged;
    }

    public boolean isCanContinueShootingAfterBeenShot() {
        return canContinueShootingAfterBeenShot;
    }

    public void setCanContinueShootingAfterBeenShot(boolean canContinueShootingAfterBeenShot) {
        this.canContinueShootingAfterBeenShot = canContinueShootingAfterBeenShot;
    }

    public boolean isCanCollideWithOtherPiece() {
        return canCollideWithOtherPiece;
    }

    public void setCanCollideWithOtherPiece(boolean canCollideWithOtherPiece) {
        this.canCollideWithOtherPiece = canCollideWithOtherPiece;
    }

}
