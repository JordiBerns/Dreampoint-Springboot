package nl.yer.middlemen.dreampoint.character;

import nl.yer.middlemen.dreampoint.item.Weapon;

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

    public Player(){
        this.score = 0;
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
            System.out.println(this.getPlayerInfo());
            String stringCorrect = input.nextLine();

            // While loop to check if y or n is selected during prompt
            while(stringCorrect.isEmpty() || (stringCorrect.charAt(0) != 'y' && stringCorrect.charAt(0) != 'n')){
                System.out.print("Please choose y or n: ");
                stringCorrect = input.nextLine();
            }
            if (stringCorrect.charAt(0) == 'y') correctInfo = true;
        }
    }

    public String getPlayerInfo(){
        return "Name: " + this.name
                + "\nAge: " + this.age
                + "\nGender: " + this.sex
                + "\nHaircolor: "+ this.hairColour;
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

    @Override
    public String toString() {
        return "\u263A";
    }

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
