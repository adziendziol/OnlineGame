package OnlineGame.ADZ.building;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
		return buildingRepository.findByOrderByIdAsc();
	}

	// Create a new Building
	@PostMapping("/building")
	public Building createBuilding(@Valid @RequestBody Building building) {
		System.out.print(building);
		return buildingRepository.save(building);
	}

	@PutMapping("/building")
	public Building updateBuildingById(@RequestBody Building newBuilding) {
		System.out.println(newBuilding);
		return buildingRepository.findById(newBuilding.getId())
				.map(building -> {
			building.setName(newBuilding.getName());
			building.setDescription(newBuilding.getDescription());
			building.setBuildingtype(newBuilding.getBuildingtype());
			return buildingRepository.save(building);
		})
		.orElseGet(()-> {
			return buildingRepository.save(newBuilding);
		});
	}
	
	// Get a Single Building
	@GetMapping("/building/{id}")
	public Building getBuildingById(@PathVariable(value = "id") Long buildingId) {
		return buildingRepository.findById(buildingId)
				.orElseThrow(() -> new ResourceNotFoundException("Building", "id", buildingId));
	}

	@GetMapping("/building/buildingtypes")
	public buildingTypeEnum[] getBuildingTypes() {
		return buildingTypeEnum.values();
	}

}
