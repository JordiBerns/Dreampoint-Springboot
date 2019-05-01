package nl.yer.middlemen.dreampoint.character;

public abstract class Character {

    private int health;
    private String name;
    private boolean collision;
    private long id;

    public void shoot() {

    }

    public void move() {

    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

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
