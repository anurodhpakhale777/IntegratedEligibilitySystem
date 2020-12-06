package com.jrtp.ies.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.dc.entity.IncomeDetailEntity;

@Repository
public interface IncomeDetailRepository extends JpaRepository<IncomeDetailEntity, Short> {

}
