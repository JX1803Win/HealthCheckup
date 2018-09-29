package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.biz.SetmealBiz;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 后台细项配置
 */

@Controller
@RequestMapping("/backstage")
public class SetmealAction
{
	@Resource
	private SetmealBiz setmealBiz;
	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/querySetmeal")
	public String querySetmeal(HttpServletRequest request, String name, Integer currentPage)
	{
		Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
		if (currentPage == null)
		{
			currentPage = 1;
		}
		condition.put("currentPage", currentPage);
		if (null != name && !"".equals(name))
		{
			condition.put("setmealName", "%" + name + "%");
		}
		resultMap = setmealBiz.search(condition);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", resultMap);
		return "backstage/setmeal";
	}

	@RequestMapping(value = "/checkSetmeal")
	public String checkSetmeal(HttpServletRequest request, Integer setmealId, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("setmeal", setmealBiz.getSetmeal(setmealId));
		return "backstage/setmealDetail";
	}

	@RequestMapping(value = "/addSetmeal")
	public String addSetmeal(HttpServletRequest request, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("projects", setmealBiz.skipAddSetmeal());
		return "backstage/addSetmeal";
	}

	@RequestMapping(value = "/affirmAddSetmeal")
	public String affirmAddSetmeal(HttpServletRequest request, SetmealBean setmealBean, Integer[] projectId,
			String name, Integer currentPage)
	{
		setmealBiz.addSetmeal(setmealBean, projectId);
		return querySetmeal(request, name, currentPage);
	}

	@RequestMapping(value = "/updateSetmeal")
	public String updateSetmeal(HttpServletRequest request, Integer setmealId, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", setmealBiz.skipUpdateSetmeal(setmealId));
		return "backstage/updateSetmeal";
	}

	@RequestMapping(value = "/affirmUpdateSetmeal")
	public String affirmUpdateSetmeal(HttpServletRequest request, SetmealBean setmealBean, Integer[] projectId,
			String name, Integer currentPage)
	{
		setmealBiz.updateSetmeal(setmealBean, projectId);
		return querySetmeal(request, name, currentPage);
	}

	@RequestMapping(value = "/delSetmeal")
	public String delSetmeal(HttpServletRequest request, Integer setmealId, String name, Integer currentPage)
	{
		setmealBiz.delSetmeal(setmealId);
		return querySetmeal(request, name, currentPage);
	}

}
