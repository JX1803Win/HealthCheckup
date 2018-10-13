package org.xmgreat.biz;

import java.util.List;


import org.xmgreat.bean.OfficeBean;


public interface OfficeBiz
{
	public List<OfficeBean> getOffice(int page);
	//删除科室前的操作
    public void updOffice(int officeid);
 	//删除科室
    public void delOffice(int officeid);
    //修改科室名字
    public void changeOfficeName(String name,int id);
    //新增科室
    public void addOffice(String officename);
    //模糊搜索
  	public List<OfficeBean> selectOffice(int page,String name);
  	//获取科室总数
  	public int countOff();
}
