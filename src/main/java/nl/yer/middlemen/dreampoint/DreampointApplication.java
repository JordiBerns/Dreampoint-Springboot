package nl.yer.middlemen.dreampoint;

import nl.yer.middlemen.dreampoint.game.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DreampointApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreampointApplication.class, args);

		MainMenu mainMenu = new MainMenu();
		mainMenu.runMainMenu();
	}

}
