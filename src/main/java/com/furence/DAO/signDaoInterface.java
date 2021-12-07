package com.furence.DAO;

import java.util.List;

import com.furence.VO.UserVO;

public interface signDaoInterface {
	public int DataInsert(UserVO uservo) throws Exception;
	
	public void userSignupDao(UserVO uservo) throws Exception;
	public UserVO loginCheck(UserVO uservo) throws Exception;
	public List<UserVO> dataLoad(UserVO uservo) throws Exception;
	public int idOverlap(UserVO uservo) throws Exception;
}
