package com.jrtp.ies.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.dc.entity.CaseDetailEntity;

@Repository
public interface CaseRepository extends JpaRepository<CaseDetailEntity, Short> {

	
}
