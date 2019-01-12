package com.mk.spaceAgencyDataHub.service;

import java.util.List;

import com.mk.spaceAgencyDataHub.entity.Mission;

public interface MissionService {
	
	public List<Mission> retriveMissions();

	public void saveMission(Mission mission);

	public Mission getMission(Long missionId);

	public void deleteMission(Long missionId);

	public void updateMission(Mission mission);


}
