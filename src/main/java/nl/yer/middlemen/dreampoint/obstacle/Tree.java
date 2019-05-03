package nl.yer.middlemen.dreampoint.obstacle;

public class Tree extends Obstacle {

    private long id;

    public Tree() {
        this.setCanDamage(true);
        this.setCanTakeAmountOfShots(1);
    }

    @Override
    public long getId() {
        return id;
    }


}



