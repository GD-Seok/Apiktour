package com.apik.map.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.map.command.MapCommand;
import com.apik.person.command.PersonCommand;

//Person Table�� ����ϴ� ��� ��� ���
public interface MapDAO {
	
	//0.ȸ�� �˻� (searchperson)
	public List<MapCommand> searchmap(MapCommand mapDto) throws DataAccessException;
	
	//1.ȸ�� ��� (listperson)
	public List<MapCommand> listmap() throws DataAccessException;
	
	public int countmap() throws DataAccessException;
	
	public int countsearchmap(MapCommand mapDto) throws DataAccessException;
	
	//2. ȸ�� �α��� (loginperson)
	
	//3. ȸ�� ��� (insertperson)
	public void insertmap(MapCommand mapDto) throws DataAccessException;
	
	//4. ȸ�� ���� (updateperson)
	public void updatemap(MapCommand mapDto) throws DataAccessException;	
	//5. ȸ�� ��й�ȣ ���� (updatepersonpasswd)
	
	//6. ȸ�� ���� (deleteperson)
	public void deletemap(String locnum) throws DataAccessException;
	
	//7.ȸ�� ������
	public MapCommand detailsmap(String locnum) throws DataAccessException;
	
}
