package com.apik.person.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;

//Person Table을 사용하는 모든 기능 등록
public interface PersonDAO {
	
	//1.회원 검색 (listperson)
	public List<PersonCommand> listperson() throws DataAccessException;;
	public int countperson() throws DataAccessException;
	//2. 회원 로그인 (loginperson)
	//3. 회원 등록 (insertperson)
	public void insertperson(PersonCommand personDto) throws DataAccessException;
	//4. 회원 수정 (updateperson)
	//5. 회원 비밀번호 변경 (updatepersonpasswd)
	//6. 회원 삭제 (deleteperson)

	//7. checked id
	public int checkId(String id);
	
}
