package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;

/**
 * @author 周鸿谊
 * @date 2018年9月26日
 * @description 菜单配置
 */

@Repository
public interface SetmealMapper
{
	/**
	 * @description 条件分页查询项目列表信息
	 * @param condition 查询条件
	 * @return 套餐列表信息
	 */
	public List<SetmealBean> getSetmeals(Map<String, Object> condition);

	/**
	 * @description 根据套餐名称获取套餐
	 * @param setmealName 套餐名称
	 * @return 套餐信息
	 */
	public SetmealBean selectSetmeal(@Param("setmealName") String setmealName);

	/**
	 * @description 获取套餐详情
	 * @param setmealId 套餐id
	 * @return 套餐信息
	 */
	public SetmealBean getSetmeal(@Param("setmealId") Integer setmealId);

	/**
	 * @description 计算条件查询套餐总数
	 * @param setmealName 套餐名称
	 * @return 套餐总数
	 */
	public Integer count(@Param("setmealName") String setmealName);

	/**
	 * @description 增加套餐
	 * @param setmealBean 套餐实体
	 * @return 插入的条数
	 */
	public Integer addSetmeal(SetmealBean setmealBean);

	/**
	 * @description 批量插入项目和套餐关系数据
	 * @param setmealId 套餐id
	 * @param projectId 项目id
	 * @return 插入的条数
	 */
	public Integer addRelation(@Param("setmealId") Integer setmealId, @Param("projectId") Integer projectId);

	/**
	 * @description 根据套餐id删除套餐
	 * @param setmealId 套餐id
	 * @return 删除的条数
	 */
	public Integer delSetmeal(@Param("setmealId") Integer setmealId);

	/**
	 * @description 根据套餐id删除套餐关系
	 * @param setmealId 套餐id
	 * @return 删除的条数
	 */
	public Integer delRelation(@Param("setmealId") Integer setmealId);

	/**
	 * @description 根据修改套餐信息
	 * @param setmealBean 套餐实体
	 * @return 修改的条数
	 */
	public Integer updateSetmeal(SetmealBean setmealBean);

}
