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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.util.Excel;

import com.google.gson.Gson;

//前后端用户管理
@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/ManageAction")
public class ManageAction {

	@Autowired
	AdminBiz adminBizImpl;

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

	// 查询城市
	@RequestMapping(value = "/selectCity.action")
	public @ResponseBody List<CityBean> selectCity(CityBean cityBean) {
		return adminBizImpl.selectCity(cityBean);

	}

	// 查询用户是否已注册
	@RequestMapping(value = "/selectAdmin.action")
	public @ResponseBody String selectAdmin(ManagerBean managerBean) {

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
	public String upFile(MultipartFile fileact) {
		
		/*try {
			fileact.transferTo(new File("D:/" + filename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userinfo");
*/
		return adminBizImpl.upFile();
	}

}
