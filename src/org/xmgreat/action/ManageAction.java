package org.xmgreat.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.AdminBiz;

import com.google.gson.Gson;


//前后端用户管理
@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/ManageAction")
public class ManageAction {
	
	@Autowired
	AdminBiz adminBizImpl;
	//前端用户管理
	@RequestMapping(value="/showUser.action")
    public ModelAndView showUser(HttpServletRequest request,UserInfoBean userInfoBean){
		
		return adminBizImpl.showUser(userInfoBean);
	}
	//修改用户状态
	@RequestMapping(value="/updateUserState.action")
    public String updateUserState(HttpServletRequest request,UserInfoBean userInfoBean){
		
		return adminBizImpl.updateUserState(userInfoBean);
	}
	//修改用户密码
	@RequestMapping(value="/updateUserPwd.action")
    public String updateUserPwd(HttpServletRequest request,UserInfoBean userInfoBean){
		
		return adminBizImpl.updateUserPwd(userInfoBean);
	}
	//后端用户管理
	@RequestMapping(value="/showAdmin.action")
    public ModelAndView showAdmin(HttpServletRequest request,ManagerBean managerBean){
		
		return adminBizImpl.showAdmin(managerBean);
	}
	//修改后台用户状态
	@RequestMapping(value="/updateAdminState.action")
    public String updateAdminState(HttpServletRequest request,ManagerBean managerBean){
		
		return adminBizImpl.updateAdminState(managerBean);
	}
	//修改后台用户状态
		@RequestMapping(value="/updateAdminPwd.action")
	    public String updateAdminPwd(HttpServletRequest request,ManagerBean managerBean){
			
			return adminBizImpl.updateAdminPwd(managerBean);
		}
		//进入后端注册界面
		@RequestMapping(value="/adminAdd.action")
		public ModelAndView adminAdd(){
						return adminBizImpl.adminAdd();
			
			
		}
		//查询城市
				@RequestMapping(value="/selectCity.action")
				public void selectCity(CityBean cityBean,HttpServletResponse response) throws Exception{
					List list=adminBizImpl.selectCity(cityBean);
								PrintWriter out =response.getWriter();
								Gson gson =new Gson();
								String str=gson.toJson(list);
								out.print(str);
								out.close();
								
				}
}
