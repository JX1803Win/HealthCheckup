package org.xmgreat.bizImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.PhyBiz;
import org.xmgreat.mapper.PhyMapper;
import org.xmgreat.util.WordUtil;
@Repository
public class PhyBizImpl implements PhyBiz {

	@Resource
	private PhyMapper phyMapper;
	@Resource
	private UserPhyRecordBean userPhyRecordBean;
	@Resource
	private UserAccoutBean userAccoutBean;
	
	
	@Override
	public void addPhyRecord(UserPhyRecordBean uprb) {
		phyMapper.addPhyRecord(uprb);
		Double cost = null;
		Double balance = phyMapper.queryUserAcc(uprb.getUserId()).getBalance();
		if(uprb.getSetmealId() != null) {
			cost = phyMapper.querySetmealCost(uprb.getSetmealId());
		} else {
			cost = phyMapper.queryProjectCost(uprb.getProjectId());
		}
		userAccoutBean.setBalance(balance - cost);
		userAccoutBean.setMoney(cost);
		userAccoutBean.setUserId(uprb.getUserId());
		userAccoutBean.setOccurMatter("体检预约");
//		phyMapper.addAccRecord(uab);
	}

	@Override
	public List<SetmealBean> queryAllSetmeal() {
		return phyMapper.queryAllSetmeal();
	}

	@Override
	public List<ProjectBean> queryAllProject() {
		return phyMapper.queryAllProject();
	}

	@Override
	public void billing(Long physicaiId, Integer setmealId, Integer projectId) {
		Integer userId =phyMapper.queryByPhyId(physicaiId).getUserId();
		userPhyRecordBean.setUserId(userId);
		userPhyRecordBean.setSetmealId(setmealId);
		userPhyRecordBean.setProjectId(projectId);
		phyMapper.billing(userPhyRecordBean);
	}

	@Override
	public UserAccoutBean queryUserAcc(Integer userId) {
		return phyMapper.queryUserAcc(userId);
	}

	@Override
	public Double querySetmealCost(Integer setmealId) {
		return phyMapper.querySetmealCost(setmealId);
	}

	@Override
	public Double queryProjectCost(Integer projectId) {
		return phyMapper.queryProjectCost(projectId);
	}

	@Override
	public List<UserPhyRecordBean> queryUserAppo(Integer userId, Integer pageNo) {
		return phyMapper.queryUserAppo(userId, pageNo);
	}

	@Override
	public Integer queryUserAppoCount(Integer userId) {
		return phyMapper.queryUserAppoCount(userId);
	}

	@Override
	public boolean cancel(Long physicaiId) {
		UserPhyRecordBean uprb = phyMapper.queryByPhyId(physicaiId);
		Double cost = null;
		Double balance = phyMapper.queryUserAcc(uprb.getUserId()).getBalance();
		if(uprb.getSetmealId() != null) {
			cost = phyMapper.querySetmealCost(uprb.getSetmealId());
		} else {
			cost = phyMapper.queryProjectCost(uprb.getProjectId());
		}
		if(cost > balance) {
			return false;
		} else {
			userAccoutBean.setBalance(balance + cost);
			userAccoutBean.setMoney(cost);
			userAccoutBean.setUserId(uprb.getUserId());
			userAccoutBean.setOccurMatter("取消体检预约");
			phyMapper.cancel(physicaiId);
			phyMapper.addAccRecord(userAccoutBean);
			return true;
		}
	}

	@Override
	public UserPhyRecordBean queryByPhyId(Long physicaiId) {
		return phyMapper.queryByPhyId(physicaiId);
	}

	@Override
	public Map<String, Object> createChecklist(Long physicaiId) {
		UserPhyRecordBean uprb = phyMapper.queryByPhyId(physicaiId);
		UserInfoBean uib = phyMapper.queryUserByUserId(uprb.getUserId());
		Map<String, Object> dataMap = new HashMap<String, Object>();
        
        /** 组装数据 */
        dataMap.put("userName", uib.getUserName());
        dataMap.put("sex", uib.getSex());
        dataMap.put("age", uib.getAge());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        dataMap.put("birth",sdf.format(new Date()));
        dataMap.put("phone", uib.getPhone());
        if(uprb.getPhyTime() != null) {
        	dataMap.put("date", uprb.getPhyTime());
        } else {
        	dataMap.put("date", uprb.getAppoTime());
        }
        dataMap.put("phyId", uprb.getPhysicaiId());
        dataMap.put("barcode", WordUtil.getImageString(uprb.getBarCode().toString()));
        List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
        if(uprb.getSetmealId() != null) {
        	List<ProjectBean> projects = phyMapper.queryProjectBySetmeal(uprb.getSetmealId());
        	for (int i = 1; i <= projects.size(); i++) {
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("i", i);
        		map.put("officeName", projects.get(i-1).getOfficeBean().getOfficeName());
        		map.put("projectName", projects.get(i-1).getItemName());
        		newsList.add(map);
        	}
        } else {
        	ProjectBean pb = phyMapper.queryProject(uprb.getProjectId());
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("i", 1);
    		map.put("officeName", pb.getOfficeBean().getOfficeName());
    		map.put("projectName", pb.getItemName());
    		newsList.add(map);
        }
        dataMap.put("myListData",newsList);  
		return dataMap;
	}

}
