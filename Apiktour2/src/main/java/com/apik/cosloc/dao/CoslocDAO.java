package com.apik.cosloc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.apik.cosloc.command.CoslocCommand;

public interface CoslocDAO {
	//0.ȸ�� �˻� (searchcosloc)
		public List<CoslocCommand> searchcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//1.ȸ�� ��� (listcosloc)
		public List<CoslocCommand> listcosloc() throws DataAccessException;
		public int countcosloc() throws DataAccessException;
		public int countsearchcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//3. ȸ�� ��� (insertcosloc)
		public void insertcosloc(CoslocCommand coslocDto) throws DataAccessException;
		//4. ȸ�� ���� (updatecosloc)
		public void updatecosloc(CoslocCommand coslocDto) throws DataAccessException;	
		//6. ȸ�� ���� (deletecosloc)
		public void deletecosloc(CoslocCommand coslocDto) throws DataAccessException;
		//7.ȸ�� ������
		public CoslocCommand detailscosloc(CoslocCommand coslocDto) throws DataAccessException;
}
