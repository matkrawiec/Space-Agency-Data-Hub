package com.mk.spaceAgencyDataHub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.spaceAgencyDataHub.entity.Mission;
import com.mk.spaceAgencyDataHub.service.MissionService;

@RestController
public class MissionController {
	
	@Autowired
	private MissionService missionService;
	
	@GetMapping("/missions")
	public List<Mission> getMissions() {
		List<Mission> missions = missionService.retriveMissions();
		return missions;
	}
	
	@GetMapping("/missions/{missionId}")
	public Mission getMission(@PathVariable(name="missionId") Long missionId) {
		return missionService.getMission(missionId);
	}
	
	@PostMapping("/missions")
	public void saveMission (@Valid @RequestBody Mission mission) {
		mission.setId(0);
		missionService.saveMission(mission);
	}
	
	@DeleteMapping("/missions/{missionId}")
	public void deleteMission (@PathVariable(name="missionId") Long missionId) {
		missionService.deleteMission(missionId);
	}
	
	@PutMapping("/missions/{missionId}")
	public void updateMission(@RequestBody Mission mission, @PathVariable(name="missionId") Long missionId) {
		Mission mis = missionService.getMission(missionId);
		if(mis != null) {
			missionService.updateMission(mission);
		}
	}

}




















