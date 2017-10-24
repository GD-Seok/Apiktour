package com.apik.person.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;

//Person Table�� ����ϴ� ��� ��� ���
public interface PersonDAO {
	
	//1.ȸ�� �˻� (listperson)
	public List<PersonCommand> listperson(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	//2. ȸ�� �α��� (loginperson)
	//3. ȸ�� ��� (insertperson)
	public void insertperson(PersonCommand personDto) throws DataAccessException;
	//4. ȸ�� ���� (updateperson)
	//5. ȸ�� ��й�ȣ ���� (updatepersonpasswd)
	//6. ȸ�� ���� (deleteperson)

	//7. checked id
	public int checkId(String id);
	
}
