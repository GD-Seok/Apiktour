package com.apik.cosloc.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.cosloc.dao.CoslocDAO;
import com.apik.cosloc.command.CoslocCommand;

public class CoslocDaoImpl extends SqlSessionDaoSupport implements CoslocDAO {
	//코스 정보 검색
		@Override
		public List<CoslocCommand> searchcosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			System.out.println("searchcosloc 메소드 실행");
			return getSqlSession().selectList("searchcosloc",coslocDto);
		}
		
		//코스 정보 목록
		@Override
		public List<CoslocCommand> listcosloc() throws DataAccessException {
			// TODO Auto-generated method stub
			List<CoslocCommand> listcosloc=getSqlSession().selectList("listcosloc");
			return listcosloc;
		}
		
		//검색된 목록 수
		@Override
		public int countcosloc() throws DataAccessException {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("countcosloc");
		}
		@Override
		public int countsearchcosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("countsearchcosloc",coslocDto);
		}
		
		
		//코스 정보 등록
		@Override
		public void insertcosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertcosloc",coslocDto);
		}
		
		//코스 정보 상세정보
		@Override
		public CoslocCommand detailscosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			return (CoslocCommand)getSqlSession().selectOne("detailscosloc",coslocDto);
		}
		
		//코스 정보 수정
		@Override
		public void updatecosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().update("updatecosloc",coslocDto);
		}
		
		//코스 정보 삭제
		@Override
		public void deletecosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().delete("deletecosloc",coslocDto);
		}
}
