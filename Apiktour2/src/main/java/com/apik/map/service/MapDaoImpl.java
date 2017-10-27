package com.apik.map.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;

public class MapDaoImpl extends SqlSessionDaoSupport implements MapDAO {
	
	
	//ȸ�� �˻�
@Override
	public List<MapCommand> searchmap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
	System.out.println("searchmap �޼ҵ� ����");
	return getSqlSession().selectList("searchmap",mapDto);
	}
	
	//ȸ�� ���
	@Override
	public List<MapCommand> listmap() throws DataAccessException {
		// TODO Auto-generated method stub
		List<MapCommand> listmap=getSqlSession().selectList("listmap");
		return listmap;
	}
	
	//�˻��� ��� ��
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
	
	
	//���
	@Override
	public void insertmap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertmap",mapDto);
	}
	
	//������
	@Override
	public MapCommand detailsmap(String locnum) throws DataAccessException {
		// TODO Auto-generated method stub
		return (MapCommand)getSqlSession().selectOne("detailsmap",locnum);
	}
	
	//����
	@Override
	public void updatemap(MapCommand mapDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updatemap",mapDto);
	}
	//����
	@Override
	public void deletemap(String locnum) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().delete("deletemap",locnum);
	}

}
