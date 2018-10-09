package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ProjectResultBean;

/**
 * @author 周鸿谊
 * @date 2018年9月28日
 * @description 项目结果
 */

@Repository
public interface ProjectResultMapper
{
	public Integer updateProjectResul(ProjectResultBean projectResultBean);

	public ProjectResultBean getProjectResult(@Param("proresId") Integer proresId);

	public Integer count(Map<String, Object> condition);

	public List<ProjectResultBean> selectProjectResults(Map<String, Object> condition);
}
