package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.SetmealitmeBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

public interface DoctorMapper {
          public List<ProjectBean> selectProjectId(@Param("officeId")int officeId);//查询医生科室下的项目
          public List<SetmealBean> selectSetmeal(@Param("officeId")int officeId);//查询项目下的套餐
          public int selectUserPhyRecordNum(@Param("projectId")int projectId ,@Param("physicaiId")int physicaiId);//查询体检记录表数量
          public List<ProjectResultBean> selectUserPhyRecord(@Param("officeId")int officeId ,@Param("physicaiId")int physicaiId,@Param("pageNo")int pageNo);
      	  public UserInfoBean selectUserName(@Param("physicaiId")Integer physicaiId);
    	  public SetmealBean selectSetmealName(@Param("setmealId")Integer setmealId);
    	  public ProjectBean selectitemName(@Param("projectId")Integer projectId);
    	  public ParameterBean selectParameterName(@Param("parameterId")Integer parameterId);//查询小结状态
    	  public String selectTblPselectUserPhyNumar(@Param("parameterId")Integer parameterId);//查询小结状态
    	  public int selectUserPhyNum(@Param("userName")String userName,@Param("phone")Long phone,@Param("barCode")Long barCode,@Param("starDay")String starDay,@Param("end")String end);//体检综合查询
    	  public List<UserPhyRecordBean> selectUserPhy(@Param("userName")String userName,@Param("phone")Long phone,@Param("barCode")Long barCode,@Param("starDay")String starDay,@Param("end")String end,@Param("pageNo")Integer pageNo);//体检综合查询
          public List<ProjectResultBean> selectProjectResult(@Param("physicaiId")Integer physicaiId,@Param("projectId")Integer projectId);//查询小结
    	  public List<SetmealitmeBean> selectProject(@Param("setmealId")Integer setmealId);
    	  public int selectMedicalManNum(@Param("userName")String userName,@Param("phone")Long phone,@Param("barCode")Long barCode,@Param("starDay")String starDay,@Param("end")String end);//查询体检人信息
    	  public List<UserPhyRecordBean> selectMedicalMan(@Param("userName")String userName,@Param("phone")Long phone,@Param("barCode")Long barCode,@Param("starDay")String starDay,@Param("end")String end,@Param("pageNo")Integer pageNo);//查询体检人信息
    	  public String selectAppoTime(@Param("physicaiId")Long physicaiId);//通过体检卡查询用户预约时间
    	  public List<UserPhyRecordBean> selectMedicalManS(@Param("userName")String userName,@Param("phone")Long phone,@Param("barCode")Long barCode,@Param("starDay")String starDay,@Param("end")String end);//查询体检人信息
          public int selectPhyTimeNum(@Param("phyTime")String phyTime);
          public int selectAppointTimeNum(@Param("appoTime")String appoTime);
          public int selectPhyTimeWeekNum(@Param("StarTime")String StarTime,@Param("EndTime")String EndTime);
          public int selectAppointTimeWeekNum(@Param("StarTime")String StarTime,@Param("EndTime")String EndTime);
          public void updateAcceptState(@Param("proresId")Integer proresId,@Param("adminId")Integer adminId);//更改接收状态
}
