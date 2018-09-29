package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

/**
 * @author 宋卓伟
 * @date 2018年9月24日
 * @description 用户体检
 */
public interface PhyMapper {

	/**
	 * @description 根据体检号查询体检信息
	 * @param physicaiId 体检号
	 * @return 体检信息
	 */
	public UserPhyRecordBean queryByPhyId(Long physicaiId);
	
	/**
	 * @description 添加用户体检记录(预约)
	 * @param uprb 用户体检信息
	 */
	public int addPhyRecord(@Param("uprb")UserPhyRecordBean uprb);
	
	/**
	 * @description 查询所有套餐
	 * @return 套餐list
	 */
	public List<SetmealBean> queryAllSetmeal();
	
	/**
	 * @description 查询所有项目
	 * @return 项目list
	 */
	public List<ProjectBean> queryAllProject();
	
	/**
	 * @description 用户体检开单
	 * @param uprb 体检信息
	 */
	public void billing(@Param("uprb")UserPhyRecordBean uprb);
	
	/**
	 * @description 根据用户id查询用户信息
	 * @param userId 用户id
	 * @return 用户信息
	 */
	public UserInfoBean queryUserByUserId(Integer userId);
	
	/**
	 * @description 根据体检号查询用户体检信息
	 * @param physicaiId 体检号
	 * @return 用户信息
	 */
	//public UserInfoBean queryUserByPhysicaiId(Long physicaiId);
	
	/**
	 * @description 查询用户余额信息
	 * @param userId 用户id
	 * @return 用户余额信息
	 */
	public UserAccoutBean queryUserAcc(Integer userId);
	
	/**
	 * @description 查询指定套餐总费用
	 * @param setmealId 套餐id
	 * @return 套餐总费用
	 */
	public Double querySetmealCost(Integer setmealId);
	
	/**
	 * @description 查询指定项目总费用
	 * @param projectId 项目id
	 * @return 项目总费用
	 */
	public Double queryProjectCost(Integer projectId);
	
	/**
	 * @description 分页查询用户预约体检记录
	 * @param userId 用户id
	 * @param pageNo 第几页
	 * @return 预约体检记录列表
	 */
	public List<UserPhyRecordBean> queryUserAppo(@Param("userId")Integer userId, @Param("pageNo")Integer pageNo);
	
	/**
	 * @description 用户预约体检记录总数
	 * @param userId 用户id
	 * @return 预约体检记录总数
	 */
	public Integer queryUserAppoCount(Integer userId);
	
	/**
	 * @description 取消指定预约体检
	 * @param physicaiId 体检号
	 */
	public void cancel(Long physicaiId);
	
	/**
	 * @description 添加用户账单记录
	 * @param uab 账单信息
	 */
	public void addAccRecord(@Param("uab")UserAccoutBean uab);
	
	/**
	 * @description 查询指定套餐包含的项目
	 * @param setmealId 套餐id
	 * @return 项目列表
	 */
	public List<ProjectBean> queryProjectBySetmeal(Integer setmealId);
	
	/**
	 * @description 查询指定项目信息
	 * @param projectId 项目id
	 * @return 项目信息
	 */
	public ProjectBean queryProject(Integer projectId);
	
}
