package org.xmgreat.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.biz.UserBiz;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class JsonAction {
	
	@Resource
	private UserBiz userBizImpl;
	
	@RequestMapping(value="checkUsername")
    @ResponseBody
	public String checkUsername(String username) {
		System.out.println(username);
		if(userBizImpl.queryByUsername(username)) {
			return "true";
		} else {
			return "false";
		}
	}
	
}
