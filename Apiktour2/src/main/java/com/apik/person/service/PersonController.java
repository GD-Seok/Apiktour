package com.apik.person.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;


@Controller
public class PersonController {
	

	// 1) Log��ü ����
	//private Logger log=Logger.getLogger(ListController.class);
	private Logger log=Logger.getLogger(this.getClass());
	
	
	// Autowired ����Ʈ :  Setter, Getter ȣ�� ����->�ҽ��ڵ带 ����
	@Autowired // �ڵ����� ��ü�� ���ؿ� �ҷ���
	private PersonDAO personDao;
	
	
	// ȸ����� �������� �̵�
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "member/member"; // return "�̵��� ��������"; Ȯ���� ����
	}
	
	// �Է¹������� �ʱ�ȭ->�ٽ� �Է��� ���� �� �ֵ��� ó��
		@ModelAttribute
		public PersonCommand formBacking() {
			return new PersonCommand();
		}

		// 1) /insert.do = action.WriteProAction(post) ����Ŭ��
		// 2) ��ȯ�� ModelAndView : �̵��� ���������� ������ ���� ���� ���
		// 3) String -> intro.do�� �̵� ������
		// 4) params = "�Ű������� ���� ���"

		// ������ �Է�->��ȿ���˻�->�����߻�üũ->DB����->intro.jsp�� �̵�
		@RequestMapping(value="/join.do", method=RequestMethod.POST)
		// �Է¹��� ��, ��ȿ���˼� �����
		public String submit(@Valid PersonCommand personCommand, 
										BindingResult result) {
			
			// �αװ�ü�� ���
			if (log.isDebugEnabled()) {
				log.debug("personCommand=" + personCommand);
			}
			
			
			// ������ �߻��Ͽ� ó������ �ٽ� �Է�
			if (result.hasErrors()) {
				return join();// .jsp�̵�
			}

			if (result.hasErrors()) {
				log.debug("Binding Result has error!");
				List<ObjectError> errors = result.getAllErrors();
				for (ObjectError error : errors) {
					log.debug(error.getDefaultMessage());
				}
				return join();
			}


			
			
			//���������� �Է��� ���
			personDao.insertperson(personCommand);
			
			System.out.println("personCommand : " +personCommand);
			
			//������ �̵�
			return "redirect:/index.do";
		}
		
		

		// �ߺ����̵� �˻�
		 @ResponseBody
		    @RequestMapping(value = "/join/checked.do", method = RequestMethod.POST)
		    public String checkID(HttpServletRequest request, Model model) {
		        String id = request.getParameter("id");
		        System.out.println("�Էµ� id : "+id);
		        int rowcount = personDao.checkId(id);	  
		        System.out.println("rowcount : "+rowcount);
		        return String.valueOf(rowcount);
		    }

		
	
	
	

}
