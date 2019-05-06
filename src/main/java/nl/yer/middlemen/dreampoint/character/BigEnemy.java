package nl.yer.middlemen.dreampoint.character;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class BigEnemy extends Enemy {

    private long id;

    public BigEnemy() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(2);
        this.setAddToHiScore(20);
    }

    @Override
    public boolean determineIfCanShoot() {
        if (this.isCanDamage()) {
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
    public long getId() {
        return id;
    }

    @Override
    public String toString() {return "\u2620";}
}
