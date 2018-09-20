package org.xmgreat.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.biz.ParamBiz;

/**
 * @author 宋卓伟
 * @date 2018年9月19日
 * @description 后台参数配置
 */

@Controller
@RequestMapping("/backstage")
public class ParamAction {
	@Resource
	public ParamBiz paramBizImpl;
	public Integer currentPage;
	public Integer totalPage;
	public Integer total;
	
	@RequestMapping(value = "/query.action")
	public String query(HttpServletRequest request, String typeName) {
		if(currentPage == null || request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("当前页："+currentPage);
		request.setAttribute("currentPage", currentPage);
		total = paramBizImpl.countOfSearch(typeName);
		totalPage = (int)Math.ceil((double)total/5);
		System.out.println("总页数："+totalPage);
		request.setAttribute("paramList", paramBizImpl.search(typeName, currentPage));
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		return "backstage/paramConfig";
	}
}
