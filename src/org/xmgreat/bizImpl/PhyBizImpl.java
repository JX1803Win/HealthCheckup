package org.xmgreat.bizImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.xmgreat.bean.DetailBean;
import org.xmgreat.bean.ProResBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.SubentryBean;
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
	@Resource
	private ProResBean proResBean;
	
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
	public Long billing(Long physicaiId, Integer setmealId, Integer projectId) {
		Integer userId =phyMapper.queryUserByPhyCardId(physicaiId).getUserId();
		userPhyRecordBean.setUserId(userId);
		userPhyRecordBean.setSetmealId(setmealId);
		userPhyRecordBean.setProjectId(projectId);
		phyMapper.billing(userPhyRecordBean);
		return phyMapper.queryLastPhyRecord(userId);
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
        dataMap.put("birth",uib.getBirth());
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
        		phyMapper.initProResInfo(uprb.getPhysicaiId(), projects.get(i-1).getProjectId());
        		initSubInfo(uprb.getPhysicaiId(), projects.get(i-1).getProjectId());
        	}
        } else {
        	ProjectBean pb = phyMapper.queryProject(uprb.getProjectId());
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("i", 1);
    		map.put("officeName", pb.getOfficeBean().getOfficeName());
    		map.put("projectName", pb.getItemName());
    		newsList.add(map);
    		phyMapper.initProResInfo(uprb.getPhysicaiId(), pb.getProjectId());
    		initSubInfo(uprb.getPhysicaiId(), pb.getProjectId());
        }
        dataMap.put("myListData",newsList);  
		return dataMap;
	}
	
	public void initSubInfo(Long physicaiId, Integer projectId) {
		Integer proresId = phyMapper.queryProResInfo(physicaiId, projectId).getProresId();
		List<DetailBean> details = phyMapper.queryDetailByProject(projectId);
		for(int i = 0; i < details.size(); i++) {
			phyMapper.initSubInfo(proresId, details.get(i).getSubentryId());
		}
	}
	
	@Override
	public Map<String, Object> lookChecklist(Long physicaiId) {
		UserPhyRecordBean uprb = phyMapper.queryByPhyId(physicaiId);
		UserInfoBean uib = phyMapper.queryUserByUserId(uprb.getUserId());
		Map<String, Object> dataMap = new HashMap<String, Object>();
        
        /** 组装数据 */
        dataMap.put("userName", uib.getUserName());
        dataMap.put("sex", uib.getSex());
        dataMap.put("age", uib.getAge());
        dataMap.put("birth",uib.getBirth());
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

	@Override
	public Map<String, Object> createReport(Long physicaiId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		UserPhyRecordBean uprb = phyMapper.queryByPhyId(physicaiId);
		UserInfoBean uib = phyMapper.queryUserByUserId(uprb.getUserId());
		
		dataMap.put("userName", uib.getUserName());
        dataMap.put("sex", uib.getSex());
        dataMap.put("age", uib.getAge());
        if(uprb.getPhyTime() != null) {
        	dataMap.put("time", uprb.getPhyTime());
        } else {
        	dataMap.put("time", uprb.getAppoTime());
        }
        dataMap.put("phone", uib.getPhone());
        dataMap.put("phyId", uprb.getPhysicaiId());
		dataMap.put("barcode", WordUtil.getImageString(uprb.getBarCode().toString()));
		dataMap.put("userName", uprb.getUserName());
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		List<Map<String, List<Map<String, Object>>>> projectList = new ArrayList<>();
		if(uprb.getSetmealId() != null) {
        	List<ProjectBean> projects = phyMapper.queryProjectBySetmeal(uprb.getSetmealId());
        	for (int j = 1; j <= projects.size(); j++) {
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("i", j);
        		map.put("officeName", projects.get(j-1).getOfficeBean().getOfficeName());
        		map.put("projectName", projects.get(j-1).getItemName());
        		newsList.add(map);
        		
        		Map<String, List<Map<String, Object>>> project = new HashMap<>();
				List<Map<String, Object>> detailList = new ArrayList<>();
				ProResBean prb = phyMapper.queryProResInfo(physicaiId, projects.get(j-1).getProjectId());
				List<SubentryBean> subList = phyMapper.querySubByPro(prb.getProresId());
				for (int i = 1; i <= subList.size(); i++) {
					Map<String, Object> detail = new HashMap<>();
					detail.put("i", i);
					detail.put("detailName", subList.get(i-1).getDetailBean().getDetailName());
					detail.put("result", subList.get(i-1).getResult());
					if(subList.get(i-1).getDetailBean().getParameterBean() != null) {
						detail.put("unit", subList.get(i-1).getDetailBean().getParameterBean().getParameterName());
					} else {
						detail.put("unit", "");
					}
					if(subList.get(i-1).getDetailBean().getLowerLimit() != null) {
						detail.put("reference",  subList.get(i-1).getDetailBean().getLowerLimit()+"-"+
								subList.get(i-1).getDetailBean().getUpperLimit());
					} else {
						detail.put("reference", "");
					}
					detail.put("hint",  subList.get(i-1).getHint());
					detailList.add(detail);
				}
				project.put(projects.get(j-1).getItemName(), detailList);
				List<Map<String, Object>> list = new ArrayList<>();
				Map<String, Object> info = new HashMap<>();
				info.put("officeName", projects.get(j-1).getOfficeBean().getOfficeName());
				info.put("manageName", prb.getManagerName());
				list.add(info);
				project.put("info", list);
				projectList.add(project);
        	}
        } else {
        	ProjectBean pb = phyMapper.queryProject(uprb.getProjectId());
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("i", 1);
    		map.put("officeName", pb.getOfficeBean().getOfficeName());
    		map.put("projectName", pb.getItemName());
    		newsList.add(map);
    		
    		Map<String, List<Map<String, Object>>> project = new HashMap<>();
			List<Map<String, Object>> detailList = new ArrayList<>();
			ProResBean prb = phyMapper.queryProResInfo(physicaiId, pb.getProjectId());
			List<SubentryBean> subList = phyMapper.querySubByPro(prb.getProresId());
			for (int i = 1; i <= subList.size(); i++) {
				Map<String, Object> detail = new HashMap<>();
				detail.put("i", i);
				detail.put("detailName", subList.get(i-1).getDetailBean().getDetailName());
				detail.put("result", subList.get(i-1).getResult());
				detail.put("unit", subList.get(i-1).getDetailBean().getParameterBean().getParameterName());
				detail.put("reference",  subList.get(i-1).getDetailBean().getLowerLimit()+"-"+subList.get(i-1).getDetailBean().getUpperLimit());
				detail.put("hint",  subList.get(i-1).getHint());
				detailList.add(detail);
			}
			project.put(pb.getItemName(), detailList);
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> info = new HashMap<>();
			info.put("officeName", pb.getOfficeBean().getOfficeName());
			info.put("manageName", prb.getManagerName());
			list.add(info);
			project.put("info", list);
			projectList.add(project);
        }
        dataMap.put("myListData",newsList);  
        dataMap.put("projects", projectList);
        dataMap.put("phyConad", uprb.getPhyConad());
        dataMap.put("guidance", uprb.getGuidance());
        dataMap.put("sumTime", uprb.getSumTime());
        dataMap.put("mangerName", uprb.getMangerName());
		return dataMap;
	}

	@Override
	public List<UserPhyRecordBean> querySummary(Long physicaiId, Integer pageNo) {
		return phyMapper.querySummary(physicaiId, pageNo);
	}

	@Override
	public Integer countOfSummary(Long physicaiId) {
		return phyMapper.countOfSummary(physicaiId);
	}

	@Override
	public List<ProResBean> queryProResByPhysicaiId(Long physicaiId) {
		return phyMapper.queryProResByPhysicaiId(physicaiId);
	}

	@Override
	public void writeSummary(UserPhyRecordBean uprb) {
		phyMapper.writeSummary(uprb);
	}

	@Override
	public UserInfoBean queryUserByPhyCardId(Long phyCardId) {
		return phyMapper.queryUserByPhyCardId(phyCardId);
	}
}
