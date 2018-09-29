package org.xmgreat.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.biz.BackLogBiz;

import com.google.gson.Gson;

@Controller
@RequestMapping("/backstage")
@Scope("prototype")
public class BackstageLoginAction
{
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private AdminBiz adminBiz;
	@Autowired
	private BackLogBiz backLogBiz;
	@Resource
	private ManagerBean managerBean;
    
	@RequestMapping(value = "/login")
	@ResponseBody
	public void login(HttpServletRequest request,String mangerName,String password, String verification) throws IOException
	{
		System.out.println(mangerName+password+verification);
		PrintWriter out = response.getWriter();
		String tips;
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("keyCode");
		managerBean=backLogBiz.checkBackLog(mangerName, password);
		if(managerBean==null||!(code.equals(verification))) {
			tips = "错误";
			Gson gson = new Gson();
			String str = gson.toJson(tips);
			out.print(str);
			out.close();
		}else {
			//通过角色查询动态菜单
			int roleId=managerBean.getRoleId();
			List<PermissionsInfBean> pibList=adminBiz.selectRoleInfo(roleId);
			session.setAttribute("pibList", pibList);
		}

	}
	
	@RequestMapping(value = "/index.action")
	public String index(HttpServletRequest request,String mangerName,String password, String verification) throws IOException
	{
		return "backstage/index";
	}
}
