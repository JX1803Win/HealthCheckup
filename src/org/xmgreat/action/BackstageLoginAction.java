package org.xmgreat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.biz.AdminBiz;

@Controller
@RequestMapping("/admin")
@Scope("prototype")
public class BackstageLoginAction
{
	@Autowired
	private AdminBiz adminBiz;
    
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,HttpServletResponse response, ManagerBean managerBean, String verification)
	{
		
		//通过角色查询动态菜单
		int roleId=1;
		HttpSession session = request.getSession();		
		List<PermissionsInfBean> pibList=adminBiz.selectRoleInfo(roleId);
		session.setAttribute("pibList", pibList);
		return "backstage/index";
	}

}
