package org.xmgreat.biz;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.UserPhyRecordBean;

/**
 * @author 宋卓伟
 * @date 2018年9月22日
 * @description 用户体检记录业务
 */
public interface AppoBiz {

	/**
	 * @description 添加用户体检记录
	 * @param uprb 用户体检信息
	 */
	public void addPhyRecord(@Param("uprb")UserPhyRecordBean uprb, @Param("time")String time);
	
}
