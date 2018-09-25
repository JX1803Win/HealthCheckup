package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.UserInfoBean;

@Repository
public interface UserMapper
{
	public List<UserInfoBean> checkUser(@Param("phone") Long phone, @Param("pwd") String pwd);
<<<<<<< HEAD
=======
	public UserInfoBean checkPhone(@Param("phone") Long phone);
	public void reg(@Param("username") String username,@Param("phone") Long phone, @Param("pwd") String pwd);
>>>>>>> refs/heads/master
}
