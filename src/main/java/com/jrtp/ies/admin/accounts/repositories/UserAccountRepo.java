package com.jrtp.ies.admin.accounts.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.admin.accounts.entity.UserAccountEntity;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccountEntity, Integer> {

	List<UserAccountEntity> findAllByRoleAndIsActiveTrue(String role);
	
	@Transactional
	@Modifying
	@Query("update UserAccountEntity u set u.isActive = 0 where u.id = :userAccId")
	int deleteSoftUserAccount(@Param("userAccId") Integer userAccId);
}