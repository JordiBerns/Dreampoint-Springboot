package nl.yer.middlemen.dreampoint.item;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Item extends PiecesOnPlayingField {
    private long id;

    public Item() {
        this.setCanCollideWithOtherPiece(true);
    }

    @Override
    public abstract boolean reactionToBeingShot();

    public long getId() {
        return id;
    }

    }
