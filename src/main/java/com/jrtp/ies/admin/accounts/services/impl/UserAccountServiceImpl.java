package com.jrtp.ies.admin.accounts.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp.ies.admin.accounts.entity.UserAccountEntity;
import com.jrtp.ies.admin.accounts.models.UserAccount;
import com.jrtp.ies.admin.accounts.repositories.UserAccountRepo;
import com.jrtp.ies.admin.accounts.services.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userAccRepo;
	
	@Override
	public boolean saveUserAccount(UserAccount userAcc) {
		userAcc.setActive(true);
		UserAccountEntity userAccEnt = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, userAccEnt);
		return null != userAccRepo.save(userAccEnt);
	}

	@Override
	public List<UserAccount> getAllUserAccounts(String role) {
		
		 List<UserAccountEntity> userAccEnts = userAccRepo.findAllByRoleAndIsActiveTrue(role);
		 List<UserAccount> userAccList = new ArrayList<UserAccount>();
		 if(null != userAccEnts) {
			 userAccEnts.stream().forEach((userAccEnt) -> {
				 UserAccount userAcc = new UserAccount();
				 BeanUtils.copyProperties(userAccEnt, userAcc);
				 userAccList.add(userAcc);
			 });
		 }
		 return userAccList;
	}
	
	
	@Override
	public UserAccount editUserAccount(Integer userAccId) {
		Optional<UserAccountEntity> userAccEntOpt = userAccRepo.findById(userAccId);
		UserAccount userAcc = new UserAccount();
		if(userAccEntOpt.isPresent()) {
			BeanUtils.copyProperties(userAccEntOpt.get(), userAcc);
		}
		return userAcc;
	}

	@Override
	public boolean updateUserAccount(UserAccount userAcc) {
		return saveUserAccount(userAcc);
	}

	@Override
	public boolean deleteUserAccount(Integer userAccId) {
		return userAccRepo.deleteSoftUserAccount(userAccId) > 0;
	}

}
