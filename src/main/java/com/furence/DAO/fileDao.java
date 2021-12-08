package com.furence.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.furence.VO.UserVO;

@Repository
public class fileDao implements fileDaoInterface{
	
	private static String mapperQuery="com.furence.DAO";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public int overlapCheck(String id) throws Exception {
		return sqlSession.selectOne(mapperQuery+".fileOverlap",id);
	}

	@Override
	public int dbInsert(UserVO uservo) throws Exception {
		return sqlSession.insert(mapperQuery+".fileinsert",uservo);
	}
}
