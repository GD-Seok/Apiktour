package com.apik.person.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDAO {
	
	//ȸ�� ��� �˻�
	@Override
	public List<PersonCommand> listperson(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<PersonCommand> listperson=getSqlSession().selectList("listperson",map);
		return listperson;
	}
	//�˻��� �ʿ��� ����¡ ó��
	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCount", map);
	}
	
	//ȸ�� ���
	@Override
	public void insertperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertperson",personDto);
	}

}
