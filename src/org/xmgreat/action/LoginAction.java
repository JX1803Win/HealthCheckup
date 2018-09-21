package org.xmgreat.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.UserBiz;

import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class LoginAction
{
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletConfig config;
	@Autowired
	private ServletContext sevletContext;
	@Autowired
	private UserBiz userBiz;
	@Resource
	private UserInfoBean userInfoBean;
	//验证前台登入
	@RequestMapping(value = "/login.action")
	public String login(HttpServletRequest request, String phone, String password)
	{
		List<UserInfoBean> users = userBiz.checkUser(Long.parseLong(phone), password);
		if (users.size() != 0)
		{
			return "backstage/index";
		} else
		{
			System.out.println("登入失败");
			return "UserLoginAndReg.jsp";
		}

	}
	//验证手机号
	@RequestMapping(value = "/reg.action")
	@ResponseBody
	public void reg(HttpServletRequest request, String phone) throws IOException
	{
		PrintWriter out = response.getWriter();
		System.out.println(phone);
		String tips;
		userInfoBean =  userBiz.checkPhone(Long.parseLong(phone));
		if(userInfoBean!=null) {
			tips="否";
		}else { 
			tips="可";
		}
		Gson gson = new Gson();
		String str = gson.toJson(tips);
		out.print(str);
		out.close();
	}

}
