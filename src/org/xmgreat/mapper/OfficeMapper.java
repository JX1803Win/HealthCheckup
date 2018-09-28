package org.xmgreat.mapper;

import java.util.List;

import org.xmgreat.bean.OfficeBean;

/**
 * @author 周鸿谊
 * @date 2018年9月25日
 * @description 科室配置
 */
public interface OfficeMapper
{
	/**
	 * @description 查询所有科室
	 * @return 所有科室列表
	 */
	public List<OfficeBean> selectAll();

}
