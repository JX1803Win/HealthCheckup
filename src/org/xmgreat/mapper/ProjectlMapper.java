package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ProjectBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 项目配置
 */

@Repository
public interface ProjectlMapper
{
	/**
	 * @description 条件分页查询项目列表信息
	 * @param condition 查询条件
	 * @return 细项列表信息
	 */
	public List<ProjectBean> getProjects(Map<String, Object> condition);

	/**
	 * @description 获取项目详情
	 * @param projectId 项目id
	 * @return 项目信息
	 */
	public ProjectBean getProject(@Param("projectId") Integer projectId);

	/**
	 * @description 计算条件查询项目总数
	 * @param itemName 项目名称
	 * @return 细项总数
	 */
	public Integer count(@Param("itemName") String itemName);

	/**
	 * @description 增加项目
	 * @param projectBean 项目实体
	 * @return 插入的条数
	 */
	public Integer addProject(ProjectBean projectBean);

	/**
	 * @description 批量插入项目和细项关系数据
	 * @param map 关系参数
	 * @return 插入的条数
	 */
	public Integer addRelation(Map<String, Object> map);
//
//	/**
//	 * @description 修改细项
//	 * @param detailBean 细项实体
//	 * @return 修改的条数
//	 */
//	public Integer updateDetail(DetailBean detailBean);
//
//	/**
//	 * @description 删除细项
//	 * @param detailBean 细项实体
//	 * @return 删除的条数
//	 */
//	public Integer delDetail(@Param("subentryId") Integer subentryId);

}
