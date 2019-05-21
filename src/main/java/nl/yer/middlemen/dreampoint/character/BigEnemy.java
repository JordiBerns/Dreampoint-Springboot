package nl.yer.middlemen.dreampoint.character;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class BigEnemy extends Enemy {

    private long id;

    public BigEnemy() {
        super();
        this.setCanBeDamaged(true);
        this.setCanTakeAmountOfShots(2);
        this.setAddToHiScore(20);
        this.setCanContinueShootingAfterBeenShot(true);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("A collision with the BigEnemy happened!");
    }

    @Override
    public boolean reactionToBeingShot() {
        if (this.isCanBeDamaged()) {
            if (this.getCanTakeAmountOfShots() > 1) {
                this.setCanTakeAmountOfShots(this.getCanTakeAmountOfShots() - 1);
                return false;
            } else {
                hiScore += this.getAddToHiScore();
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {return "\u2620";}

    @Override
    public void move(){}

    @Override
    public long getId() {
        return id;
    }

}
