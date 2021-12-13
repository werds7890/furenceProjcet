package com.furence.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.furence.VO.Uservo;
@Repository
public class Signdao implements SigndaoInterface{

	private static String mapperQuery="com.furence.DAO";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void userSignupDao(Uservo uservo) throws Exception {
		sqlSession.insert(mapperQuery+".signupinsert",uservo);
	}

	@Override
	public Uservo loginCheck(Uservo uservo) throws Exception {
		return sqlSession.selectOne(mapperQuery+".loginSelect",uservo);
	}

	@Override
	public List<Uservo> dataLoad(Uservo uservo) throws Exception {
		return sqlSession.selectList(mapperQuery+".selectAll", uservo);
	}

	@Override
	public int idOverlap(Uservo uservo) throws Exception {
		return sqlSession.selectOne(mapperQuery+".idoverlap", uservo);
	}
	
	


}
