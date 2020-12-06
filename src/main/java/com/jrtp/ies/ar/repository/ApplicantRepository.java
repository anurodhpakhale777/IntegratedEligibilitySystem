package com.jrtp.ies.ar.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.ar.entity.ApplicantEntity;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Integer> {

	List<ApplicantEntity> findAllByIsActiveTrue();
	
	Optional<ApplicantEntity> findByApplicantId(String applicantId);
	
	@Transactional
	@Modifying
	@Query("update ApplicantEntity a set a.isActive = 0 where a.applicantId = :applicantId")
	int deleteSoftApplicant(@Param("applicantId") String applicantId);
}
