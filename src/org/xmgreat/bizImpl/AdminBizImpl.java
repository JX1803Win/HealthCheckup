package org.xmgreat.bizImpl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.mapper.AdminMapper;
import org.xmgreat.util.Excel;

@Service
public class AdminBizImpl implements AdminBiz
{
	private List listAll;
	private List list;
	private List listRole;
	private List listOffice;
	private int page;//页数
	private int pageAll;//总页数
	/*@Resource
	private UserMapper userMapper;*/
	
	ModelAndView mav = new ModelAndView();
	@Resource
	private AdminMapper adminMapper;
	@Override
	public ManagerBean login(String adminName, String psw)
	{
		// TODO Auto-generated method stub
		return adminMapper.adminLogin(adminName, psw);
	}
	@Override
	public ModelAndView showUser(UserInfoBean userInfoBean) {
		
		pageAll=adminMapper.showUserCount(userInfoBean);
			int allPage = 0;
			if (pageAll % 3 != 0) {
				allPage = (pageAll / 3) + 1;
			} else {
				allPage = (pageAll / 3);
			}
			page=userInfoBean.getPage();
			/* if(page<=0) {
	           	page=allPage;
	           }
	           if(page>allPage) {
	           	page=1;
	           }*/
	           System.out.println("页数"+userInfoBean.getPage());
			list=adminMapper.showUser(userInfoBean);
			mav.setViewName("backstage/userInfo");
			mav.addObject("list",list);
			mav.addObject("pageAll",allPage);
			mav.addObject("page",page);
			mav.addObject("phyCardId1",userInfoBean.getPhyCardId1());
			mav.addObject("parameterID1",userInfoBean.getParameterID1());
			mav.addObject("userName",userInfoBean.getUserName());
			mav.addObject("regTimeA",userInfoBean.getRegTimeA());
			mav.addObject("regTimeB",userInfoBean.getRegTimeB());
		
		return mav;
	}
	//修改用户状态
	@Override
	public String updateUserState(UserInfoBean userInfoBean) {
		boolean bool=adminMapper.updateUserState(userInfoBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showUser.action?page="+userInfoBean.getPage()+"";
		}
		return result;
	}
	//修改用户密码
		@Override
		public String updateUserPwd(UserInfoBean userInfoBean) {
			boolean bool=adminMapper.updateUserPwd(userInfoBean);
			String result=null;
			if(bool==true) {
				result="redirect:/ManageAction/showUser.action?page="+userInfoBean.getPage()+"";
			}
			return result;
		}
		//后台用户展示
	@Override
	public ModelAndView showAdmin(ManagerBean managerBean) {
		pageAll=adminMapper.showAdminCount(managerBean);
		int allPage = 0;
		if (pageAll % 3 != 0) {
			allPage = (pageAll / 3) + 1;
		} else {
			allPage = (pageAll / 3);
		}
		page=managerBean.getPage();
		listRole=adminMapper.selectRole();
		listOffice=adminMapper.selectOffice();
           System.out.println("页数"+managerBean.getPage());
		list=adminMapper.showAdmin(managerBean);
		mav.setViewName("backstage/adminInfo");
		mav.addObject("list",list);
		mav.addObject("pageAll",allPage);
		mav.addObject("page",page);
		mav.addObject("listRole",listRole);
		mav.addObject("listOffice",listOffice);
		mav.addObject("mangerName",managerBean.getMangerName());
		mav.addObject("phoneNum1",managerBean.getPhoneNum1());
		mav.addObject("paramterId1",managerBean.getParamterId1());
		mav.addObject("roleName",managerBean.getRoleName());
		mav.addObject("officeName",managerBean.getOfficeName());
	return mav;
		
	}
	//修改用户状态
	@Override
	public String updateAdminState(ManagerBean managerBean) {
		boolean bool=adminMapper.updateAdminState(managerBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showAdmin.action?page="+managerBean.getPage()+"";
		}
		return result;
	}
	//修改后台用户密码
	@Override
	public String updateAdminPwd(ManagerBean managerBean) {
		boolean bool=adminMapper.updateAdminPwd(managerBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showAdmin.action?page="+managerBean.getPage()+"";
		}
		return result;
	}
	@Override//查询注册下拉框的值
	public ModelAndView adminAdd() {
		listRole=adminMapper.selectRole();
		listOffice=adminMapper.selectOffice();
		list=adminMapper.selectProvince();
		mav.addObject("listRole",listRole);
		mav.addObject("listOffice",listOffice);
		mav.addObject("listProvince",list);
		mav.setViewName("backstage/adminAdd");
		return mav;
	}
	//查询城市
	@Override
	public List<CityBean> selectCity(CityBean cityBean) {
	
		return adminMapper.selectCity(cityBean);
	}
	//查询用户知否以注册
	@Override
	public String selectAdmin(ManagerBean managerBean) {
		// TODO Auto-generated method stub
		int i =adminMapper.selectAdmin(managerBean);
		String str=null;
		if(i>0) {
			str="已注册";
		}else {
			str="未注册";
		}
		return str;
	}
	//增加后台用户
	@Override
	public String addAdmin(ManagerBean managerBean) {
		boolean bool=adminMapper.adminAdd(managerBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showAdmin.action?page=1";
		}
		return result;
		
	}
	//体检卡管理
	@Override
	public ModelAndView showPhyCardInfo(PhyCardBean phyCardBean) {
		pageAll=adminMapper.showPhyCardCount(phyCardBean);
		int allPage = 0;
		if (pageAll % 3 != 0) {
			allPage = (pageAll / 3) + 1;
		} else {
			allPage = (pageAll / 3);
		}
		page=phyCardBean.getPage();
  
		list=adminMapper.showPhyCardInfo(phyCardBean);
		mav.setViewName("backstage/phyCardInfo");
		mav.addObject("list",list);
		mav.addObject("pageAll",allPage);
		mav.addObject("page",page);
		mav.addObject("getPhyCardId1",phyCardBean.getPhyCardId1());
		mav.addObject("parameterId1",phyCardBean.getParameterId1());
		return mav;
	}
	//修改体检卡状态
	@Override
	public String updatePhyCardState(PhyCardBean phyCardBean) {
		boolean bool=adminMapper.updatePhyCardState(phyCardBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showPhyCardInfo.action?page="+phyCardBean.getPage()+"";
		}
		return result;
	}
	//用户体检卡管理 
	@Override
	public ModelAndView phyCardManagement(UserInfoBean userInfoBean) {
		pageAll=adminMapper.showUserCount(userInfoBean);
		int allPage = 0;
		if (pageAll % 3 != 0) {
			allPage = (pageAll / 3) + 1;
		} else {
			allPage = (pageAll / 3);
		}
		page=userInfoBean.getPage();
		list=adminMapper.phyCardManagement(userInfoBean);
		mav.setViewName("backstage/phyCardManagement");
		mav.addObject("list",list);
		mav.addObject("pageAll",allPage);
		mav.addObject("page",page);
		mav.addObject("list",list);
		mav.addObject("pageAll",allPage);
		mav.addObject("page",page);
		return mav;
	}
	//查询已激活未用体检卡号
	@Override
	public List<PhyCardBean> selectPhyCard() {
		return 	adminMapper.selectPhyCard();
	}
	//提交办卡
	@Override
	public String applyCard(UserInfoBean userInfoBean,PhyCardBean phyCardBean) {
		boolean bool=adminMapper.applyCard(userInfoBean);
		adminMapper.updatePhyCardState(phyCardBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/phyCardManagement.action?page="+userInfoBean.getPage()+"";
		}
		return result;
	}
	//挂失
	@Override
	public String reportTheLossOf(UserInfoBean userInfoBean,PhyCardBean phyCardBean) {
		boolean bool=adminMapper.updatePhyCardState(phyCardBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/phyCardManagement.action?page="+userInfoBean.getPage()+"";
		}
		return result;
	}
	//换卡
	@Override
	public String changeCard(UserInfoBean userInfoBean, PhyCardBean phyCardBean) {
		boolean bool=adminMapper.applyCard(userInfoBean);
		adminMapper.updatePhyCardState(phyCardBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/phyCardManagement.action?page="+userInfoBean.getPage()+"";
		}
		return result;
	}
	@Override
	public String upFile(MultipartFile file) {
		
	/*	String filename = fileact.getOriginalFilename();
		System.out.println("获取到的文件名:" + filename);*/
		Excel excle =new Excel();
		 List<PhyCardBean> listExcel=excle.getExcelInfo(file);
		 for (PhyCardBean phyCardBean : listExcel) {
			 
			 adminMapper.phyCardAdd(phyCardBean);
		 }
		String result=null;
			result="redirect:/ManageAction/showPhyCardInfo.action?page=1";
		return result;
	}

}
