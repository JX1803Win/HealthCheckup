package org.xmgreat.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.bizImpl.DoctorBizImpl;






@Controller
@RequestMapping("/doctor")
public class DoctorAction {
	@Resource
	public DoctorBizImpl doctorBizImpl;
	@Resource
	private SummaryBiz summaryBiz;
	public int pageNo;
	@RequestMapping(value="/projectInf.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllRole (HttpServletRequest request,HttpServletResponse response,Integer physicaiId)throws Exception {
		HttpSession session = request.getSession();
		ManagerBean managerBean=(ManagerBean) session.getAttribute("admin");
		int officeId=managerBean.getOfficeId();
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
		int size=doctorBizImpl.selectUserPhyRecNum(officeId,physicaiId);
		request.setAttribute("sizeD", size);
  	    int AllPage = 0;
			if (size % 5 != 0) {
				AllPage = (size / 5) + 1;
			} else {
				AllPage = (size / 5);
			}			
			if (0 == pageNo) {
				pageNo = 1;
			} else {				
				if (pageNo < 1) {
					pageNo = 1;
				} else if (pageNo > AllPage) {
					pageNo = AllPage;
				}
			}  
		request.setAttribute("pageNoD", pageNo);
		request.setAttribute("AllPageD", AllPage);
	    List<ProjectResultBean> uprbList=doctorBizImpl.selectUserPhyRec(officeId,physicaiId,pageNo);
	    
	    for (int i = 0; i < uprbList.size(); i++) {	    	
	    	if (uprbList.get(i).getPhysicaiId()!=null) {//查询用户名
	    		UserInfoBean uib=doctorBizImpl.selectUserName(uprbList.get(i).getPhysicaiId());
	    		uprbList.get(i).setUserName(uib.getUserName()); 
			}
	    	if (uprbList.get(i).getProjectBean().getProjectId()!=null) {//查询项目名
				ProjectBean pb=doctorBizImpl.selectitemName(uprbList.get(i).getProjectBean().getProjectId());
				uprbList.get(i).setProjectName(pb.getItemName());
			}
	    	if (uprbList.get(i).getParameterId()!=null) {//查询参数名
		    	ParameterBean prb=doctorBizImpl.selectParameterName(uprbList.get(i).getParameterId());    	
					uprbList.get(i).setParameterName(prb.getParameterName());   	
			}

		}
	    request.setAttribute("physicaiId", physicaiId);
  	    session.setAttribute("uprbList", uprbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/doctorAccept");
  	    return mav;
	}
	
	@RequestMapping(value="/doctorAccept.action")
	public ModelAndView doctorAccept(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String proresId= request.getParameter("proresId");
		HttpSession session = request.getSession();
		ManagerBean managerBean=(ManagerBean) session.getAttribute("admin");
		String physicaiId=request.getParameter("physicaiId");
		Integer physicaiIds=null;
		if (physicaiId!=null) {
			physicaiIds=Integer.parseInt(physicaiId);
			
		}
		if (proresId!=null) {
			int proresIds=Integer.parseInt(proresId);
			doctorBizImpl.updateAcceptState(proresIds,managerBean.getAdminId());
			
		}
		
		return selectAllRole(request,response,physicaiIds);
	}
	@RequestMapping(value = "/skipExamination")
	public String skipExamination(HttpServletRequest request, Integer projectId, Integer proresId)
	{
		ProjectBean project = summaryBiz.skipExamination(projectId);
		request.setAttribute("proresId", proresId);
		request.setAttribute("project", project);
		return "backstage/examination";
	}
	@RequestMapping(value = "/particular")
	public String particular(HttpServletRequest request, Integer proresId, Integer parameterId, Integer currentPage)
	{
		ProjectResultBean projectResultBean = summaryBiz.skipSummary(proresId);
		request.setAttribute("projectResult", projectResultBean);
		request.setAttribute("parameterId", parameterId);
		request.setAttribute("currentPage", currentPage);
		return "backstage/userAcceptInf";
	}
	
	@RequestMapping(value = "/generalSummary")
	public ModelAndView generalSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String[] result,
			String projectResult, Integer parameterId) throws Exception
	{
		summaryBiz.generalSummary(proresId, subentryId, result, projectResult, parameterId);
		return selectAllRole(request, null, null);
	}
	
	@RequestMapping(value = "/projectSummary")
	public ModelAndView projectSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String[] result,
			String projectResult, Integer parameterId) throws Exception
	{
		summaryBiz.projectSummary(proresId, subentryId, result, projectResult, parameterId);
		return selectAllRole(request, null, null);
	}

	@RequestMapping(value = "/imageSummary")
	public ModelAndView imageSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String projectResult,
			Integer parameterId) throws Exception
	{
		summaryBiz.imageSummary(proresId, subentryId, request, projectResult, parameterId);
		return selectAllRole(request, null, null);
	}
	
}
