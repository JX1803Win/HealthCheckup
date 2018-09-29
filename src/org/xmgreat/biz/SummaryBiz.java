package org.xmgreat.biz;

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
	 * @param proresId   项目结果id
	 * @param subentryId 细项id数组
	 * @param result     细项结果数组
	 */
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result);

	/**
	 * @description 保存体检数据
	 * @param proresId      项目结果id
	 * @param subentryId    细项id数组
	 * @param result        细项结果数组
	 * @param projectResult 项目结果
	 */
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult);

	/**
	 * 
	 * @param proresId 项目结果id
	 * @return 项目结果实体
	 */
	public ProjectResultBean skipSummary(Integer proresId);
}
