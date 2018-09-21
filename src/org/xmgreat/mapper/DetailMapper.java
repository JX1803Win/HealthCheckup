package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

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
	public Integer count(String detailName);
}
