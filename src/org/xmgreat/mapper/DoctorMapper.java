package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

public interface DoctorMapper {
          public List<ProjectBean> selectProjectId(@Param("officeId")int officeId);//查询医生科室下的项目
          public List<SetmealBean> selectSetmeal(@Param("officeId")int officeId);//查询项目下的套餐
          public int selectUserPhyRecordNum(@Param("projectId")int projectId ,@Param("physicaiId")int physicaiId);//查询体检记录表数量
          public List<ProjectResultBean> selectUserPhyRecord(@Param("projectId")int projectId ,@Param("physicaiId")int physicaiId,@Param("pageNo")int pageNo);
      	  public UserInfoBean selectUserName(@Param("physicaiId")Integer physicaiId);
    	  public SetmealBean selectSetmealName(@Param("setmealId")Integer setmealId);
    	  public ProjectBean selectitemName(@Param("projectId")Integer projectId);
    	  public ParameterBean selectParameterName(@Param("parameterId")Integer parameterId);//查询小结状态
    	  public String selectTblPar(@Param("parameterId")Integer parameterId);//查询小结状态
}
