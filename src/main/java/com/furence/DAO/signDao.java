package com.furence.DAO;

import java.util.List;

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
	public void userSignupDao(UserVO uservo) throws Exception {
		sqlSession.insert(mapperQuery+".signupinsert",uservo);
	}

	@Override
	public UserVO loginCheck(UserVO uservo) throws Exception {
		return sqlSession.selectOne(mapperQuery+".loginSelect",uservo);
	}

	@Override
	public List<UserVO> dataLoad(UserVO uservo) throws Exception {
		return sqlSession.selectList(mapperQuery+".selectAll", uservo);
	}

	@Override
	public int idOverlap(UserVO uservo) throws Exception {
		return sqlSession.selectOne(mapperQuery+".idoverlap", uservo);
	}
	
	


}
