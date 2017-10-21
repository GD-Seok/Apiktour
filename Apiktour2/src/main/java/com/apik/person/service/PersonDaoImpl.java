package com.apik.person.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDAO {
	
	//회원 등록
	public void insertperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertperson",personDto);
	}

}
