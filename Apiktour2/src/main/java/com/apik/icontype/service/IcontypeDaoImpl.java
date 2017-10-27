package com.apik.icontype.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.icontype.dao.IcontypeDAO;
import com.apik.icontype.command.IcontypeCommand;

public class IcontypeDaoImpl extends SqlSessionDaoSupport implements IcontypeDAO {

	//회원 검색
		@Override
		public List<IcontypeCommand> searchicontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			System.out.println("searchicontype 메소드 실행");
			return getSqlSession().selectList("searchicontype",icontypeDto);
		}
		
		//회원 목록
		@Override
		public List<IcontypeCommand> listicontype() throws DataAccessException {
			// TODO Auto-generated method stub
			List<IcontypeCommand> listicontype=getSqlSession().selectList("listicontype");
			return listicontype;
		}
		
		//검색된 목록 수
		@Override
		public int counticontype() throws DataAccessException {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("counticontype");
		}
		@Override
		public int countsearchicontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("countsearchicontype",icontypeDto);
		}
		
		
		//회원 등록
		@Override
		public void inserticontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().insert("inserticontype",icontypeDto);
		}
		
		//회원 상세정보
		@Override
		public IcontypeCommand detailsicontype(String id) throws DataAccessException {
			// TODO Auto-generated method stub
			return (IcontypeCommand)getSqlSession().selectOne("detailsicontype",id);
		}
		
		//회원 수정
		@Override
		public void updateicontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().update("updateicontype",icontypeDto);
		}
		
		//회원 삭제
		@Override
		public void deleteicontype(String loctype) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteicontype",loctype);
		}
}
