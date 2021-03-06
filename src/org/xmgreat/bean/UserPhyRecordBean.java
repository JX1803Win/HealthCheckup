package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class UserPhyRecordBean // 用户体检记录
{
	private Long physicaiId;// 体检号
	private Long barCode; // 条码号
	private Integer userId; // 用户ID
	private String userName; // 用户名字
	private Integer setmealId; // 套餐ID
	private String setmealName;// 套餐名称
	private Integer projectId; // 项目ID
	private String itemName;// 项目名称
	private String phyTime; // 体检时间
	private String appoTime;// 预约时间
	private String phyConad; // 体检总结及建议
	private String guidance; // 生活保健指导
	private Integer adminId; // 总结医生ID
	private String mangerName;// 总结医生姓名
	private String sumTime; // 总结时间
	private Integer parameterId;// 参数id
	private String parameterName;// 参数名称
	private UserPhyRecordBean userPhyRecordBean;//用户体检记录实体
	private UserInfoBean userInfoBean;//用户实体
	private ManagerBean managerBean;//管理员实体
	private SetmealBean setmealBean;//套餐实体
    private UserAppoBean userAppoBean;
	public UserPhyRecordBean() {

	}

	public UserAppoBean getUserAppoBean() {
		return userAppoBean;
	}

	public void setUserAppoBean(UserAppoBean userAppoBean) {
		this.userAppoBean = userAppoBean;
	}

	public Long getPhysicaiId() {
		return physicaiId;
	}

	public void setPhysicaiId(Long physicaiId) {
		this.physicaiId = physicaiId;
	}

	public Long getBarCode() {
		return barCode;
	}

	public void setBarCode(Long barCode) {
		this.barCode = barCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSetmealId() {
		return setmealId;
	}

	public void setSetmealId(Integer setmealId) {
		this.setmealId = setmealId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getPhyTime() {
		return phyTime;
	}

	public void setPhyTime(String phyTime) {
		this.phyTime = phyTime;
	}

	public String getPhyConad() {
		return phyConad;
	}

	public void setPhyConad(String phyConad) {
		this.phyConad = phyConad;
	}

	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getSumTime() {
		return sumTime;
	}

	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSetmealName() {
		return setmealName;
	}

	public void setSetmealName(String setmealName) {
		this.setmealName = setmealName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAppoTime() {
		return appoTime;
	}

	public void setAppoTime(String appoTime) {
		this.appoTime = appoTime;
	}

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public ManagerBean getManagerBean() {
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}

	public SetmealBean getSetmealBean() {
		return setmealBean;
	}

	public void setSetmealBean(SetmealBean setmealBean) {
		this.setmealBean = setmealBean;
	}

	public UserPhyRecordBean getUserPhyRecordBean() {
		return userPhyRecordBean;
	}

	public void setUserPhyRecordBean(UserPhyRecordBean userPhyRecordBean) {
		this.userPhyRecordBean = userPhyRecordBean;
	}

}
