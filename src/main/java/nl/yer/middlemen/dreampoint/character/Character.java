package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Character extends PiecesOnPlayingField {

    private String name;
    private boolean collision;
    private long id;

//    public void shoot() { }
//    public void move() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public long getId() {
        return id;
    }
}
