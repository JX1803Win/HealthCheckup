package org.xmgreat.bizImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.mapper.AdminMapper;
import org.xmgreat.mapper.PermissionsMapper;
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
	@Resource
	private PermissionsMapper permissionsMapper;
	
	@Override
	public List<PermissionsInfBean> selectRoleInfo(Integer roleId) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectRoleInfo(roleId);

	}
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
	public List<ManagerBean> selectAdmin(ManagerBean managerBean) {
		// TODO Auto-generated method stub
		int i =adminMapper.selectAdmin(managerBean);
		
		List<ManagerBean> list = new ArrayList<ManagerBean>();
		ManagerBean manager=new ManagerBean();
		
		if(i>0) {
			manager.setMangerName("已注册");
		}else {
			manager.setMangerName("未注册");
		}
		list.add(manager);
		return list;
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
		mav.addObject("userName",userInfoBean.getUserName());
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
		System.out.println("获取到的文件名");
		String filename = file.getOriginalFilename();
		System.out.println("获取到的文件名:" + filename);
		 Excel excle =new Excel();
		 List<PhyCardBean> listExcel=excle.getExcelInfo(file);
	 for (PhyCardBean phyCardBean : listExcel) {
		int i= adminMapper.selectPhyCardId( phyCardBean);
		if(i<0) {
			 adminMapper.phyCardAdd(phyCardBean);
		}
		 }
		
		String result=null;
			result="redirect:/ManageAction/showPhyCardInfo.action?page=1";
		return result;
	}
	//项目收费
	@Override
	public ModelAndView selectProject(UserPhyRecordBean userPhyRecordBean) {
		// TODO Auto-generated method stub
		List<UserPhyRecordBean> lisUserPhy=adminMapper.selectPhysicaiInfo(userPhyRecordBean);
		System.out.println("套餐ID"+lisUserPhy.get(0).getSetmealId());
		System.out.println("项目ID"+	lisUserPhy.get(0).getProjectId());
		mav.setViewName("backstage/chargeWork");
		mav.addObject("lisUserPhy",lisUserPhy);
		if(lisUserPhy.get(0).getSetmealId()!=null) {//查套餐下的项目
			list=adminMapper.selectProjectInfo(lisUserPhy.get(0).getSetmealId());
			Double charge =adminMapper.charge(lisUserPhy.get(0).getSetmealId());
			mav.addObject("list",list);
			mav.addObject("charge",charge);
		}
		if(lisUserPhy.get(0).getProjectId()!=null) {//查项目
			list=adminMapper.selectProjectInfo2(lisUserPhy.get(0).getProjectId());
			mav.addObject("list",list);
		}
		return mav;
	}
	//结账
	@Override
	public List<CityBean> settleAccount(Double charge,Integer userId,Integer physicaiId) {
		List<CityBean> list = new ArrayList<CityBean>();
		/*System.out.println(userId+"用户ID");
		System.out.println(charge+"合计");
		System.out.println(physicaiId+"体检号");*/
		UserAccoutBean userAccoutBean=adminMapper.selectBalance(userId);
		Double balance=userAccoutBean.getBalance()-charge;
		UserAccoutBean userAccout=new UserAccoutBean();
		userAccout.setUserId(userId);
		userAccout.setBalance(balance);
		userAccout.setMoney(charge);
		userAccout.setOccurMatter("扣费");
		CityBean cityBean=new CityBean();
		if(userAccoutBean.getBalance()>charge) {
			adminMapper.closeAccount(physicaiId);
			adminMapper.addRecord(userAccout);
			cityBean.setCityName("扣费成功");
			cityBean.setCityId(21);
			
		}else{
			cityBean.setCityName("余额不足");
		}
		
		list.add(cityBean);
		return list;
	}
	//流水账
	@Override
	public ModelAndView selectAccount(UserInfoBean userInfoBean) {
		/*System.out.println(userInfoBean.getUserId());
		System.out.println(userInfoBean.getPage());*/
		pageAll=adminMapper.selectAccountAll(userInfoBean);
		int allPage = 0;
		if (pageAll % 3 != 0) {
			allPage = (pageAll / 3) + 1;
		} else {
			allPage = (pageAll / 3);
		}
		page=userInfoBean.getPage();
		
		UserInfoBean userInfo=adminMapper.selectUserInfo(userInfoBean);
		
		list=adminMapper.selectAccount(userInfoBean);
		UserAccoutBean userAccoutBean=adminMapper.selectBalance(userInfoBean.getUserId());
		mav.addObject("list",list);
		mav.addObject("pageAll",allPage);
		mav.addObject("page",page);
		mav.addObject("userName",userInfo.getUserName());
		mav.addObject("userAge",userInfo.getAge());
		mav.addObject("userSex",userInfo.getSex());
		mav.addObject("page",page);
		if(null == userAccoutBean) {
			mav.addObject("balance", 0);
		} else {
			mav.addObject("balance",userAccoutBean.getBalance());
		}
		mav.addObject("userId",userInfoBean.getUserId());
		mav.setViewName("backstage/userAccount");
		return mav;
	}
	//充值
	@Override
	public String topUp(UserAccoutBean userAccoutBean) {
		System.out.println(userAccoutBean.getUserId());
		System.out.println(userAccoutBean.getMoney());
		
		Integer userId=userAccoutBean.getUserId();
		UserAccoutBean userAccout=adminMapper.selectBalance(userId);
		if(null == userAccout) {
			userAccout = new UserAccoutBean();
			userAccout.setBalance(0D);
		}
		Double balance=userAccout.getBalance()+userAccoutBean.getMoney();
		UserAccoutBean accout=new UserAccoutBean();
		accout.setUserId(userId);
		accout.setBalance(balance);
		accout.setMoney(userAccoutBean.getMoney());
		accout.setOccurMatter("充值");
		adminMapper.addRecord(accout);
		String result=null;
		result="redirect:/ManageAction/selectAccount.action?page=1&&userId="+userAccoutBean.getUserId()+"";
	return result;
	}
	//跳转前端用户注册
	@Override
	public ModelAndView userAdd() {
		list=adminMapper.selectProvince();
		mav.addObject("listProvince",list);
		mav.setViewName("backstage/userAdd");
		return mav;
	}
	//前端用户注册
	@Override
	public String regUser(UserInfoBean userInfoBean) {
		boolean bool=adminMapper.regUser(userInfoBean);
		String result=null;
		if(bool==true) {
			result="redirect:/ManageAction/showUser.action?page=1";
		}
		return result;
	}
	//查询用户是否已经被注册
	@Override
	public List<UserInfoBean> selectUser(UserInfoBean userInfoBean) {
		int i =adminMapper.selectUser(userInfoBean);
		List<UserInfoBean> list = new ArrayList<UserInfoBean>();
		UserInfoBean userInfo=new UserInfoBean();
		
		if(i>0) {
			userInfo.setUserName("已注册");
		}else {
			userInfo.setUserName("未注册");
		}
		list.add(userInfo);
		return list;
	}
	
	//退费
	@Override
	public List<UserInfoBean> refund(Double money, Integer userId) {
		List<UserInfoBean> list = new ArrayList<UserInfoBean>();
		UserInfoBean userInfo=new UserInfoBean();
		UserAccoutBean userAccout=adminMapper.selectBalance(userId);
		if(userAccout.getBalance()<money||userAccout.getBalance()==0) {
			userInfo.setUserName("余额不足");
		}else {
		Double balance=userAccout.getBalance()-money;
		UserAccoutBean accout=new UserAccoutBean();
		accout.setUserId(userId);
		accout.setBalance(balance);
		accout.setMoney(money);
		accout.setOccurMatter("退款");
		adminMapper.addRecord(accout);
		userInfo.setUserName("退款成功");
		}
		list.add(userInfo);
		return list;
	}
	
	//支付宝充值
	@Override
	public String zhifubao(Integer userId, Double money) {
		UserAccoutBean userAccout=adminMapper.selectBalance(userId);
		Double balance=userAccout.getBalance()+money;
		UserAccoutBean accout=new UserAccoutBean();
		accout.setUserId(userId);
		accout.setBalance(balance);
		accout.setMoney(money);
		accout.setOccurMatter("支付宝充值");
		adminMapper.addRecord(accout);
		String result=null;
	/*	result="redirect:/ManageAction/selectAccount.action?page=1&&userId="+userId+"";*/
		result="redirect:/admin/login.action";
		return result;
	}
}
