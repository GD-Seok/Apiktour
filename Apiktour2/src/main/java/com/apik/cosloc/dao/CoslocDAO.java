package com.apik.cosloc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.apik.cosloc.command.CoslocCommand;

public interface CoslocDAO {
	//0.회원 검색 (searchcosloc)
		public List<CoslocCommand> searchcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//1.회원 목록 (listcosloc)
		public List<CoslocCommand> listcosloc() throws DataAccessException;
		public int countcosloc() throws DataAccessException;
		public int countsearchcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//3. 회원 등록 (insertcosloc)
		public void insertcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//4. 회원 수정 (updatecosloc)
		public void updatecosloc(CoslocCommand coslocDto) throws DataAccessException;	
		//6. 회원 삭제 (deletecosloc)
		public void deletecosloc(CoslocCommand coslocDto) throws DataAccessException;
		//7.회원 상세정보
		public CoslocCommand detailscosloc(CoslocCommand coslocDto) throws DataAccessException;
}
