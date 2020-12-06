package com.jrtp.ies.ed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrtp.ies.ed.entity.CorrespondenceTriggerEntity;

public interface CorrespondenceTriggerRepository extends JpaRepository<CorrespondenceTriggerEntity, Integer> {

	List<CorrespondenceTriggerEntity> findAllByTriggerStatus(char status);
}
