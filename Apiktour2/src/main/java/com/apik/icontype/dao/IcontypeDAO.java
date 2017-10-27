package com.apik.icontype.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.apik.icontype.command.IcontypeCommand;

public interface IcontypeDAO {
	//0.회원 검색 (searchicontype)
		public List<IcontypeCommand> searchicontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//1.회원 목록 (listicontype)
		public List<IcontypeCommand> listicontype() throws DataAccessException;
		public int counticontype() throws DataAccessException;
		public int countsearchicontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//3. 회원 등록 (inserticontype)
		public void inserticontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//4. 회원 수정 (updateicontype)
		public void updateicontype(IcontypeCommand icontypeDto) throws DataAccessException;	
		//6. 회원 삭제 (deleteicontype)
		public void deleteicontype(String id) throws DataAccessException;
		//7.회원 상세정보
		public IcontypeCommand detailsicontype(String loctype) throws DataAccessException;
}
