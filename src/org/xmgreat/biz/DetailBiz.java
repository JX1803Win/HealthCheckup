package org.xmgreat.biz;

import java.util.Map;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 细项配置业务类
 */
public interface DetailBiz
{
	/**
	 * 
	 * @param 查询条件
	 * @return 页面显示信息
	 */
	public Map<String, Object> search(Map<String, Object> condition);

}
