package org.xmgreat.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bizImpl.RoleBizImpl;

import com.google.gson.Gson;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;


@Controller
@RequestMapping("/role")//整体的访问路劲
public class RoleAction {
	@Resource
	public RoleBizImpl roleBizImpl;
	public int pageNo;
	@RequestMapping(value="/blackuserLogin.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllRole (HttpServletRequest request,HttpServletResponse response,String roleName )throws Exception {
		HttpSession session = request.getSession();
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
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
			request.setAttribute("roleName", roleName);
		session.setAttribute("pageNo", pageNo);
		session.setAttribute("AllPage", AllPage);
 	    List<RoleBean> rbList =roleBizImpl.selectAllRoleInfo(roleName,pageNo);
  	    session.setAttribute("rbList", rbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/roleManager");
  	    return mav;
	}
	//删除角色
	@RequestMapping(value="/del.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  dellRole (HttpServletRequest request,HttpServletResponse response,Integer roleId)throws Exception {			   
		roleBizImpl.delManageRole(roleId);
		roleBizImpl.delRole(roleId);
		roleBizImpl.deltblRulePermissions(roleId);
		return selectAllRole(request, response, null);	    
	}
     //添加角色
	@RequestMapping(value="/add.action")//为这个方法定义映射子路劲 	
	public ModelAndView  addRole (HttpServletRequest request,HttpServletResponse response,String roleNames)throws Exception {			   		
		roleBizImpl.addRole(roleNames);
		return selectAllRole(request, response, null);	    
	}
	 //修改角色名
		@RequestMapping(value="/update.action")//为这个方法定义映射子路劲 
		@ResponseBody
		public ModelAndView  updateRole (HttpServletRequest request,HttpServletResponse response,Integer uproleId,String uproleName)throws Exception {			   			
			roleBizImpl.updateRole(uproleId,uproleName);
			return selectAllRole(request, response, null);	    
		}
	//查询角色是否已经存在
		@RequestMapping(value="/testadd.action")//为这个方法定义映射子路劲 
		@ResponseBody						
		public boolean selectRoleAlive(HttpServletRequest request) {
			String roleName=request.getParameter("roleName");
			Boolean bl=roleBizImpl.selectRoleAlive(roleName);
			return bl;
		}
}
