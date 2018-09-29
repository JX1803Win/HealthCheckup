package org.xmgreat.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.OfficeBean;


@Repository
public interface OfficeMapper
{	
	
	/**
	 * @description 查询所有科室
	 * @return 所有科室列表
	 */
	public List<OfficeBean> selectAll();
	//获取科室信息
	public List<OfficeBean> getOffice(@Param("page")int page);
	//删除科室前的操作
	public void updOffice(@Param("officeid")int officeid);
	//删除科室
	public void delOffice(@Param("officeid")int officeid);
	//修改科室名
	public Integer changeOfficeName(@Param("name")String name,@Param("id")int id);
	//新增科室
	public void addOffice(@Param("officename")String officename);
	//模糊搜索
	public List<OfficeBean> selectOffice(@Param("page")int page,@Param("name")String name);
}
