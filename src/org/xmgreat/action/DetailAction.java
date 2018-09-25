package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.DetailBean;
import org.xmgreat.biz.DetailBiz;
import org.xmgreat.util.Data;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 后台细项配置
 */

@Controller
@RequestMapping("/backstage")
public class DetailAction
{
	@Resource
	private DetailBiz detailBiz;
	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/queryDetail")
	public String queryDetail(HttpServletRequest request, String name, Integer currentPage)
	{
		Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
		if (currentPage == null)
		{
			currentPage = 1;
		}
		condition.put("currentPage", currentPage);
		if (null != name && !"".equals(name))
		{
			condition.put("detailName", "%" + name + "%");
		}
		resultMap = detailBiz.search(condition);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", resultMap);
		return "backstage/detail";
	}

	@RequestMapping(value = "/addDetail")
	public String addDetail(HttpServletRequest request, DetailBean detailBean, String name, Integer currentPage)
	{
		detailBiz.addDetail(detailBean);
		return queryDetail(request, name, currentPage);
	}

	@RequestMapping(value = "/updateDetail")
	public String updateDetail(HttpServletRequest request, DetailBean detailBean, String name, Integer currentPage)
	{
		detailBiz.updateDetail(detailBean);
		return queryDetail(request, name, currentPage);
	}

	@RequestMapping(value = "/delDetail")
	public String delDetail(HttpServletRequest request, Integer subentryId, String name, Integer currentPage)
	{
		detailBiz.delDetail(subentryId);
		return queryDetail(request, name, currentPage);
	}

}
