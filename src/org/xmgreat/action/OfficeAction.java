package org.xmgreat.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.bean.OfficeBean;
import org.xmgreat.biz.OfficeBiz;

@Controller
@RequestMapping("/backstage")
public class OfficeAction
{
	@Autowired
	private OfficeBiz officeBiz;
	@Resource
	private OfficeBean officeBean;

	@RequestMapping(value = "/office.action")
	public String office(HttpServletRequest request,String name, Integer page)
	{
		if (page == null)
		{
			page = 1;
		}
		HttpSession session = request.getSession();
		session.setAttribute("pageNo", page);
		session.setAttribute("AllPage", 2);
		session.setAttribute("name", name);
		List<OfficeBean> list = officeBiz.getOffice(page);
		request.setAttribute("list", list);
		return "backstage/officeManager";
	}

	@RequestMapping(value = "/del.action")
	@ResponseBody
	public void del(HttpServletRequest request,Integer officeid)
	{
		officeBiz.updOffice(officeid);
		officeBiz.delOffice(officeid);
	}
	
	@RequestMapping(value = "/change.action")
	@ResponseBody
	public void change(HttpServletRequest request,Integer uproleId,String uproleName)
	{
		officeBiz.changeOfficeName(uproleName, uproleId);
		
	}
	
	@RequestMapping(value = "/addoffice.action")
	@ResponseBody
	public void addoffice(HttpServletRequest request,String officename)
	{
		officeBiz.addOffice(officename);
		
	}
	
	@RequestMapping(value = "/selectoffice.action")
	public String selectoffice(HttpServletRequest request,String name, Integer page)
	{
		if (page == null)
		{
			page = 1;
		}
		HttpSession session = request.getSession();
		session.setAttribute("pageNo", page);
		session.setAttribute("AllPage", 2);
		session.setAttribute("name", name);
		List<OfficeBean> list = officeBiz.selectOffice(page, name);
		request.setAttribute("list", list);
		return "backstage/officeManager";
	}
	
	
}
