package com.hrevfdz.dao;

import java.util.List;

import com.hrevfdz.models.Users;
import com.hrevfdz.services.PharmacyService;

public class UsersDAO extends PharmacyService<Users>{

	@Override
	public List<Users> findByQuery(String q) throws Exception {
		return super.findByQuery(q);
	}

}
