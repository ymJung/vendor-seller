/**
 * 
 */
package com.weone.controller.model;

import java.io.Serializable;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.weone.dao.model.UserAccount;

/**
 * @author YoungMin
 *
 */
public class LoginAccountDto extends User implements Serializable {
	private static final long serialVersionUID = -8701707854617299884L;

	private long id;
	
	public long getId() {
		return id;
	}

	public LoginAccountDto(UserAccount userAccount) {
		super(userAccount.getAccount(), userAccount.getPassword(), AuthorityUtils.createAuthorityList(userAccount.getRole()));
		id = userAccount.getId();
	}
}
