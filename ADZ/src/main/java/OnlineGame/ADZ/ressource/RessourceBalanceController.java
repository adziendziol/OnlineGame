package OnlineGame.ADZ.ressource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RessourceBalanceController {

	@Autowired
	RessourceBalanceRepository ressourceBalanceRepository;
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RessourceBalanceController.class, args);
	}
	
	
	@GetMapping("/ressourceBalance/{playerId}")
	public List<RessourceBalance> getCurrentRessourceBalance(@PathVariable(value = "playerId") Long playerId){
		return ressourceBalanceRepository.findByPlayerId(playerId);
		
	}
	

}
