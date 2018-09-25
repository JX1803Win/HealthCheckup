package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ParameterBean;

/**
 * @author 宋卓伟
 * @date 2018年9月19日
 * @description 参数配置
 */
@Repository
public interface ParamMapper
{

	/**
	 * @description 条件分页查询参数列表信息
	 * @param typeName 参数类型
	 * @param pageNo   第几页
	 * @return 参数列表信息
	 */
	public List<ParameterBean> search(@Param("typeName") String typeName, @Param("pageNo") Integer pageNo);

	/**
	 * @description 根据参数类型查询参数列表信息
	 * @param parameterType 参数类型
	 * @return 返回参数列表信息
	 */
	public List<ParameterBean> getParameters(@Param("parameterType") Integer parameterType);

	/**
	 * @description 计算条件分页查询参数总数
	 * @param typeName 参数类型
	 * @return 参数总数
	 */
	public Integer countOfSearch(@Param("typeName")String typeName);
	
	/**
	 * @description 根据参数id删除参数信息
	 * @param parameterId
	 */
	public void del(Integer parameterId);
	
	/**
	 * @description 查询所有的参数类型
	 * @return 所有的参数类型
	 */
	public List<ParameterBean> queryAllTypeName();
	
	/**
	 * @description 添加参数
	 * @param pb 参数信息
	 */
	public void addParam(ParameterBean pb);
	
	/**
	 * @description 修改参数
	 * @param pb 参数信息
	 */
	public void alterParam(ParameterBean pb);
}
