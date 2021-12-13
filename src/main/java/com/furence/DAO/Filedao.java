package com.furence.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.furence.VO.Uservo;

@Repository
public class Filedao implements FiledaoInterface{
	
	private static String mapperQuery="com.furence.DAO";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public int overlapCheck(String id) throws Exception {
		return sqlSession.selectOne(mapperQuery+".fileOverlap",id);
	}

	@Override
	public int dbInsert(Uservo uservo) throws Exception {
		return sqlSession.insert(mapperQuery+".fileinsert",uservo);
	}

	@Override
	public List<Uservo> fileLoad() throws Exception {
		return sqlSession.selectList(mapperQuery+".fileload");
	}
}
