package org.xmgreat.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.xmgreat.bean.ParameterBean;
/**
 * @author 宋卓伟
 * @date 2018年9月19日
 * @description 参数配置业务类
 */
public interface ParamBiz {

	/**
	 * @description 条件分页查询参数列表信息
	 * @param typeName 参数类型
	 * @param pageNo 第几页
	 * @return 参数列表信息
	 */
	public List<ParameterBean> search(@Param("typeName")String typeName, @Param("pageNo")Integer pageNo);

	/**
	 * @description 计算条件分页查询参数总数
	 * @param typeName 参数类型
	 * @return 参数总数
	 */
	public Integer countOfSearch(String typeName);
	
	
}
