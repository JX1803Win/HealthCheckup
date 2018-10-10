package org.xmgreat.biz;

import java.util.Map;

import org.xmgreat.bean.ProjectBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 细项配置业务类
 */
public interface ProjectBiz
{
	/**
	 * @description 带条件查询所有显示信息
	 * @param 查询条件
	 * @return 页面显示信息
	 */
	public Map<String, Object> search(Map<String, Object> condition);

	/**
	 * @description 根据项目id查询项目详情
	 * @param projectId 项目id
	 * @return 项目详情
	 */
	public ProjectBean getProject(Integer projectId);

	/**
	 * @description 根据项目id查询项目详情
	 * @param itemName 项目名称
	 * @return 项目详情
	 */
	public ProjectBean checkProject1(String itemName);

	/**
	 * @description 跳转到添加项目页面
	 * @return 返回添加页面需要的数据
	 */
	public Map<String, Object> skipAddProject();

	/**
	 * @description 添加项目
	 * @param projectBean 项目实体
	 * 
	 */
	public void addProject(ProjectBean projectBean, Integer[] subentryId);

	/**
	 * @description 跳转到修改项目页面
	 * @return 返回修改页面需要的数据
	 */
	public Map<String, Object> skipUpdateProject(Integer projectId);

	/**
	 * @description 修改项目
	 * @param detailBean 项目实体
	 */
	public void updateProject(ProjectBean projectBean, Integer[] subentryId);

	/**
	 * @description 删除项目
	 * @param projectId 项目id
	 */
	public void delProject(Integer projectId);
}
