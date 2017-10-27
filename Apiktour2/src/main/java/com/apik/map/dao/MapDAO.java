package com.apik.map.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.map.command.MapCommand;

//map Table�� ����ϴ� ��� ��� ���
public interface MapDAO {
	
	//0.ȸ�� �˻� (searchmap)
		public List<MapCommand> searchmap(MapCommand mapDto) throws DataAccessException;
		//1.ȸ�� ��� (listmap)
		public List<MapCommand> listmap() throws DataAccessException;
		public int countmap() throws DataAccessException;
		public int countsearchmap(MapCommand mapDto) throws DataAccessException;
		//3. ȸ�� ��� (insertmap)
		public void insertmap(MapCommand mapDto) throws DataAccessException;
		//4. ȸ�� ���� (updatemap)
		public void updatemap(MapCommand mapDto) throws DataAccessException;	
		//6. ȸ�� ���� (deletemap)
		public void deletemap(String locnum) throws DataAccessException;
		//7.ȸ�� ������
		public MapCommand detailsmap(String locnum) throws DataAccessException;
		
	
}
