package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.biz.DetailBiz;
import org.xmgreat.util.Data;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 后台细项配置
 */

@Controller
@RequestMapping("/detail")
public class DetailAction
{
	@Resource
	private DetailBiz detailBiz;
	private Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, String name, Integer currentPage)
	{
		if (currentPage == null)
		{
			currentPage = 1;
		}
		int max = currentPage * Data.NUM + 1;
		int min = (currentPage - 1) * Data.NUM;
		condition.put("max", max);
		condition.put("min", min);
		if (null != name && !"".equals(name))
		{
			condition.put("detailName", "%" + name + "%");
		}
		resultMap = detailBiz.search(condition);
		resultMap.put("currentPage", currentPage);
		resultMap.put("name", name);
		request.setAttribute("resultMap", resultMap);
		return "backstage/detail";
	}
}
