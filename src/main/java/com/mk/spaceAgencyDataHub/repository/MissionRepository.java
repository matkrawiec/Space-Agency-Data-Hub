package com.mk.spaceAgencyDataHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.spaceAgencyDataHub.entity.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
