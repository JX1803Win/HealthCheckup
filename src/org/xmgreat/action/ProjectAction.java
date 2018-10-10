package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.annotation.SystemLog;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.biz.ProjectBiz;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 后台细项配置
 */

@Controller
@RequestMapping("/backstage")
public class ProjectAction
{
	@Resource
	private ProjectBiz projectBiz;
	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/queryProject")
	public String queryProject(HttpServletRequest request, String name, Integer currentPage)
	{
		Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
		if (currentPage == null)
		{
			currentPage = 1;
		}
		condition.put("currentPage", currentPage);
		if (null != name && !"".equals(name))
		{
			condition.put("itemName", "%" + name + "%");
		}
		resultMap = projectBiz.search(condition);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", resultMap);
		return "backstage/project";
	}

	@RequestMapping(value = "/checkProject1")
	@ResponseBody
	public boolean checkProject1(String itemName)
	{
		boolean mag = true;
		if (null != projectBiz.checkProject1(itemName))
		{
			mag = false;
		}
		return mag;
	}

	@RequestMapping(value = "/checkProject")
	public String checkProject(HttpServletRequest request, Integer projectId, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("project", projectBiz.getProject(projectId));
		return "backstage/projectDetail";
	}

	@RequestMapping(value = "/addProject")
	public String addProject(HttpServletRequest request, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", projectBiz.skipAddProject());
		return "backstage/addproject";
	}

	@RequestMapping(value = "/affirmAdd")
	@SystemLog(module = "系统管理", methods = "项目管理，新增项目")
	public String affirmAdd(HttpServletRequest request, ProjectBean projectBean, Integer[] subentryId, String name,
			Integer currentPage)
	{
		projectBiz.addProject(projectBean, subentryId);
		return queryProject(request, name, currentPage);
	}

	@RequestMapping(value = "/updateProject")
	public String updateProject(HttpServletRequest request, Integer projectId, String name, Integer currentPage)
	{
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("name", name);
		request.setAttribute("resultMap", projectBiz.skipUpdateProject(projectId));
		return "backstage/updateProject";
	}

	@RequestMapping(value = "/affirmUpdate")
	@SystemLog(module = "系统管理", methods = "项目管理，更新项目")
	public String affirmUpdate(HttpServletRequest request, ProjectBean projectBean, Integer[] subentryId, String name,
			Integer currentPage)
	{
		projectBiz.updateProject(projectBean, subentryId);
		return queryProject(request, name, currentPage);
	}

	@RequestMapping(value = "/delProject")
	@SystemLog(module = "系统管理", methods = "项目管理，删除项目")
	public String delProject(HttpServletRequest request, Integer projectId, String name, Integer currentPage)
	{
		projectBiz.delProject(projectId);
		return queryProject(request, name, currentPage);
	}

}
