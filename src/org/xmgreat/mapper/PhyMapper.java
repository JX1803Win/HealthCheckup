package org.xmgreat.mapper;

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
}
