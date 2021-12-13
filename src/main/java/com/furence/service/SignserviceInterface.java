package com.furence.service;

import java.util.List;

import com.furence.VO.Uservo;

public interface SignserviceInterface {
	
	public void userSignup(Uservo uservo) throws Exception;
	public Uservo loginCheck(Uservo uservo) throws Exception;
	public List<Uservo> dataLoad(Uservo uservo) throws Exception;
	public int idOverlap(Uservo uservo) throws Exception;
}
