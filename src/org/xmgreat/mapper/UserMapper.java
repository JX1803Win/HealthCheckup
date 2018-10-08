package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;

@Repository
public interface UserMapper
{	//验证登入
	public List<UserInfoBean> checkUser(@Param("phone") Long phone, @Param("pwd") String pwd);
	//验证手机号是否注册
	public UserInfoBean checkPhone(@Param("phone") Long phone);
	//用户注册
	public void reg(@Param("username") String username,@Param("phone") Long phone, @Param("pwd") String pwd);
	//用户忘记密码找回
	public void forGotPwd(@Param("phone") Long phone, @Param("pwd") String pwd);
	//用户修改信息
	public void changeInfo(@Param("sex") String sex,@Param("age") int age,@Param("birth")String birth,@Param("blood")String blood,@Param("add")String add,@Param("phone")Long phone);                                      
	//获取账户明细
	public List<UserAccoutBean> getAccout(@Param("userid") int userid,@Param("page") int page);              
	//获取套餐
	public List<SetmealBean> getSetmeal(@Param("page") int page);
	//查看细项
	public List<ProjectBean> getxi(@Param("mid")int mid);
	//模糊查询套餐
	public List<SetmealBean> selectMeal(@Param("name")String name,@Param("page")int page);
	//查询总数
	public int countMeal();

}
