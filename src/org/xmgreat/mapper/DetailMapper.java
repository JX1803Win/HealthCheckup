package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.DetailBean;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 细项配置
 */

@Repository
public interface DetailMapper
{
	public DetailBean getDetail(@Param("subentryId") Integer subentryId);

	/**
	 * @description 查询所有细项
	 * @return 所有细项列表
	 */
	public List<DetailBean> selectAll();

	/**
	 * @description 条件分页查询细项列表信息
	 * @param condition 查询条件
	 * @return 细项列表信息
	 */
	public List<DetailBean> getDetails(Map<String, Object> condition);

	/**
	 * @description 计算条件查询参数总数
	 * @param detailName 细项名称
	 * @return 细项总数
	 */
	public Integer count(@Param("detailName") String detailName);

	/**
	 * @description 增加细项
	 * @param detailBean 细项实体
	 * @return 插入的条数
	 */
	public Integer addDetail(DetailBean detailBean);

	/**
	 * @description 修改细项
	 * @param detailBean 细项实体
	 * @return 修改的条数
	 */
	public Integer updateDetail(DetailBean detailBean);

	/**
	 * @description 删除细项
	 * @param detailBean 细项实体
	 * @return 删除的条数
	 */
	public Integer delDetail(@Param("subentryId") Integer subentryId);

}
