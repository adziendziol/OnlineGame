package OnlineGame.ADZ.ressource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import OnlineGame.ADZ.building.Building;


@Repository
public interface RessourceBalanceRepository extends JpaRepository<RessourceBalance, Long>  {
	
	List<RessourceBalance> findByPlayerId(long playerId);
	
}
