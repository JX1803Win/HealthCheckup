package org.xmgreat.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.util.ALiPay;
import org.xmgreat.util.Excel;

import com.alipay.api.AlipayApiException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

//前后端用户管理
@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/ManageAction")
public class ManageAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	AdminBiz adminBizImpl;
	ModelAndView mav = new ModelAndView();

	// 前端用户管理
	@RequestMapping(value = "/showUser.action")
	public ModelAndView showUser(HttpServletRequest request, UserInfoBean userInfoBean) {

		return adminBizImpl.showUser(userInfoBean);
	}

	// 修改用户状态
	@RequestMapping(value = "/updateUserState.action")
	public String updateUserState(HttpServletRequest request, UserInfoBean userInfoBean) {

		return adminBizImpl.updateUserState(userInfoBean);
	}

	// 修改用户密码
	@RequestMapping(value = "/updateUserPwd.action")
	public String updateUserPwd(HttpServletRequest request, UserInfoBean userInfoBean) {

		return adminBizImpl.updateUserPwd(userInfoBean);
	}

	// 后端用户管理
	@RequestMapping(value = "/showAdmin.action")
	public ModelAndView showAdmin(HttpServletRequest request, ManagerBean managerBean) {

		return adminBizImpl.showAdmin(managerBean);
	}

	// 修改后台用户状态
	@RequestMapping(value = "/updateAdminState.action")
	public String updateAdminState(HttpServletRequest request, ManagerBean managerBean) {

		return adminBizImpl.updateAdminState(managerBean);
	}

	// 修改后台用户状态
	@RequestMapping(value = "/updateAdminPwd.action")
	public String updateAdminPwd(HttpServletRequest request, ManagerBean managerBean) {

		return adminBizImpl.updateAdminPwd(managerBean);
	}

	// 进入后端注册界面
	@RequestMapping(value = "/adminAdd.action")
	public ModelAndView adminAdd() {
		return adminBizImpl.adminAdd();

	}

	// 进入后端用户注册界面
	@RequestMapping(value = "/userAdd.action")
	public ModelAndView userAdd() {
		return adminBizImpl.userAdd();

	}

	// 增加用户
	@RequestMapping(value = "/regUser.action")
	public String regUser(UserInfoBean userInfoBean) {

		return adminBizImpl.regUser(userInfoBean);
	}
	// 查询用户是否已注册
		@RequestMapping(value = "/selectUser.action")
		public @ResponseBody List<UserInfoBean> selectUser(UserInfoBean userInfoBean) {
			return adminBizImpl.selectUser(userInfoBean);

		}

	// 查询城市
	@RequestMapping(value = "/selectCity.action")
	public @ResponseBody List<CityBean> selectCity(CityBean cityBean) {
		return adminBizImpl.selectCity(cityBean);

	}

	// 查询用户是否已注册
	@RequestMapping(value = "/selectAdmin.action")
	public @ResponseBody List<ManagerBean> selectAdmin(ManagerBean managerBean) {

		return adminBizImpl.selectAdmin(managerBean);

	}

	// 增加用户
	@RequestMapping(value = "/regAdmin.action")
	public String addAdmin(ManagerBean managerBean) {

		return adminBizImpl.addAdmin(managerBean);
	}

	// 体检卡管理
	@RequestMapping(value = "/showPhyCardInfo.action")
	public ModelAndView showPhyCardInfo(PhyCardBean phyCardBean) {

		return adminBizImpl.showPhyCardInfo(phyCardBean);
	}

	// 修改后台用户状态
	@RequestMapping(value = "/updatePhyCardState.action")
	public String updatePhyCardState(PhyCardBean phyCardBean) {

		return adminBizImpl.updatePhyCardState(phyCardBean);
	}

	// 用户体检卡管理
	@RequestMapping(value = "/phyCardManagement.action")
	public ModelAndView phyCardManagement(UserInfoBean userInfoBean) {

		return adminBizImpl.phyCardManagement(userInfoBean);
	}

	// 查询以激活未用体检卡
	@RequestMapping(value = "/selectPhyCard.action")
	public @ResponseBody List<PhyCardBean> selectPhyCard() {

		return adminBizImpl.selectPhyCard();
	}

	// 提交办卡
	@RequestMapping(value = "/applyCard.action")
	public String applyCard(UserInfoBean userInfoBean, PhyCardBean phyCardBean) {

		return adminBizImpl.applyCard(userInfoBean, phyCardBean);
	}

	// 挂失
	@RequestMapping(value = "/reportTheLossOf.action")
	public String reportTheLossOf(UserInfoBean userInfoBean, PhyCardBean phyCardBean) {

		return adminBizImpl.reportTheLossOf(userInfoBean, phyCardBean);
	}

	// 换卡
	@RequestMapping(value = "/changeCard.action")
	public String changeCard(UserInfoBean userInfoBean, PhyCardBean phyCardBean) {

		return adminBizImpl.changeCard(userInfoBean, phyCardBean);
	}

	// 上传体检卡号
	@RequestMapping(value = "/upFile.action", method = RequestMethod.POST)
	public String upFile(@RequestParam(value = "fileact", required = false) MultipartFile fileact)
			throws IllegalStateException, Exception {
		System.out.println(fileact);
		String filename = fileact.getOriginalFilename();
		System.out.println("获取到的文件名apppp：" + filename);
		String root = request.getServletContext().getRealPath("/upload");//// 设置文件上传的路径
		System.out.println("获取到的文件名a1：" + root);
		fileact.transferTo(new File(root + "/" + filename));
		return adminBizImpl.upFile(fileact);
	}

	// 结算界面
	@RequestMapping(value = "/chargeWork.action")
	public ModelAndView chargeWork() {
		mav.setViewName("backstage/chargeWork");
		return mav;
	}

	// 项目收费信息
	@RequestMapping(value = "/selectProject.action")
	public ModelAndView selectProject(UserPhyRecordBean userPhyRecordBean) {

		return adminBizImpl.selectProject(userPhyRecordBean);

	}

	// 结账
	@RequestMapping(value = "/settleAccount.action")
	public @ResponseBody List<CityBean> settleAccount(Double charge, Integer userId, Integer physicaiId) {
		return adminBizImpl.settleAccount(charge, userId, physicaiId);

	}

	// 结算界面
	@RequestMapping(value = "/userAccount.action")
	public ModelAndView userAccount() {
		mav.setViewName("backstage/userAccount");
		return mav;
	}

	// 查询流水账
	@RequestMapping(value = "/selectAccount.action")
	public ModelAndView selectAccount(UserInfoBean userInfoBean) {
		return adminBizImpl.selectAccount(userInfoBean);
	}

	// 充值
	@RequestMapping(value = "/topUp.action")
	public String topUp(UserAccoutBean userAccoutBean) {

		return adminBizImpl.topUp(userAccoutBean);
	}
	
	// 退款
	@RequestMapping(value = "/refund.action")
	public @ResponseBody List<UserInfoBean> refund(Double money, Integer userId) {
		return adminBizImpl.refund( money,userId);

	}
	
	// 支付宝支付
	@RequestMapping(value = "/alipayment.action")
	public ModelAndView alipayment(HttpServletRequest request,HttpServletResponse response,Integer userId,Double money) throws AlipayApiException {
		String money1=money.toString();
		String result;
		try {
			result = ALiPay.pay(response, money1,userId);
			mav.addObject("result",result);
			mav.setViewName("backstage/QR.code");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
}
