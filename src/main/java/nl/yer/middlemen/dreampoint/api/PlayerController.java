package nl.yer.middlemen.dreampoint.api;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("{id}")
    public Player get(@PathVariable long id) {
        Optional<Player> optionalResult = this.playerService.findById(id);
        if (optionalResult.isPresent()) {
            Player result = optionalResult.get();
            return result;
        }
        else {
            return null; // moet veranderen
        }
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return this.playerService.save(player);
    }


    @PutMapping("{id}")
    public Player update(@PathVariable long id, @RequestBody Player input) {
        Optional<Player> optionalTarget  = this.playerService.findById(id);
        if(optionalTarget.isPresent()) {
            Player target = optionalTarget.get();
            target.setName(input.getName());
            // target.setSex(input.getSex());
            return this.playerService.save(target);
        }
        else{
            return null; // wederom niet goed.
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Player> optionalResult = this.playerService.findById(id);
        if(optionalResult.isPresent()) {
            this.playerService.deleteById(id);
        }
    }

}
