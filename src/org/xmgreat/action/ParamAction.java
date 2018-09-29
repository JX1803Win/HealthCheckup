package org.xmgreat.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.biz.ParamBiz;

/**
 * @author 宋卓伟
 * @date 2018年9月19日
 * @description 后台参数配置
 */

@Controller
@RequestMapping("/ParamAction")
public class ParamAction {
	@Resource
	private ParamBiz paramBizImpl;
	private Integer currentPage;
	private Integer totalPage;
	private Integer total;
	@Resource
	private ParameterBean parameterBean;
	/**
	 * @description 查询参数列表
	 * @param request 请求
	 * @param typeName 参数类型
	 * @return 参数配置页面
	 */
	@RequestMapping(value = "/query.action")
	public String query(HttpServletRequest request, String typeName) {
		System.out.println(typeName);
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
	
	/**
	 * @description 查询所有参数类型
	 * @return 参数类型列表
	 */
	@RequestMapping(value = "/queryAllTypeName.action")
	public @ResponseBody List<ParameterBean> queryAllTypeName() {
		return paramBizImpl.queryAllTypeName();
	}
	
	/**
	 * @description 添加参数
	 * @param request 请求
	 * @return 参数配置页面
	 */
	@RequestMapping(value = "/add.action")
	public String add(HttpServletRequest request) {
		String typeName = request.getParameter("typeName2");
		System.out.println(typeName);
		parameterBean.setParameterType(Integer.parseInt(typeName));
		String parameterName = request.getParameter("parameterName");
		System.out.println(parameterName);
		parameterBean.setParameterName(parameterName);
		String parameterValues = request.getParameter("parameterValues");
		System.out.println(parameterValues);
		parameterBean.setParameterValues(parameterValues);
		paramBizImpl.addParam(parameterBean);
		return query(request, null);
	}
	
	/**
	 * @description 删除参数
	 * @param request 请求
	 * @return 参数配置页面
	 */
	@RequestMapping(value = "/del.action")
	public String del(HttpServletRequest request) {
		paramBizImpl.del(Integer.parseInt(request.getParameter("parameterId")));
		return query(request, null);
	}
	
	/**
	 * @description 添加参数
	 * @param request 请求
	 * @return 参数配置页面
	 */
	@RequestMapping(value = "/alter.action")
	public String alter(HttpServletRequest request) {
		System.out.println(request.getParameter("parameterId1"));
		Integer parameterId = Integer.parseInt(request.getParameter("parameterId1"));
		System.out.println(parameterId);
		parameterBean.setParameterId(parameterId);
		String parameterName = request.getParameter("parameterName1");
		System.out.println(parameterName);
		parameterBean.setParameterName(parameterName);
		String parameterValues = request.getParameter("parameterValues1");
		System.out.println(parameterValues);
		parameterBean.setParameterValues(parameterValues);
		paramBizImpl.alterParam(parameterBean);
		return query(request, null);
	}
}
