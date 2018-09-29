package org.xmgreat.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.xmgreat.util.AgeByBirth;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;

@Controller
@RequestMapping("/user")
public class PersonalCenterAction
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

	// 进入个人中心
		@RequestMapping(value = "/gopersonal.action")
		public String login(HttpServletRequest request, String phone, String psw)
		{
			System.out.println("in");
				return "../personal";
		}

	
	// 验证原密码是否正确,正确则修改密码
	@RequestMapping(value = "/chengepsw.action")
	@ResponseBody
	public void checkphone(HttpServletRequest request, String initpass, String newpass)
			throws IOException, ClientException
	{
		HttpSession session = request.getSession();
		userInfoBean = (UserInfoBean) session.getAttribute("user");
		Long phone = userInfoBean.getPhone();
		PrintWriter out = response.getWriter();
		String tips;
		List<UserInfoBean> users = userBiz.checkUser(phone, initpass);
		if (!(users.size() == 0))
		{
			tips = "否";
			Gson gson = new Gson();
			String str = gson.toJson(tips);
			out.print(str);
			out.close();
		} else
		{
			userBiz.forGotPwd(phone, newpass);
		}
	}

	// 修改个人资料
	@RequestMapping(value = "/chengeinfo.action")
	@ResponseBody
	public void chengeinfo(HttpServletRequest request, String sex, String phone, String blood, String dizhi,
			String selYear, String selMonth, String selDay) throws IOException, ClientException, ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String birth = selYear + "-" + selMonth + "-" + selDay;
		Date bithday = format.parse(birth);
		AgeByBirth Birth = new AgeByBirth();
		int age = Birth.getAgeByBirth(bithday);
		userBiz.changeInfo(sex, age, birth, blood, dizhi, Long.parseLong(phone));

	}
}
