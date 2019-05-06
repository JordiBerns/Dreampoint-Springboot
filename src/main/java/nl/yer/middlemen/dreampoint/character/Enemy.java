package nl.yer.middlemen.dreampoint.character;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public abstract class Enemy extends Character {

    private long id;
    private int addToHiScore;

    @Override
    public boolean determineIfCanShoot() {
        if (this.isCanDamage()) {
            if (this.getCanTakeAmountOfShots() > 1) {
                this.setCanTakeAmountOfShots(this.getCanTakeAmountOfShots() - 1);
                return false;
            } else {
                hiScore += this.addToHiScore;
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

    public int getAddToHiScore() {
        return addToHiScore;
    }

    public void setAddToHiScore(int addToHiScore) {
        this.addToHiScore = addToHiScore;
    }

}
