package OnlineGame.ADZ.ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ressourceLevelRepository extends JpaRepository<RessourceLevel, Long>  {

	
}
