package org.xmgreat.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.UserBiz;

@Controller
@RequestMapping("/user")
public class LoginAction
{
	@Autowired
	private UserBiz userBiz;
	@Resource
	private UserInfoBean userInfoBean;
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, String phone,String password)
	{
		List<UserInfoBean> users = userBiz.checkUser(Long.parseLong(phone),password);
		if (users.size() != 0) {
			return "backstage/index";
		}else {
			System.out.println("登入失败");
			return "UserLoginAndReg.jsp";
		}
		
	}

}
