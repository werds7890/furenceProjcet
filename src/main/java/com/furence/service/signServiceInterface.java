package com.furence.service;

import com.furence.VO.UserVO;

public interface signServiceInterface {
	public int Datainsert(UserVO uservo) throws Exception;
	public int userSignup(UserVO uservo) throws Exception;
	public UserVO loginCheck(UserVO uservo) throws Exception;
}
