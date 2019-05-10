package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Character extends PiecesOnPlayingField {

    private long id;
    private String name;

    public Character() {
        this.setCanCollideWithOtherPiece(true);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
