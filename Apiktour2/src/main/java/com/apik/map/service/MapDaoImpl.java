package com.apik.map.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;

public class MapDaoImpl extends SqlSessionDaoSupport implements MapDAO {
	
	
	//회원 검색
@Override
	public List<MapCommand> searchmap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
	System.out.println("searchmap 메소드 실행");
	return getSqlSession().selectList("searchmap",mapDto);
	}
	
	//회원 목록
	@Override
	public List<MapCommand> listmap() throws DataAccessException {
		// TODO Auto-generated method stub
		List<MapCommand> listmap=getSqlSession().selectList("listmap");
		return listmap;
	}
	
	//검색된 목록 수
	@Override
	public int countmap() throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countmap");
	}
	@Override
	public int countsearchmap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countsearchmap",mapDto);
	}
	
	
	//등록
	@Override
	public void insertmap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertmap",mapDto);
	}
	
	//상세정보
	@Override
	public MapCommand detailsmap(String locnum) throws DataAccessException {
		// TODO Auto-generated method stub
		return (MapCommand)getSqlSession().selectOne("detailsmap",locnum);
	}
	
	//수정
	@Override
	public void updatemap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updatemap",mapDto);
	}
	//삭제
	@Override
	public void deletemap(String locnum) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().delete("deletemap",locnum);
	}

}
