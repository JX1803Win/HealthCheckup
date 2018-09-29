package org.xmgreat.mapper;

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
}
