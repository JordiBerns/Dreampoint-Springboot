package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.playingfield.PlayingField;
import static nl.yer.middlemen.dreampoint.game.Game.hiScore;


public class SmallEnemy extends Enemy {

    private long id;
    private int direction;

    public SmallEnemy() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
        this.setAddToHiScore(10);
        this.direction = 0;
        this.setCanContinueShooting(true);
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
    public String toString() {return "\u2622";}

    @Override
    public void move() {
        PlayingField p = new PlayingField();
            switch (direction%4){
                case 0:
                    if(p.checkBoundaries(getyPos() + 1, getxPos()) && !p.hasCollision(getyPos() + 1, getxPos())) {
                        PlayingField.setNullOnMap(getyPos(), getxPos());
                        PlayingField.setObjectOnMap(getyPos() + 1, getxPos(), this);
                        setyPos(getyPos() + 1);
                    }
                    else direction += 1;
                    break;
                case 1:
                    if(p.checkBoundaries(getyPos() - 1, getxPos()) && !p.hasCollision(getyPos() - 1, getxPos())) {
                        PlayingField.setNullOnMap(getyPos(), getxPos());
                        PlayingField.setObjectOnMap(getyPos() - 1, getxPos(), this);
                        setyPos(getyPos() - 1);

                    }
                    else direction += 1;
                    break;
                case 2:
                    if(p.checkBoundaries(getyPos(), getxPos() + 1) && !p.hasCollision(getyPos(), getxPos() + 1)) {
                        PlayingField.setNullOnMap(getyPos(), getxPos());
                        PlayingField.setObjectOnMap(getyPos(), getxPos() + 1, this);
                        setxPos(getxPos() + 1);
                    }
                    else direction += 1;
                    break;
                case 3:
                    if(p.checkBoundaries(getyPos(), getxPos() - 1) && !p.hasCollision(getyPos(), getxPos() - 1)) {
                        PlayingField.setNullOnMap(getyPos(), getxPos());
                        PlayingField.setObjectOnMap(getyPos(), getxPos() - 1, this);
                        setxPos(getxPos() - 1);
                    }
                    else direction += 1;
                    break;
                default:

            }
    }

}
