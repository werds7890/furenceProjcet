package com.furence.service;

import com.furence.VO.UserVO;

public interface fileServiceInterface {
	public int overlapCheck(String id) throws Exception;
	public int dbInsert(UserVO uservo) throws Exception;
}
