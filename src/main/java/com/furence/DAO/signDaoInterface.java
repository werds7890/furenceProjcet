package com.furence.DAO;

import com.furence.VO.UserVO;

public interface signDaoInterface {
	public int DataInsert(UserVO uservo) throws Exception;
	public int userSignupDao(UserVO uservo) throws Exception;
	public UserVO loginCheck(UserVO uservo) throws Exception;
}
