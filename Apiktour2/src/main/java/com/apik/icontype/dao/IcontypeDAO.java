package com.apik.icontype.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.apik.icontype.command.IcontypeCommand;

public interface IcontypeDAO {
	//0.ȸ�� �˻� (searchicontype)
		public List<IcontypeCommand> searchicontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//1.ȸ�� ��� (listicontype)
		public List<IcontypeCommand> listicontype() throws DataAccessException;
		public int counticontype() throws DataAccessException;
		public int countsearchicontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//3. ȸ�� ��� (inserticontype)
		public void inserticontype(IcontypeCommand icontypeDto) throws DataAccessException;
		//4. ȸ�� ���� (updateicontype)
		public void updateicontype(IcontypeCommand icontypeDto) throws DataAccessException;	
		//6. ȸ�� ���� (deleteicontype)
		public void deleteicontype(String id) throws DataAccessException;
		//7.ȸ�� ������
		public IcontypeCommand detailsicontype(String loctype) throws DataAccessException;
}
