package com.apik.person.service;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;
import com.apik.person.util.PagingUtil;

@Controller
public class ListpersonController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private PersonDAO personDao;
	
	@RequestMapping("/05_admin_m_se.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
            @RequestParam(value="keyField",defaultValue="") String keyField,
            @RequestParam(value="keyWord",defaultValue="") String keyWord) {
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");
			log.debug("currentPage : "+currentPage); //�������� ó������ Ȯ��
			log.debug("keyField : "+keyField);
			log.debug("keyWord : "+keyWord);			
		}

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.
        Map<String,Object>map = new HashMap<String,Object>();
        map.put("keyField", keyField); //map.get("keyField")�� ���� ������ �� �ִ�.
        map.put("keyWord", keyWord);
        //�� ���� 
        int count=personDao.getRowCount(map);
        //����¡ó�� (1.���������� 2.���� 3.���������� ���ڵ尳�� 4.���� �����ִ� ������ ���� 5.��ûurl)
        PagingUtil page=new PagingUtil(currentPage,count,10,10,"listperson.do");
        //list.do�� ��û�� ��������, ���� ���� �����Ѵ�. �� ������ page�� ��´�
        
        //map �߰�
        map.put("start", page.getStartCount()); //#{start}
        map.put("end", page.getEndCount()); //#{end}
        List<PersonCommand> listperson=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
            listperson=personDao.listperson(map); //4���� Ű���� ����
        }else {
            listperson=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_m_se.move");
        mav.addObject("count", count);
        mav.addObject("listperson", listperson);
        mav.addObject("pagingHtml", page.getPagingHtml()); //��ũ���ڿ�(����, ����)
    
        return mav;

	}
}
