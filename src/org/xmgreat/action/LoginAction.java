package org.xmgreat.action;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.biz.AdminBiz;

@Controller
@RequestMapping("/user")
public class LoginAction
{
	@Autowired
	private AdminBiz adminBiz;

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, String uname,String psw)
	{
		System.out.println(uname);
		return "backstage/index";
	}

}
