package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.playingfield.PlayingField;
import static nl.yer.middlemen.dreampoint.game.Game.hiScore;


public class SmallEnemy extends Enemy {

    private long id;
    private int direction;

    public SmallEnemy() {
        super();
        this.setCanBeDamaged(true);
        this.setCanTakeAmountOfShots(1);
        this.setAddToHiScore(10);
        this.direction = 0;
        this.setCanContinueShootingAfterBeenShot(true);
    }

    @Override
    public void reactionToCollision() {
        System.out.println("A collision with the SmallEnemy happened!");
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
    public void move() {
        PlayingField p = new PlayingField();
            switch (direction%4){
                case 0:
                    if(p.notMovingOutOfBounds(getyPos() + 1, getxPos()) && p.canHaveCollisionWithOtherPiece(getyPos() + 1, getxPos())) {
                        PlayingField.putNullOnPlayingField(getyPos(), getxPos());
                        PlayingField.putObjectOnPlayingField(getyPos() + 1, getxPos(), this);
                        setyPos(getyPos() + 1);
                    }
                    else direction += 1;
                    break;
                case 1:
                    if(p.notMovingOutOfBounds(getyPos() - 1, getxPos()) && p.canHaveCollisionWithOtherPiece(getyPos() - 1, getxPos())) {
                        PlayingField.putNullOnPlayingField(getyPos(), getxPos());
                        PlayingField.putObjectOnPlayingField(getyPos() - 1, getxPos(), this);
                        setyPos(getyPos() - 1);

                    }
                    else direction += 1;
                    break;
                case 2:
                    if(p.notMovingOutOfBounds(getyPos(), getxPos() + 1) && p.canHaveCollisionWithOtherPiece(getyPos(), getxPos() + 1)) {
                        PlayingField.putNullOnPlayingField(getyPos(), getxPos());
                        PlayingField.putObjectOnPlayingField(getyPos(), getxPos() + 1, this);
                        setxPos(getxPos() + 1);
                    }
                    else direction += 1;
                    break;
                case 3:
                    if(p.notMovingOutOfBounds(getyPos(), getxPos() - 1) && p.canHaveCollisionWithOtherPiece(getyPos(), getxPos() - 1)) {
                        PlayingField.putNullOnPlayingField(getyPos(), getxPos());
                        PlayingField.putObjectOnPlayingField(getyPos(), getxPos() - 1, this);
                        setxPos(getxPos() - 1);
                    }
                    else direction += 1;
                    break;
                default:
            }
    }

    @Override
    public String toString() {return "\u2622";}

    @Override
    public long getId() {
        return id;
    }

}
