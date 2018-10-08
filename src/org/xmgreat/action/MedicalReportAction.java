package org.xmgreat.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.xmgreat.bean.MouthBean;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.TriMouthBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.bean.WeekBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.bizImpl.DoctorBizImpl;
import org.xmgreat.util.DateUtils;

@Controller
@RequestMapping("/doctor")
public class MedicalReportAction {

	@Resource
	public DoctorBizImpl doctorBizImpl;
	@Resource
	private SummaryBiz summaryBiz;
	public int pageNo;
	
	@RequestMapping(value="/userPhyRecordInf.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectuserPhyRecInf (HttpServletRequest request,HttpServletResponse response,String userName,Long phone,Long barCode,String starDay,String end)throws Exception {
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
		if (phone==null) {
			phone=(long) 0;
		}
		if (barCode==null) {
			barCode=(long) 0;
		}
		int size=doctorBizImpl.selectUserPhyNum(userName, phone, barCode, starDay,end);
		request.setAttribute("sizeU", size);
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
			
		request.setAttribute("pageNoU", pageNo);
		request.setAttribute("AllPageU", AllPage);
	    List<UserPhyRecordBean> uprbList=doctorBizImpl.selectUserPhy(userName, phone, barCode, starDay,end, pageNo);
	    for (int i = 0; i < uprbList.size(); i++) {
	    	
	    	if (uprbList.get(i).getProjectId()!=null) {//查询项目名
				ProjectBean pb=doctorBizImpl.selectitemName(uprbList.get(i).getProjectId());
				uprbList.get(i).setItemName(pb.getItemName());
			}
	    	if (uprbList.get(i).getSetmealId()!=null) {//查询套餐名
		    	SetmealBean sb=doctorBizImpl.selectSetmealName(uprbList.get(i).getSetmealId());    	
					uprbList.get(i).setSetmealName(sb.getSetmealName());   	
			}

		}	    
	    request.setAttribute("uprbList", uprbList);    
		ModelAndView mav = new ModelAndView();
	  	mav.setViewName("backstage/SelectUserInf");
	  	return mav;
	}
	@RequestMapping(value="/projectResult.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public List<ProjectResultBean>  selectProjectResult (HttpServletRequest request,HttpServletResponse response)throws Exception {
		Integer setmealId=0;
		Integer physicaiId=0;
		if (request.getParameter("setmealId")!=null&&request.getParameter("setmealId")!="") {
			setmealId=Integer.valueOf(request.getParameter("setmealId"));
		}	
		if (request.getParameter("physicaiId")!=null&&request.getParameter("physicaiId")!="") {
		physicaiId=Integer.valueOf(request.getParameter("physicaiId"));
		}
		List<ProjectResultBean> prbList=doctorBizImpl.selectProjectResult(setmealId,physicaiId);
		 for (int i = 0; i < prbList.size(); i++) {		    	
		    	if (prbList.get(i).getProjectId()!=null) {//查询项目名
					ProjectBean pb=doctorBizImpl.selectitemName(prbList.get(i).getProjectId());
					String itemName=pb.getItemName();
					prbList.get(i).setProjectName(itemName);
					if (prbList.get(i).getProjectResult()==null&&prbList.get(i).getProjectResult()=="") {
						prbList.get(i).setProjectResult("未小结");
					}
				}		    	
			}
		return prbList;
	}
	
	@RequestMapping(value="/projectResults.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public List<ProjectResultBean>  selectProjectResults (HttpServletRequest request,HttpServletResponse response)throws Exception {
		Integer projectId=0;
		Integer physicaiId=0;
		if (request.getParameter("projectId")!=null&&request.getParameter("projectId")!="") {
			projectId=Integer.valueOf(request.getParameter("projectId"));
		}	
		if (request.getParameter("physicaiId")!=null&&request.getParameter("physicaiId")!="") {
		physicaiId=Integer.valueOf(request.getParameter("physicaiId"));
		}
		List<ProjectResultBean> prbList=doctorBizImpl.selectProjectResults(projectId,physicaiId);
		 for (int i = 0; i < prbList.size(); i++) {		    	
		    	if (prbList.get(i).getProjectId()!=null) {//查询项目名
					ProjectBean pb=doctorBizImpl.selectitemName(prbList.get(i).getProjectId());
					String itemName=pb.getItemName();					
					prbList.get(i).setProjectName(itemName);
					if (prbList.get(i).getProjectResult()==null&&prbList.get(i).getProjectResult()=="") {
						
						prbList.get(i).setProjectResult("未小结");
					}
				}		    	
			}
		return prbList;
	}
	


}
