package nl.yer.middlemen.dreampoint.item;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class Medkit extends Item {
    private long id;
    private int hp;

    public Medkit() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
        this.setCanContinueShooting(true);
    }

    public int increaseHp(){
        return 0;
    }

    @Override
    public boolean determineIfCanShoot() {
        if (this.isCanDamage()) {
            if (this.getCanTakeAmountOfShots() > 1) {
                this.setCanTakeAmountOfShots(this.getCanTakeAmountOfShots() - 1);
                return false;
            } else {
                hiScore -= 10;
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\uFF0B";
    }

    @Override
    public long getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}