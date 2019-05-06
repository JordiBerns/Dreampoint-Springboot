package nl.yer.middlemen.dreampoint.item;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class Item extends PiecesOnPlayingField {
    private long id;

    public Item () {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\uFF0B";
    }


}
