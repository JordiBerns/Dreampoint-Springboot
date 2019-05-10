package nl.yer.middlemen.dreampoint.game;

import java.util.Scanner;

public class HelpMenu {
    private long id;

    public void runHelpMenu() {
        boolean helpIsRunning = true;
        while (helpIsRunning) {
            Scanner input = new Scanner(System.in);
            System.out.println("---   Welcome to the Help menu of DreamPoint!   ---");
            System.out.println();
            System.out.println("       Controls    Credits    Tips    Back         ");
            System.out.println();
            System.out.println("---             Select a menu option            ---");
            String helpMenuInput = input.nextLine();

            switch (helpMenuInput.toLowerCase()) {
                case "controls":
                    System.out.println();
                    System.out.println("---          The controls for the game          ---");
                    System.out.println();
                    System.out.println("--- W ---        Moving the player Character from ");
                    System.out.println("--A S D--        left to right and from front and back  ");
                    System.out.println();
                    System.out.println("--- I ---        Shooting your gun to the front, back, ");
                    System.out.println("--J K L--        left and right.");
                    System.out.println();
                    break;

                case "credits":
                    System.out.println();
                    System.out.println("---                    Credits                  ---");
                    System.out.println();
                    System.out.println("Lead Developer:             Jordi, Tomas, Mohamed");
                    System.out.println("Lead Gameplay Design:       Jordi, Tomas, Mohamed");
                    System.out.println("Lead Character Design:      Jordi, Tomas, Mohamed");
                    System.out.println();
                    System.out.println("---              Special thanks to              ---");
                    System.out.println();
                    System.out.println("Lead Coach:                 RayRay");
                    System.out.println();
                    break;

                case "tips":
                    System.out.println("---               Tips & Tricks                 ---");
                    System.out.println();
                    System.out.println("- Shoot the enemy and run!!!!");
                    System.out.println();
                    break;

                case "back":
                    System.out.println();
                    System.out.println("Back to main menu!");
                    System.out.println();
                    helpIsRunning = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Wrong input, please type 'controls', 'credits', 'tips' or 'back'");
                    System.out.println();
            }
        }
    }

    public long getId() {
        return id;
    }

}
