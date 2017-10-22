package com.apik.person.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDAO {
	
	//회원 목록 검색
	@Override
	public List<PersonCommand> listperson(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	//검색시 필요한 페이징 처리
	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//회원 등록
	@Override
	public void insertperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertperson",personDto);
	}

}
