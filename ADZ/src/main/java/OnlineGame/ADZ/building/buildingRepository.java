package OnlineGame.ADZ.building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface buildingRepository extends JpaRepository<Building, Long> {

}