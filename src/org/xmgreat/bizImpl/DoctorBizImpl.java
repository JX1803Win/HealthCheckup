package org.xmgreat.bizImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.SetmealitmeBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.DoctorBiz;
import org.xmgreat.mapper.DoctorMapper;

@Service
public class DoctorBizImpl implements DoctorBiz {
	@Resource
	private DoctorMapper doctorMapper;

	@Override
	public int selectUserPhyRecNum(Integer officeId, Integer physicaiId) {
		// TODO Auto-generated method stub
		int a = 0;
		// 查询对应项目ID
		List<ProjectBean> pblist = doctorMapper.selectProjectId(officeId);
		
		// 通过项目ID、套餐ID查询所有的体检记录表（再放上输入体检卡号）
		if (physicaiId==null) {
			physicaiId=0;
		}
		for (int i = 0; i < pblist.size(); i++) {
					a += doctorMapper.selectUserPhyRecordNum(pblist.get(i).getProjectId(),physicaiId);
			
		}
		return a;
	}

	@Override
	public List<ProjectResultBean> selectUserPhyRec(Integer officeId, Integer physicaiId, Integer pageNo) {
		// TODO Auto-generated method stub
		// 查询对应项目ID
		List<ProjectBean> pblist = doctorMapper.selectProjectId(officeId);		
				
		// 通过项目ID、套餐ID查询所有的体检记录表（再放上输入体检卡号）
		if (physicaiId==null) {
			physicaiId=0;
		}
		List<ProjectResultBean> uprbList=new ArrayList<ProjectResultBean>();
		List<ProjectResultBean> uprbList2=new ArrayList<ProjectResultBean>();
		for (int i = 0; i < pblist.size(); i++) {			
				uprbList = doctorMapper.selectUserPhyRecord(pblist.get(i).getProjectId(),physicaiId, pageNo);								
				uprbList2.addAll(uprbList);
		}
		
		return uprbList2;
	}

	@Override
	public UserInfoBean selectUserName(Integer physicaiId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectUserName(physicaiId);
	}

	@Override
	public SetmealBean selectSetmealName(Integer setmealId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectSetmealName(setmealId);
	}

	@Override
	public ProjectBean selectitemName(Integer projectId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectitemName(projectId);
	}

	@Override
	public ParameterBean selectParameterName(Integer parameterId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectParameterName(parameterId);
	}

	@Override
	public String selectTblPar(Integer parameterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectUserPhyNum(String userName, Long phone, Long barCode, String starDay,String end) {
		// TODO Auto-generated method stub
		return doctorMapper.selectUserPhyNum(userName, phone, barCode, starDay,end);
	}

	@Override
	public List<UserPhyRecordBean> selectUserPhy(String userName, Long phone, Long barCode, String starDay,String end,Integer pageNo) {
		// TODO Auto-generated method stub		
		return doctorMapper.selectUserPhy(userName, phone, barCode, starDay,end,pageNo);
		
	}

	@Override
	public List<ProjectResultBean> selectProjectResult(Integer setmealId, Integer physicaiId) {
		// TODO Auto-generated method stub
		//套餐查询项目查询
		List<SetmealitmeBean> sbList=doctorMapper.selectProject(setmealId);
		List<ProjectResultBean> list1=new ArrayList<ProjectResultBean>();
		List<ProjectResultBean> list2=new ArrayList<ProjectResultBean>();
		for (int i = 0; i < sbList.size(); i++) {
			list1=doctorMapper.selectProjectResult(physicaiId,sbList.get(i).getProjectId());
		    list2.addAll(list1);
		}
		return list2;
	}

	@Override
	public List<ProjectResultBean> selectProjectResults(Integer projectId, Integer physicaiId) {
		// TODO Auto-generated method stub
		List<ProjectResultBean> prb=doctorMapper.selectProjectResult(physicaiId,projectId);
		return prb;
	}

	@Override
	public int selectMedicalManNum(String userName, Long phone, Long barCode, String starDay, String end) {
		// TODO Auto-generated method stub
		return doctorMapper.selectMedicalManNum(userName, phone, barCode, starDay, end);
	}

	@Override
	public List<UserInfoBean> selectMedicalMan(String userName, Long phone, Long barCode, String starDay, String end,
			Integer pageNo) {
		// TODO Auto-generated method stub		
		return doctorMapper.selectMedicalMan(userName, phone, barCode, starDay, end, pageNo);
	}

	@Override
	public String selectAppoTime(Long physicaiId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectAppoTime(physicaiId);
	}

	@Override
	public List<UserInfoBean> selectMedicalManS(String userName, Long phone, Long barCode, String starDay, String end) {
		// TODO Auto-generated method stub
		return doctorMapper.selectMedicalManS(userName, phone, barCode, starDay, end);
	}

	@Override
	public int selectPhyTimeNum(String PhyTime) {
		// TODO Auto-generated method stub
		//查询所有的预约时间和诊断时间
		int a1=doctorMapper.selectPhyTimeNum(PhyTime);
		int a2=doctorMapper.selectAppointTimeNum(PhyTime);
		return a1+a2;
	}

	@Override
	public int selectPhyTimeWeekNum(String StarTime, String EndTime) {
		// TODO Auto-generated method stub
		int a1=doctorMapper.selectPhyTimeWeekNum(StarTime,EndTime);
		int a2=doctorMapper.selectAppointTimeWeekNum(StarTime,EndTime);
		return a1+a2;
	}

}
