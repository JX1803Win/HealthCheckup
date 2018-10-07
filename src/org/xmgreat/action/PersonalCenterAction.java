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
import org.xmgreat.bean.OfficeBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
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
	public String gopersonal(HttpServletRequest request, Integer page)
	{
		HttpSession session = request.getSession();
		userInfoBean = (UserInfoBean) session.getAttribute("user");
		int userid = userInfoBean.getUserId();
		if (page == null)
		{
			page = 1;
		}
		session.setAttribute("page", page);
		List<UserAccoutBean> accoutlist = userBiz.getAccout(userid, page);
		session.setAttribute("accoutlist", accoutlist);
		return "../personal";
	}

	// 验证原密码是否正确,正确则修改密码
	@RequestMapping(value = "/chengepsw.action")
	@ResponseBody
	public void checkphone(HttpServletRequest request, String initpass, String newpass)
			throws IOException, ClientException
	{
		System.out.println("改密码");
		HttpSession session = request.getSession();
		userInfoBean = (UserInfoBean) session.getAttribute("user");
		Long phone = userInfoBean.getPhone();
		PrintWriter out = response.getWriter();
		String tips;
		List<UserInfoBean> users = userBiz.checkUser(phone, initpass);
		System.out.println(users.size());
		if (users.size() == 0)
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

	// 下一页
	@RequestMapping(value = "/nextpage.action")
	@ResponseBody
	public void nextpage(HttpServletRequest request, Integer page)
	{
		System.out.println(page);
		HttpSession session = request.getSession();
		userInfoBean = (UserInfoBean) session.getAttribute("user");
		int userid = userInfoBean.getUserId();
		session.setAttribute("page", page);
		List<UserAccoutBean> accoutlist = userBiz.getAccout(userid, page);
		session.setAttribute("accoutlist", accoutlist);
	}

	// 进入套餐
	@RequestMapping(value = "/gosetmeal.action")
	public String gosetmeal(HttpServletRequest request,Integer page)
	{
		if(page==null) {
			page=1;
		}
		HttpSession session = request.getSession();
		session.setAttribute("page", page);
		List<SetmealBean> list = userBiz.getSetmeal(page);
		request.setAttribute("list", list);
		return "backstage/Package";
	}

	// 细项
	@RequestMapping(value = "/lookxi.action",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String lookxi(HttpServletRequest request, Integer mid)
	{
		List<ProjectBean> accoutlist = userBiz.getxi(mid);
		Gson gson = new Gson();
		return gson.toJson(accoutlist);
	}
	//查询套餐
	@RequestMapping(value = "/selectmeal.action")
	public String selectmeal(HttpServletRequest request,String name)
	{
		System.out.println(name);
		/*List<SetmealBean> list = userBiz.getSetmeal();
		request.setAttribute("list", list);*/
		return "backstage/Package";
	}

}
