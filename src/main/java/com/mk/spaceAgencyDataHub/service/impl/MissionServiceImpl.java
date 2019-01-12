package com.mk.spaceAgencyDataHub.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.spaceAgencyDataHub.entity.Mission;
import com.mk.spaceAgencyDataHub.repository.MissionRepository;
import com.mk.spaceAgencyDataHub.service.MissionService;

@Service("MissionService")
public class MissionServiceImpl implements MissionService {
	
	@Autowired
	private MissionRepository missionRepository;

	@Override
	public List<Mission> retriveMissions() {
		List<Mission> missions = missionRepository.findAll();
		return missions;
	}

	@Override
	public void saveMission(Mission mission) {
		missionRepository.save(mission);
	}

	@Override
	public Mission getMission(Long missionId) {
		Optional<Mission> optionalMission = missionRepository.findById(missionId);
		return optionalMission.get();
	}

	@Override
	public void deleteMission(Long missionId) {
		missionRepository.deleteById(missionId);
	}

	@Override
	public void updateMission(Mission mission) {
		missionRepository.save(mission);
	}

	

}








