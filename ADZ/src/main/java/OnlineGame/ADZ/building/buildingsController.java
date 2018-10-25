package OnlineGame.ADZ.building;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import OnlineGame.ADZ.building.*;
import OnlineGame.ADZ.exceptions.ResourceNotFoundException;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class buildingsController {

	@Autowired
	buildingRepository buildingRepository;

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(buildingsController.class, args);
	}
	
	// Get Buildings

	@GetMapping("/building")
	public List<Building> getAllBuildings() {
		return buildingRepository.findAll();
	}

	// Create a new Building
	@PostMapping("/building")
	public Building createBuilding(@Valid @RequestBody Building building) {
		System.out.print(building);
		return buildingRepository.save(building);
	}

	// Get a Single Building
	@GetMapping("/building/{id}")
	public Building getBuildingById(@PathVariable(value = "id") Long buildingId) {
		return buildingRepository.findById(buildingId)
				.orElseThrow(() -> new ResourceNotFoundException("Building", "id", buildingId));
	}

}
