package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.game.PiecesOnPlayingField;
import nl.yer.middlemen.dreampoint.playingfield.PlayingField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.InputMismatchException;
import java.util.Scanner;

@Entity
public class Player extends Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int age;
    private String sex;
    private String name;
    private String hairColour;
    private int score;
    private int health = 100;
    private int playerYpos;
    private int playerXpos;

   public void move(String direction) {
       PlayingField level = new PlayingField();

       switch (direction.charAt(0)) {
           case 'w':
               if(level.checkBoundaries(playerYpos - 1, playerXpos)) {
                    if (!level.hasCollision(playerYpos - 1, playerXpos)) {
                        PlayingField.setNullOnMap(playerYpos, playerXpos);
                        PlayingField.setObjectOnMap(--playerYpos, playerXpos, this);
                    }
               }
               break;

           case 's':
               if(level.checkBoundaries(playerYpos + 1, playerXpos)) {
                   if (!level.hasCollision(playerYpos + 1, playerXpos)) {
                       PlayingField.setObjectOnMap(playerYpos, playerXpos, null);
                       PlayingField.setObjectOnMap(++playerYpos, playerXpos, this);
                   }
               }
               break;

           case 'd':
               if(level.checkBoundaries(playerYpos, playerXpos + 1)) {
                   if (!level.hasCollision(playerYpos, playerXpos + 1)) {
                       PlayingField.setObjectOnMap(playerYpos, playerXpos, null);
                       PlayingField.setObjectOnMap(playerYpos, ++playerXpos, this);
                   }
               }
               break;

           case 'a':
               if(level.checkBoundaries(playerYpos, playerXpos -1)) {
                   if (!level.hasCollision(playerYpos, playerXpos - 1)) {
                       PlayingField.setObjectOnMap(playerYpos, playerXpos, null);
                       PlayingField.setObjectOnMap(playerYpos, --playerXpos, this);
                   }
               }
               break;
       }
   }

       public void shoot (String direction){
           PlayingField level = new PlayingField();
           int i = 1;

           switch (direction.charAt(0)) {
               case 'i':
                   while ((level.checkBoundaries(playerYpos - i, playerXpos)) &&
                           (level.canShoot(playerYpos - i, playerXpos))) {
                       PlayingField.setObjectOnMap(playerYpos - i, playerXpos, null);
                       i++;
                   }
                   break;

               case 'k':
                   while ((level.checkBoundaries(playerYpos + i, playerXpos)) &&
                           (level.canShoot(playerYpos + i, playerXpos))) {
                       PlayingField.setObjectOnMap(playerYpos + i, playerXpos, null);
                       i++;
                   }
                   break;

               case 'l':
                   while ((level.checkBoundaries(playerYpos, playerXpos + i)) &&
                           (level.canShoot(playerYpos, playerXpos + i))) {
                       PlayingField.setObjectOnMap(playerYpos, playerXpos + i, null);
                       i++;
                   }
                   break;

               case 'j':
                   while ((level.checkBoundaries(playerYpos, playerXpos - i)) &&
                           (level.canShoot(playerYpos, playerXpos - i))) {
                       PlayingField.setObjectOnMap(playerYpos, playerXpos - i, null);
                       i++;
                   }
                   break;
           }
       }
   }

   public void initializePlayer(){
       Scanner input = new Scanner(System.in);
       // Boolean statements used later on to check scanner input
       boolean correctInfo = false;
       boolean correctAge;

        while (!correctInfo) {
            System.out.println();
            System.out.println("---   Character creation   ---");
            // NAME INITIALISATION
            // While loop to prevent empty name
            do {
                System.out.print("Please enter your name: ");
                this.name = input.nextLine();
            } while(this.name.isEmpty());

            // AGE INITIALISATION
            System.out.print("Enter your age: ");
            // While loop to prevent any other input than a int
            correctAge = false;
            while(!correctAge) {
                try {
                    this.age = input.nextInt();
                    input.nextLine();
                    correctAge = true;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid age. Please insert integer: ");
                    input.next();     //This statement clears the wrong input
                    correctAge = false;
                }
            }

            // GENDER INITIALISATION
            // While loop to prevent empty input for gender and non male or non female (non-binary not allowed)
            do {
                System.out.print("Please enter your gender (m or f): ");
                this.sex = input.nextLine().toLowerCase();
            } while (sex.isEmpty() || (sex.charAt(0) != 'm' && sex.charAt(0) != 'f'));
            this.sex = "" + this.sex.charAt(0);

            // HAIRCOLOR INITIALISATION
            // While loop to prevent empty haircolor;
            do {
                System.out.print("Please enter your haircolor: ");
                this.hairColour = input.nextLine();
            } while(this.hairColour.isEmpty());

            // Check if players input is correct
            System.out.println();
            System.out.println("Is your input correct (y/n)? ");
            System.out.println(this.showPlayerInfo());
            String stringCorrect = input.nextLine();

            // While loop to check if y or n is selected during prompt
            while(stringCorrect.isEmpty() || (stringCorrect.charAt(0) != 'y' && stringCorrect.charAt(0) != 'n')){
                System.out.print("Please choose y or n: ");
                stringCorrect = input.nextLine();
            }
            if (stringCorrect.charAt(0) == 'y') correctInfo = true;
        }
    }

    public String showPlayerInfo(){
        return "Name: " + this.name
                + "\nAge: " + this.age
                + "\nGender: " + this.sex
                + "\nHaircolor: "+ this.hairColour;
    }

    /** FOR FUTURE: Player created in function below needs to be coupled to player created in Game class.*/
    public void setRandomStartPlayerPosition(){    //Sets random start position of player
        int pos;
        int xPos;
        int yPos;
        do {    //do while loop ensures player isn't placed on an Obstacle or Item.
            pos = (int) (Math.random() * 100);  //Random position between 0 and 99
            xPos = pos % 10;
            yPos = pos / 10;
        } while(PlayingField.checkObjectOnMap(yPos, xPos) != null);

        PlayingField.setObjectOnMap(yPos, xPos, this);
        playerXpos = xPos;
        playerYpos = yPos;
    }

    @Override
    public String toString() {
        return "\u263A";
    }

    @Override
    public boolean determineIfCanShoot() {
        return false;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerYpos() {
        return playerYpos;
    }

    public void setPlayerYpos(int playerYpos) {
        this.playerYpos = playerYpos;
    }

    public int getPlayerXpos() {
        return playerXpos;
    }

    public void setPlayerXpos(int playerXpos) {
        this.playerXpos = playerXpos;
    }


//    @Override
//    public void shotsTaken() {
//
//    }

    //    private int bullets;
//    private Weapon weapon;

    //    public int getBullets() {
//        return bullets;
//    }

//    public void setBullets(int bullets) {
//        this.bullets = bullets;
//    }

//    public Weapon getWeapon() {
//        return weapon;
//    }

//    public void setWeapon(Weapon weapon) {
//        this.weapon = weapon;
//    }
}
