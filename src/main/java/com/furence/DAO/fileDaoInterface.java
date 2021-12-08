package com.furence.DAO;

import com.furence.VO.UserVO;

public interface fileDaoInterface {
	public int overlapCheck(String id) throws Exception;
	public int dbInsert(UserVO uservo) throws Exception;
}
