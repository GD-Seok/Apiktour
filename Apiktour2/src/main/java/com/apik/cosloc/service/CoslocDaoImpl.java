package com.apik.cosloc.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.cosloc.dao.CoslocDAO;
import com.apik.cosloc.command.CoslocCommand;

public class CoslocDaoImpl extends SqlSessionDaoSupport implements CoslocDAO {
	//�ڽ� ���� �˻�
		@Override
		public List<CoslocCommand> searchcosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			System.out.println("searchcosloc �޼ҵ� ����");
			return getSqlSession().selectList("searchcosloc",coslocDto);
		}
		
		//�ڽ� ���� ���
		@Override
		public List<CoslocCommand> listcosloc() throws DataAccessException {
			// TODO Auto-generated method stub
			List<CoslocCommand> listcosloc=getSqlSession().selectList("listcosloc");
			return listcosloc;
		}
		
		//�˻��� ��� ��
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
		
		
		//�ڽ� ���� ���
		@Override
		public void insertcosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertcosloc",coslocDto);
		}
		
		//�ڽ� ���� ������
		@Override
		public CoslocCommand detailscosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			return (CoslocCommand)getSqlSession().selectOne("detailscosloc",coslocDto);
		}
		
		//�ڽ� ���� ����
		@Override
		public void updatecosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().update("updatecosloc",coslocDto);
		}
		
		//�ڽ� ���� ����
		@Override
		public void deletecosloc(CoslocCommand coslocDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().delete("deletecosloc",coslocDto);
		}
}
