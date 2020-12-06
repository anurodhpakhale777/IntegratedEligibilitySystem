package com.jrtp.ies.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.dc.entity.EducationEntity;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {

}
