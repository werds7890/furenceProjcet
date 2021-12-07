package com.furence.service;

import java.util.List;

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
	public void userSignup(UserVO uservo) throws Exception {
		SignDaointerface.userSignupDao(uservo);
	}

	@Override
	public UserVO loginCheck(UserVO uservo) throws Exception {
		return SignDaointerface.loginCheck(uservo);
	}

	@Override
	public List<UserVO> dataLoad(UserVO uservo) throws Exception {
		// TODO Auto-generated method stub
		return SignDaointerface.dataLoad(uservo);
	}

	@Override
	public int idOverlap(UserVO uservo) throws Exception {
		return SignDaointerface.idOverlap(uservo);
	}
	
	

}
