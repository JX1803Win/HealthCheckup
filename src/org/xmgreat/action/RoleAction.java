package org.xmgreat.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bizImpl.RoleBizImpl;


@Controller
@RequestMapping("/role")//整体的访问路劲
public class RoleAction {
	@Resource
	public RoleBizImpl roleBizImpl;
	/*public int pageNo;*/
	@RequestMapping(value="/blackuserLogin.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllRole (HttpServletRequest request,HttpServletResponse response,String roleName ,Integer pageNo)throws Exception {
		HttpSession session = request.getSession();
		
		int size=roleBizImpl.getRoleNum(roleName);
		session.setAttribute("sizeL", size);
  	    int AllPage = 0;
			if (size % 3 != 0) {
				AllPage = (size / 3) + 1;
			} else {
				AllPage = (size / 3);
			}			
			if (0 == pageNo) {
				pageNo = 1;
			} else {				
				if (pageNo < 1) {
					pageNo = 1;
				} else if (pageNo > AllPage) {
					pageNo = AllPage;
				}
			}  
		session.setAttribute("pageNo", pageNo);
		session.setAttribute("AllPage", AllPage);
 	    List<RoleBean> rbList =roleBizImpl.selectAllRoleInfo(roleName,pageNo);
  	    session.setAttribute("rbList", rbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/roleManager");
  	    return mav;
	}
	@RequestMapping(value="/addrole.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView addRole (HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession(); 	   
// 	    List<RoleBean> rbList =roleBizImpl.selectAllRoleInfo();
//  	    session.setAttribute("rbList", rbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/roleManager");
  	    return mav;
	}
     
}
