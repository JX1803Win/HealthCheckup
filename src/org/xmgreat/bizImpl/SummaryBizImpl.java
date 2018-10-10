package org.xmgreat.bizImpl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.xmgreat.bean.DetailBean;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SubentryBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.mapper.DetailMapper;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.ProjectResultMapper;
import org.xmgreat.mapper.ProjectlMapper;
import org.xmgreat.mapper.SubentryMapper;
import org.xmgreat.util.Data;

@Service
public class SummaryBizImpl implements SummaryBiz
{

	@Resource
	private ProjectlMapper projectlMapper;
	@Resource
	private ParamMapper paramMapper;
	@Resource
	private SubentryMapper subentryMapper;
	@Resource
	private ProjectResultMapper projectResultMapper;
	@Resource
	private DetailMapper detailMapper;

	public Integer totalPage;
	public Integer total;
	private Map<String, Object> resultMap = new HashMap<String, Object>();

	@Override
	public ProjectBean skipExamination(Integer projectId)
	{
		ProjectBean project = projectlMapper.getProject(projectId);
		for (int i = 0; i < project.getDetails().size(); i++)
		{
			if(null != project.getDetails().get(i).getParameterId()){
				ParameterBean parameter = paramMapper.getParameter(project.getDetails().get(i).getParameterId());
				project.getDetails().get(i).setParameterBean(parameter);
			}
		}
		return project;
	}

	@Override
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult,
			Integer parameterId)
	{

		if (null != subentryId)
		{
			for (int i = 0; i < subentryId.length; i++)
			{
				subentryMapper
						.addSubentry(new SubentryBean(null, subentryId[i], result[i], null, proresId, null, null));
			}

		}
		ProjectResultBean projectResultBean = projectResultMapper.getProjectResult(proresId);
		projectResultBean.setParameterId(parameterId);
		if (null != projectResult)
		{
			projectResultBean.setProjectResult(projectResult);
		}
		projectResultMapper.updateProjectResul(projectResultBean);

	}

	@Override
	public ProjectResultBean skipSummary(Integer proresId)
	{
		ProjectResultBean projectResultBean = projectResultMapper.getProjectResult(proresId);
		List<SubentryBean> subentrys = projectResultBean.getSubentrys();
		for (int i = 0; i < subentrys.size(); i++)
		{
			DetailBean detailBean = detailMapper.getDetail(subentrys.get(i).getSubentryId());
			projectResultBean.getSubentrys().get(i).setDetail(detailBean);
		}
		return projectResultBean;
	}

	@Override
	public void projectSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult,
			Integer parameterId)
	{
		if (null != subentryId)
		{
			for (int i = 0; i < subentryId.length; i++)
			{
				String hint = null;
				DetailBean detailBean = detailMapper.getDetail(subentryId[i]);
				if (null != detailBean.getLowerLimit())
				{
					if (Double.valueOf(result[i]) < detailBean.getLowerLimit())
					{
						hint = "偏低";
					}
				}
				if (null != detailBean.getUpperLimit())
				{
					if (Double.valueOf(result[i]) > detailBean.getUpperLimit())
					{
						hint = "偏高";
					}
				}
				subentryMapper
						.addSubentry(new SubentryBean(null, subentryId[i], result[i], hint, proresId, null, null));
			}

		}
		ProjectResultBean projectResultBean = projectResultMapper.getProjectResult(proresId);
		projectResultBean.setParameterId(parameterId);
		if (null != projectResult)
		{
			projectResultBean.setProjectResult(projectResult);
		}
		projectResultMapper.updateProjectResul(projectResultBean);

	}

	@Override
	public void imageSummary(Integer proresId, Integer[] subentryId, HttpServletRequest request, String projectResult,
			Integer parameterId) throws IllegalStateException, IOException
	{
		// TODO Auto-generated method stub
		String root = request.getSession().getServletContext().getRealPath("/upload/"); // 设置文件上传的路径
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request))
		{
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();
			if (null != subentryId)
			{
				int i = 0;
				while (iter.hasNext())
				{
					// 一次遍历所有文件
					MultipartFile file = multiRequest.getFile(iter.next().toString());
					String fileName = null;
					if (file != null)
					{
						fileName = file.getOriginalFilename();
						String path = root + fileName;
						// 上传
						file.transferTo(new File(path));
						subentryMapper.addSubentry(new SubentryBean(null, subentryId[i], "upload/" + fileName, null,
								proresId, null, null));
					}
					i++;
				}
			}
		}
		ProjectResultBean projectResultBean = projectResultMapper.getProjectResult(proresId);
		projectResultBean.setParameterId(parameterId);
		if (null != projectResult)
		{
			projectResultBean.setProjectResult(projectResult);
		}
		projectResultMapper.updateProjectResul(projectResultBean);
	}

	@Override
	public Map<String, Object> querySummary(Map<String, Object> condition)
	{
		total = projectResultMapper.count(condition);
		resultMap.put("total", total);
		if (total % Data.NUM == 0)
		{
			totalPage = total / Data.NUM;
		} else
		{
			totalPage = total / Data.NUM + 1;
		}
		if (totalPage == 0)
		{
			totalPage = 1;
		}
		resultMap.put("totalPage", totalPage);
		Integer currentPage = (Integer) condition.get("currentPage");
		if (currentPage > totalPage)
		{
			currentPage = totalPage;
		}
		int max = currentPage * Data.NUM + 1;
		int min = (currentPage - 1) * Data.NUM;
		condition.put("max", max);
		condition.put("min", min);
		resultMap.put("currentPage", currentPage);
		resultMap.put("projectResults", projectResultMapper.selectProjectResults(condition));
		return resultMap;
	}

}
