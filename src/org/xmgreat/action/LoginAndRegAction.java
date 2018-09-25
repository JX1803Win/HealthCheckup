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
import org.xmgreat.util.PhoneCode;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class LoginAndRegAction
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
	PhoneCode phonecode = new PhoneCode();
	int racode = (int) ((Math.random()*9+1)*100000);//随机生成的验证码
	// 验证前台登入
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

	// 验证手机号是否被注册
	@RequestMapping(value = "/checkphone.action")
	@ResponseBody
	public void checkphone(HttpServletRequest request, String phone) throws IOException, ClientException
	{
		PrintWriter out = response.getWriter();
		String tips;
		userInfoBean = userBiz.checkPhone(Long.parseLong(phone));
		if (userInfoBean != null)
		{
			tips = "否";
			Gson gson = new Gson();
			String str = gson.toJson(tips);
			out.print(str);
			out.close();
		}else {
			phonecode.RegCode(phone, racode);//发送手机验证码
		}
	}
	// 验证验证码是否正确,如果正确则当场注册
		@RequestMapping(value = "/reg.action")
		@ResponseBody
		public void reg(HttpServletRequest request, String usersname,String pass,String phone,String code) throws IOException {
			System.out.println(usersname+pass+phone+code);
			String tips;
			PrintWriter out = response.getWriter();
			int a = Integer.parseInt(code);
			if(a!=racode) {
				tips = "验证码错误";
				Gson gson = new Gson();
				String str = gson.toJson(tips);
				out.print(str);
				out.close();
			}else {
				userBiz.reg(usersname, Long.parseLong(phone), pass);
			}
			
		}
	
	
	
	
}
