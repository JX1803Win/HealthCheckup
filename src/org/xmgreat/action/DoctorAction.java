package org.xmgreat.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import jxl.format.Colour;

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
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.TriMouthBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.bean.WeekBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.bizImpl.DoctorBizImpl;
import org.xmgreat.util.DateUtils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;





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
	    	if (uprbList.get(i).getProjectId()!=null) {//查询项目名
				ProjectBean pb=doctorBizImpl.selectitemName(uprbList.get(i).getProjectId());
				uprbList.get(i).setProjectName(pb.getItemName());
			}
	    	if (uprbList.get(i).getParameterId()!=null) {//查询参数名
		    	ParameterBean prb=doctorBizImpl.selectParameterName(uprbList.get(i).getParameterId());    	
					uprbList.get(i).setParameterName(prb.getParameterName());   	
			}

		}
  	    session.setAttribute("uprbList", uprbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/doctorAccept");
  	    return mav;
	}
	
	@RequestMapping(value="/doctorAccept.action")
	public ModelAndView doctorAccept(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String proresId= request.getParameter("proresId");
		int proresIds=0;
		if (proresId!=null) {
			proresIds=Integer.parseInt(proresId);
		}
		doctorBizImpl.updateAcceptState(proresIds);
		return selectAllRole(request,response,0);
	}
	@RequestMapping(value = "/skipExamination")
	public String skipExamination(HttpServletRequest request, Integer projectId, Integer proresId)
	{

		ProjectBean project = summaryBiz.skipExamination(projectId);
		request.setAttribute("proresId", proresId);
		request.setAttribute("project", project);
		return "backstage/examination";
	}
	
}
