package org.xmgreat.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.biz.AdminBiz;

@Controller
@RequestMapping("/admin")
@Scope("prototype")
public class BackstageLoginAction
{
	@Autowired
	private AdminBiz adminBiz;

	@RequestMapping(value = "/login.action")
	public String login(HttpServletRequest request, ManagerBean managerBean, String verification)
	{
		return "backstage/index";
	}

}
