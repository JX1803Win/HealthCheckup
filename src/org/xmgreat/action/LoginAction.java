package org.xmgreat.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.UserBean;
import org.xmgreat.biz.UserBiz;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class LoginAction {
	
	@Autowired
    UserBiz userBizImpl;
	
	@RequestMapping(value="/login")
    public String login(HttpServletRequest request, UserBean user){
		System.out.println(user.toString());
		UserBean ub = userBizImpl.login(user.getUsername(),user.getPsw());
		if(ub != null){
			request.setAttribute("user",user);
			return "user/index";
		}else{
			return "user/login";
		}
	}
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request, UserBean user){
		
					return "user/index";
		
		
	}
}
