package nl.yer.middlemen.dreampoint.obstacle;

public class Pitfall extends Obstacle {

    private long id;

    public Pitfall() {
        super();
    }

    @Override
    public boolean reactionToBeingShot() {
        return false;
    }

    @Override
    public long getId() {
        return id;
    }


}