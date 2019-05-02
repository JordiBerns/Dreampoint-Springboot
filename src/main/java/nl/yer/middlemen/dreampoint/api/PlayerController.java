package nl.yer.middlemen.dreampoint.api;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Iterable<Player> list() {
        return playerService.findAll();
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return this.playerService.save(player);
    }

}
