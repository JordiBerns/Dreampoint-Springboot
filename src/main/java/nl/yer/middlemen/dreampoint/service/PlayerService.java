package nl.yer.middlemen.dreampoint.service;

import nl.yer.middlemen.dreampoint.character.Player;
import nl.yer.middlemen.dreampoint.persistent.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService (PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player save (Player player) {
        return this.playerRepository.save(player);
    }

    public Optional<Player> findById(Long aLong) {
        return playerRepository.findById(aLong);
    }

    public Iterable<Player> findAll() {
        return this.playerRepository.findAll();
    }

    public void deleteById(Long aLong) {
        this.playerRepository.deleteById(aLong);
    }

}
