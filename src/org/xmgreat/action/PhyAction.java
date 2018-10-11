package org.xmgreat.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.PhyBiz;

/**
 * @author 宋卓伟
 * @date 2018年9月26日
 * @description 用户体检
 */

@Controller
@RequestMapping("/PhyAction")
public class PhyAction {
	@Resource
	private UserPhyRecordBean userPhyRecordBean;
	@Resource
	private PhyBiz phyBizImpl;
	private Integer currentPage;
	private Integer totalPage;
	private Integer total;
	
	/**
	 * @description 预约体检
	 * @param request 请求
	 * @return 预约界面
	 */
	@RequestMapping(value = "/addPhy.action")
	public String addPhy(HttpServletRequest request){
		Integer userId = ((UserInfoBean)request.getSession().getAttribute("user")).getUserId();
//		Integer userId = 1005;
		userPhyRecordBean.setUserId(userId);
		String time = request.getParameter("time");
		System.out.println(time);
		Integer setmealId = null;
		Integer projectId = null;
		Double cost = null;
		Double balance = phyBizImpl.queryUserAcc(userId).getBalance();
		if(request.getParameter("combo") != "") {
			System.out.println(request.getParameter("combo"));
			setmealId = Integer.parseInt(request.getParameter("combo"));
			cost = phyBizImpl.querySetmealCost(setmealId);
			userPhyRecordBean.setSetmealId(setmealId);
		} else {
			System.out.println(request.getParameter("project"));
			projectId = Integer.parseInt(request.getParameter("project"));
			cost = phyBizImpl.queryProjectCost(projectId);
			userPhyRecordBean.setProjectId(projectId);
		}
		if(cost <= balance) {
			userPhyRecordBean.setAppoTime(time);
			phyBizImpl.addPhyRecord(userPhyRecordBean);
			request.setAttribute("msg", "预约成功");
		} else {
			request.setAttribute("msg", "您的余额不足！");
		}
		return goAppo();
	}
	
	/**
	 * @description 体检开单
	 * @param request 请求
	 * @return 开单页面
	 */
	@RequestMapping(value = "/billing.action")
	public String billing(HttpServletRequest request){
		Long physicaiId = Long.parseLong(request.getParameter("physicaiId"));
		System.out.println(physicaiId);
		Integer setmealId = null;
		Integer projectId = null;
		if(request.getParameter("combo") != "") {
			System.out.println(request.getParameter("combo"));
			setmealId = Integer.parseInt(request.getParameter("combo"));
			userPhyRecordBean.setSetmealId(setmealId);
		} else {
			System.out.println(request.getParameter("project"));
			projectId = Integer.parseInt(request.getParameter("project"));
			userPhyRecordBean.setProjectId(projectId);
		}
		if(phyBizImpl.queryUserByPhyCardId(physicaiId) != null) {
			request.setAttribute("physicaiId", phyBizImpl.billing(physicaiId, setmealId, projectId));
		} else {
			request.setAttribute("msg", "开单失败，体检卡号错误！");
		}
		return goBilling();
	}
	
	@RequestMapping("/goBilling.action")
	public String goBilling() {
		return "backstage/billing";
	}
	
	@RequestMapping("/goAppo.action")
	public String goAppo() {
		return "user/appointment";
	}
	
	@RequestMapping("/queryAllSetmeal.action")
	public @ResponseBody List<SetmealBean> queryAllSetmeal() {
		return phyBizImpl.queryAllSetmeal();
	}
	
	@RequestMapping("/queryAllProject.action")
	public @ResponseBody List<ProjectBean> queryAllProject() {
		return phyBizImpl.queryAllProject();
	}
	
	@RequestMapping("/queryUserBalance.action")
	public @ResponseBody Double queryUserBalance(HttpServletRequest request) {
		Integer userId = ((UserInfoBean)request.getSession().getAttribute("user")).getUserId();
		return phyBizImpl.queryUserAcc(userId).getBalance();
	}
	
	@RequestMapping("/queryAppo.action")
	public String queryAppo(HttpServletRequest request) {
		Integer userId = ((UserInfoBean)request.getSession().getAttribute("user")).getUserId();
//		Integer userId = 1005;
		if(currentPage == null || request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("当前页："+currentPage);
		request.setAttribute("currentPage", currentPage);
		total = phyBizImpl.queryUserAppoCount(userId);
		totalPage = (int)Math.ceil((double)total/5);
		System.out.println("总页数："+totalPage);
		request.setAttribute("uprbList", phyBizImpl.queryUserAppo(userId, currentPage));
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		return "user/appoList";
	}
	
	@RequestMapping("/cancel.action")
	public String cancel(HttpServletRequest request) {
		Long physicaiId = Long.parseLong(request.getParameter("physicaiId"));
		if(phyBizImpl.cancel(physicaiId)) {
			request.setAttribute("cancel", "取消成功");
		} else {
			request.setAttribute("cancel", "取消失败");
		}
		return queryAppo(request);
	}
}
