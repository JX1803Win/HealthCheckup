package org.xmgreat.biz;

import java.util.Map;

import org.xmgreat.bean.DetailBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 细项配置业务类
 */
public interface DetailBiz
{
	/**
	 * @description 带条件查询所有显示信息
	 * @param 查询条件
	 * @return 页面显示信息
	 */
	public Map<String, Object> search(Map<String, Object> condition);
	
	
	public DetailBean checkDetail(String detailName);

	/**
	 * @description 添加细项
	 * @param detailBean 细项实体
	 * 
	 */
	public void addDetail(DetailBean detailBean);

	/**
	 * @description 修改细项
	 * @param detailBean 细项实体
	 */
	public void updateDetail(DetailBean detailBean);

	/**
	 * @description 删除细项
	 * @param detailBean 细项实体
	 */
	public void delDetail(Integer subentryId);
}
