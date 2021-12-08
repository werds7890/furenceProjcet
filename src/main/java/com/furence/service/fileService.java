package com.furence.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.furence.DAO.fileDaoInterface;
import com.furence.VO.UserVO;

@Service
public class fileService implements fileServiceInterface{
	@Inject
	private fileDaoInterface fileDao;
	
	@Override
	public int overlapCheck(String id) throws Exception {
		return fileDao.overlapCheck(id);
	}

	@Override
	public int dbInsert(UserVO uservo) throws Exception {
		return fileDao.dbInsert(uservo);
		
	}

}
