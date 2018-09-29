package org.xmgreat.biz;

import java.util.List;
import java.util.Map;

import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 细项配置业务类
 */
public interface SetmealBiz
{
	/**
	 * @description 带条件查询所有显示信息
	 * @param 查询条件
	 * @return 页面显示信息
	 */
	public Map<String, Object> search(Map<String, Object> condition);

	/**
	 * @description 根据项目id查询项目详情
	 * @param setmealId 项目id
	 * @return 项目详情
	 */
	public SetmealBean getSetmeal(Integer setmealId);

	/**
	 * @description 跳转到添加项目页面
	 * @return 返回添加页面需要的数据
	 */
	public List<ProjectBean> skipAddSetmeal();

	/**
	 * @description 添加项目
	 * @param projectBean 项目实体
	 * 
	 */
	public void addSetmeal(SetmealBean setmealBean, Integer[] projectId);

	/**
	 * @description 跳转到修改项目页面
	 * @return 返回修改页面需要的数据
	 */
	public Map<String, Object> skipUpdateSetmeal(Integer setmealId);

	/**
	 * @description 修改菜单
	 * @param setmealBean 菜单实体
	 * @param projectId   项目id数组
	 */
	public void updateSetmeal(SetmealBean setmealBean, Integer[] projectId);

	/**
	 * @description 删除项目
	 * @param setmealId 项目id
	 */
	public void delSetmeal(Integer setmealId);
}
