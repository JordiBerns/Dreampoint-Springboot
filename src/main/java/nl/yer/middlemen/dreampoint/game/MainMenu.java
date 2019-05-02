package nl.yer.middlemen.dreampoint.game;

import java.util.Scanner;

public class MainMenu {
    private long id;

    public void runMainMenu() {
        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;
        Game game = new Game();

        while (keepRunning) {
            // introduction of the game
            System.out.println("---            Welcome to DreamPoint!           ---");
            System.out.println(" --     The shooting game by the MiddleMen!     -- ");
            System.out.println();
            System.out.println("          Start    Hiscore    Help    Quit         ");
            System.out.println();

            // user gives information what (s)he wants to do and the input is used to start a method
            System.out.println("---           What do you want to do?           ---");
            String mainMenuInput = input.nextLine();
            System.out.println();

            // search input in switch statement and runs that code. Every option breaks into the while loop.
            // Only 'quit' breaks the for loop!
            switch (mainMenuInput.toLowerCase()) {
                case "start":
                    System.out.println("<---            Let's get shooting!             -->");
                    game.runGame();
                    break;

                case "hiscore":
                    System.out.println("Nice hiscores!");
                    System.out.println();
                    break;

                case "help":
                    HelpMenu help = new HelpMenu();
                    help.runHelpMenu();
                    break;

                case "quit":
                    System.out.println("Quitting the game!");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Wrong input, please type 'start', 'hiscore', 'help' or 'quit'");
                    System.out.println();
                    break;
            }
        }
    }

    public long getId() {
        return id;
    }
}
