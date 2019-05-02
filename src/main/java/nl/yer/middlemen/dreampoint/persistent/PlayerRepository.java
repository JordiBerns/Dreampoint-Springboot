package nl.yer.middlemen.dreampoint.persistent;

import nl.yer.middlemen.dreampoint.character.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository <Player, Long> {

}
