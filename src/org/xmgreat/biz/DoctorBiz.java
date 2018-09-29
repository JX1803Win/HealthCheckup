package org.xmgreat.biz;

import java.util.List;
import java.util.Map;

import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

public interface DoctorBiz {
	public int selectUserPhyRecNum(Integer adminId,Integer physicaiId);
	public List<ProjectResultBean> selectUserPhyRec(Integer adminId,Integer physicaiId,Integer pageNo);
	public UserInfoBean selectUserName(Integer physicaiId);
	public SetmealBean selectSetmealName(Integer setmealId);
	public ProjectBean selectitemName(Integer projectId);
	public ParameterBean selectParameterName(Integer parameterId);//查询小结参数
	public String selectTblPar(Integer parameterId);//查询小结状态
	public int selectUserPhyNum(String userName,Long phone,Long barCode,String starDay,String end);//体检综合查询
	public List<UserPhyRecordBean> selectUserPhy(String userName,Long phone,Long barCode,String starDay,String end,Integer pageNo);//体检综合查询
    public List<ProjectResultBean> selectProjectResult(Integer setmealId,Integer physicaiId);//查询小结


}
