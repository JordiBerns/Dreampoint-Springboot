package nl.yer.middlemen.dreampoint.item;

import static nl.yer.middlemen.dreampoint.game.Game.hiScore;

public class Pistol extends Weapon {
    private long id;

    public Pistol() {
        this.setCanDamage(false);
    }

    public void shoot(){}

    @Override
    public boolean determineIfCanShoot() {
        return false;
    }

    @Override
    public long getId() {
        return id;
    }
}