package com.jrtp.ies.dc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.dc.entity.ChildCareEntity;

@Repository
public interface ChildCareRepository extends JpaRepository<ChildCareEntity, Integer> {

	@Transactional
	@Modifying
	@Query("update ChildCareEntity c set c.isActive = 0 where c.caseId = :caseId")
	int deleteSoftChildDetails(@Param("caseId") Integer caseId);
}
