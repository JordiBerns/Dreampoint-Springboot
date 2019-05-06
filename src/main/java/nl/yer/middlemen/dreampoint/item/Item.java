package nl.yer.middlemen.dreampoint.item;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;

public abstract class Item extends PiecesOnPlayingField {
    private long id;

    @Override
    public abstract boolean determineIfCanShoot();

    public long getId() {
        return id;
    }

    }
