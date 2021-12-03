package com.furence.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.furence.VO.UserVO;
@Repository
public class signDao implements signDaoInterface{

	private static String mapperQuery="com.furence.DAO";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int DataInsert(UserVO uservo) throws Exception {
		return sqlSession.insert(mapperQuery+".userinsert",uservo);
		
	}

	@Override
	public int userSignupDao(UserVO uservo) throws Exception {
		return sqlSession.insert(mapperQuery+".signupinsert",uservo);
	}




}
