package com.furence.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.furence.DAO.SigndaoInterface;
import com.furence.VO.Uservo;
@Service
public class Signservice implements SignserviceInterface{
	@Inject
	private SigndaoInterface SignDaointerface;
	
	

	@Override
	public void userSignup(Uservo uservo) throws Exception {
		SignDaointerface.userSignupDao(uservo);
	}

	@Override
	public Uservo loginCheck(Uservo uservo) throws Exception {
		return SignDaointerface.loginCheck(uservo);
	}

	@Override
	public List<Uservo> dataLoad(Uservo uservo) throws Exception {
		// TODO Auto-generated method stub
		return SignDaointerface.dataLoad(uservo);
	}

	@Override
	public int idOverlap(Uservo uservo) throws Exception {
		return SignDaointerface.idOverlap(uservo);
	}
	
	

}
