package com.apik.icontype.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.icontype.dao.IcontypeDAO;
import com.apik.icontype.command.IcontypeCommand;

public class IcontypeDaoImpl extends SqlSessionDaoSupport implements IcontypeDAO {

	//ȸ�� �˻�
		@Override
		public List<IcontypeCommand> searchicontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			System.out.println("searchicontype �޼ҵ� ����");
			return getSqlSession().selectList("searchicontype",icontypeDto);
		}
		
		//ȸ�� ���
		@Override
		public List<IcontypeCommand> listicontype() throws DataAccessException {
			// TODO Auto-generated method stub
			List<IcontypeCommand> listicontype=getSqlSession().selectList("listicontype");
			return listicontype;
		}
		
		//�˻��� ��� ��
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
		
		
		//ȸ�� ���
		@Override
		public void inserticontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().insert("inserticontype",icontypeDto);
		}
		
		//ȸ�� ������
		@Override
		public IcontypeCommand detailsicontype(String id) throws DataAccessException {
			// TODO Auto-generated method stub
			return (IcontypeCommand)getSqlSession().selectOne("detailsicontype",id);
		}
		
		//ȸ�� ����
		@Override
		public void updateicontype(IcontypeCommand icontypeDto) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().update("updateicontype",icontypeDto);
		}
		
		//ȸ�� ����
		@Override
		public void deleteicontype(String loctype) throws DataAccessException {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteicontype",loctype);
		}
}
