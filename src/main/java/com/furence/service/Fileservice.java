package com.furence.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.furence.DAO.FiledaoInterface;
import com.furence.VO.Uservo;

@Service
public class Fileservice implements FileserviceInterface{
	@Inject
	private FiledaoInterface fileDao;
	
	@Override
	public int overlapCheck(String id) throws Exception {
		return fileDao.overlapCheck(id);
	}

	@Override
	public int dbInsert(Uservo uservo) throws Exception {
		return fileDao.dbInsert(uservo);
	}

	@Override
	public List<Uservo> fileLoad() throws Exception {
		return fileDao.fileLoad();
	}

}
