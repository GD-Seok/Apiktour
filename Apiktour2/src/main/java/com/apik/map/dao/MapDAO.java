package com.apik.map.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.map.command.MapCommand;
import com.apik.person.command.PersonCommand;

//Person Table을 사용하는 모든 기능 등록
public interface MapDAO {
	
	//0.회원 검색 (searchperson)
	public List<MapCommand> searchmap(MapCommand mapDto) throws DataAccessException;
	
	//1.회원 목록 (listperson)
	public List<MapCommand> listmap() throws DataAccessException;
	
	public int countmap() throws DataAccessException;
	
	public int countsearchmap(MapCommand mapDto) throws DataAccessException;
	
	//2. 회원 로그인 (loginperson)
	
	//3. 회원 등록 (insertperson)
	public void insertmap(MapCommand mapDto) throws DataAccessException;
	
	//4. 회원 수정 (updateperson)
	public void updatemap(MapCommand mapDto) throws DataAccessException;	
	//5. 회원 비밀번호 변경 (updatepersonpasswd)
	
	//6. 회원 삭제 (deleteperson)
	public void deletemap(String locnum) throws DataAccessException;
	
	//7.회원 상세정보
	public MapCommand detailsmap(String locnum) throws DataAccessException;
	
}
