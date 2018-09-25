package org.xmgreat.mapper;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.UserPhyRecordBean;

/**
 * @author 宋卓伟
 * @date 2018年9月21日
 * @description 用户预约dao
 */
public interface AppoMapper {
	
	/**
	 * @description 添加用户体检记录
	 * @param uprb 用户体检信息
	 */
	public int addPhyRecord(@Param("uprb")UserPhyRecordBean uprb);
	
	/**
	 * @description 添加用户预约记录
	 * @param uprb 体检信息
	 */
	public void addAppoRecord(@Param("uprb")UserPhyRecordBean uprb, @Param("time")String time);
}
