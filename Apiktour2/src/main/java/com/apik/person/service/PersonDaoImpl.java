package com.apik.person.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDAO {
	
	
	//ȸ�� �˻�
	@Override
	public List<PersonCommand> searchperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("searchperson �޼ҵ� ����");
		return getSqlSession().selectList("searchperson",personDto);
	}
	
	//ȸ�� ���
	@Override
	public List<PersonCommand> listperson() throws DataAccessException {
		// TODO Auto-generated method stub
		List<PersonCommand> listperson=getSqlSession().selectList("listperson");
		return listperson;
	}
	
	//�˻��� ��� ��
	@Override
	public int countperson() throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countperson");
	}
	@Override
	public int countsearchperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countsearchperson",personDto);
	}
	
	
	//ȸ�� ���
	@Override
	public void insertperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertperson",personDto);
	}
	
	//ȸ�� ������
	@Override
	public PersonCommand detailsperson(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return (PersonCommand)getSqlSession().selectOne("detailsperson",id);
	}
	
	//ȸ�� ����
	@Override
	public void updateperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updateperson",personDto);
	}
	
	@Override
	public int checkId(String id) {
		int countID=getSqlSession().selectOne("loginperson", id);
		return countID;
	}

}
