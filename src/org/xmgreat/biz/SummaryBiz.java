package org.xmgreat.biz;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 医师小结类
 */
public interface SummaryBiz
{
	/**
	 * @description 跳转到小结页面
	 * @param projectId 项目id
	 * @return 项目实体
	 */
	public ProjectBean skipExamination(Integer projectId);

	/**
	 * @description 保存体检数据
	 * @param proresId      项目结果id
	 * @param subentryId    细项id数组
	 * @param result        细项结果数组
	 * @param projectResult 项目结果
	 * @param parameterId   小结状态
	 */
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult,
			Integer parameterId);

	/**
	 * @description 保存体检数据
	 * @param proresId      项目结果id
	 * @param subentryId    细项id数组
	 * @param result        细项结果数组
	 * @param projectResult 项目结果
	 * @param parameterId   小结状态
	 */
	public void projectSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult,
			Integer parameterId);

	/**
	 * @description 保存体检数据
	 * @param proresId      项目结果id
	 * @param subentryId    细项id数组
	 * @param request       页面请求
	 * @param projectResult 项目结果
	 * @param parameterId   小结状态
	 */
	public void imageSummary(Integer proresId, Integer[] subentryId, HttpServletRequest request, String projectResult,
			Integer parameterId) throws IllegalStateException, IOException;

	/**
	 * @description 医师小结
	 * @param proresId      项目结果id
	 * @param projectResult 项目结果
	 * @param parameterId   小结状态
	 */
	public void summary(Integer proresId, String projectResult, Integer parameterId);

	/**
	 * 
	 * @param proresId 项目结果id
	 * @return 项目结果实体
	 */
	public ProjectResultBean skipSummary(Integer proresId);

	public Map<String, Object> querySummary(Map<String, Object> condition);
}
