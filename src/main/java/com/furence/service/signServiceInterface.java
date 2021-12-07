package com.furence.service;

import java.util.List;

import com.furence.VO.UserVO;

public interface signServiceInterface {
	public int Datainsert(UserVO uservo) throws Exception;
	
	public void userSignup(UserVO uservo) throws Exception;
	public UserVO loginCheck(UserVO uservo) throws Exception;
	public List<UserVO> dataLoad(UserVO uservo) throws Exception;
	public int idOverlap(UserVO uservo) throws Exception;
}
