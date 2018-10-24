package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OnlineGame.ADZ.building.buildingRepository;
import exceptions.ResourceNotFoundException;
import OnlineGame.ADZ.building.*;

@RestController
@RequestMapping("/api")
public class buildingsController {

	@Autowired
	buildingRepository buildingRepository;

	// Get Buildings
	@GetMapping("/building")
	public List<Building> getAllBuildings() {
		return buildingRepository.findAll();
	}

	// Create a new Note
	@PostMapping("/building")
	public Building createNote(@Valid @RequestBody Building building) {
		return buildingRepository.save(building);
	}

	// Get a Single Note
	@GetMapping("/building/{id}")
	public Building getNoteById(@PathVariable(value = "id") Long buildingId) {
		return buildingRepository.findById(buildingId)
				.orElseThrow(() -> new ResourceNotFoundException("Building", "id", buildingId));
	}

}
