package com.furence.service;

import java.util.List;

import com.furence.VO.Uservo;

public interface FileserviceInterface {
	public int overlapCheck(String id) throws Exception;
	public int dbInsert(Uservo uservo) throws Exception;
	public List<Uservo> fileLoad() throws Exception;
}
