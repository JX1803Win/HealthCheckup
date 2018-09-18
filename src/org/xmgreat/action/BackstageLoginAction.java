package org.xmgreat.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, PrintWriter out, ManagerBean managerBean, String verification)
	{
		String keyCode = request.getSession().getAttribute("keyCode").toString();
		System.out.println(keyCode + " " + verification);
		if (verification.equals(keyCode))
		{
//			ManagerBean admin = adminBiz.login(managerBean.getMangerName(), managerBean.getPassword());
//			if (admin != null)
//			{
//				request.setAttribute("admin", admin);
//
//			} else
//			{
//
//			}

			System.out.println(out);
			out.write("index.jsp");

		} else
		{
			out.write("验证码错误");
		}
	}

	@RequestMapping("/name")
	public String sayHello()
	{
		return "name";
	}

}
