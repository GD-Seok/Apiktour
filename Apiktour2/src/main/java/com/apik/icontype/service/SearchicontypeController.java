package com.apik.icontype.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.icontype.command.IcontypeCommand;
import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class SearchicontypeController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	IcontypeDAO icontypeDao;

	@RequestMapping("/admin/searchicontype.do")
	public ModelAndView searchprocess(@RequestParam("keyField") String keyField,
															@RequestParam("keyWord") String keyWord) throws Exception{
		System.out.println("ȸ�� ��� �˻� SearchicontypeController ����!");
		
        IcontypeCommand icontypeDto = new IcontypeCommand();
        icontypeDto.setKeyField(keyField);
        icontypeDto.setKeyWord(keyWord);
        
		//�� ���� 
        int count=icontypeDao.countsearchicontype(icontypeDto);
        System.out.println("�˻��� icontype table�� count �� : "+count);
        
		List<IcontypeCommand> listicontype=null;
						
		if(count > 0) {			
            listicontype=icontypeDao.searchicontype(icontypeDto);
        }else {
            listicontype=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName("icontype/05_admin_icon_se.move");
        mav.addObject("count", count);
        mav.addObject("listicontype", listicontype);
		
		return mav;
	}
}
