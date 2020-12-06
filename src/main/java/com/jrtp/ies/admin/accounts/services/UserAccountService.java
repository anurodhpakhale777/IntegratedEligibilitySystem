package com.jrtp.ies.admin.accounts.services;

import java.util.List;

import com.jrtp.ies.admin.accounts.models.UserAccount;

public interface UserAccountService {

	boolean saveUserAccount(UserAccount userAcc);
	List<UserAccount> getAllUserAccounts(String role);
	UserAccount editUserAccount(Integer userAccId);
	boolean updateUserAccount(UserAccount userAcc);
	boolean deleteUserAccount(Integer userAccId);
}
