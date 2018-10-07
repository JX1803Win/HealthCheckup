package org.xmgreat.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.PhyBiz;

@Controller
@RequestMapping("/PhySumAction")
public class PhySumAction {
	@Resource
	private PhyBiz phyBizImpl;
	private Integer currentPage;
	private Integer totalPage;
	private Integer total;
	private Long physicaiId;
	private Long phyId;
	@Resource
	private UserPhyRecordBean userPhyRecordBean;
	
	@RequestMapping("/query.action")
	public String query(HttpServletRequest request) {
		if(request.getParameter("physicaiId") != null) {
			physicaiId = Long.parseLong(request.getParameter("physicaiId"));
			request.setAttribute("physicaiId", physicaiId);
		}
		if(currentPage == null || request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("当前页："+currentPage);
		request.setAttribute("currentPage", currentPage);
		total = phyBizImpl.countOfSummary(physicaiId);
		totalPage = (int)Math.ceil((double)total/5);
		System.out.println("总页数："+totalPage);
		request.setAttribute("uprbList", phyBizImpl.querySummary(physicaiId, currentPage));
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		return "backstage/phySum";
	}
	
	@RequestMapping("/look.action")
	public String look(HttpServletRequest request) {
		phyId = Long.parseLong(request.getParameter("physicaiId"));
		request.setAttribute("uprb", phyBizImpl.queryByPhyId(phyId));
		request.setAttribute("proResList", phyBizImpl.queryProResByPhysicaiId(phyId));
		return "backstage/lookPhySum";
	}
	
	@RequestMapping("/write.action")
	public String write(HttpServletRequest request) {
		phyId = Long.parseLong(request.getParameter("physicaiId"));
		request.setAttribute("uprb", phyBizImpl.queryByPhyId(phyId));
		request.setAttribute("proResList", phyBizImpl.queryProResByPhysicaiId(phyId));
		return "backstage/writePhySum";
	}
	
	@RequestMapping("/submit.action")
	public String submit(HttpServletRequest request) {
		String phyConad = request.getParameter("phyConad");
		String guidance = request.getParameter("guidance");
		Integer adminId = ((ManagerBean)request.getSession().getAttribute("admin")).getAdminId();
//		Integer adminId = 10000;
		userPhyRecordBean.setAdminId(adminId);
		userPhyRecordBean.setPhyConad(phyConad);
		userPhyRecordBean.setGuidance(guidance);
		userPhyRecordBean.setPhysicaiId(phyId);
		phyBizImpl.writeSummary(userPhyRecordBean);
		return query(request);
	}
}
