package com.furence.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.furence.DAO.signDaoInterface;
import com.furence.VO.UserVO;
@Service
public class signService implements signServiceInterface{
	@Inject
	private signDaoInterface SignDaointerface;
	
	@Override
	public int Datainsert(UserVO uservo) throws Exception {
		int a=SignDaointerface.DataInsert(uservo);
		return a;
	}

	@Override
	public int userSignup(UserVO uservo) throws Exception {
		return SignDaointerface.userSignupDao(uservo);
	}

	@Override
	public UserVO loginCheck(UserVO uservo) throws Exception {
		return SignDaointerface.loginCheck(uservo);
	}
	
	

}
