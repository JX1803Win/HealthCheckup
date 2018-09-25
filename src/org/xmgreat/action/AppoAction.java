package org.xmgreat.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.biz.AppoBiz;

@Controller
@RequestMapping("/AppoAction")
public class AppoAction {
	
	@Resource
	private UserPhyRecordBean userPhyRecordBean;
	@Resource
	private AppoBiz appoBizImpl;
	
	@RequestMapping(value = "/addAppo.action")
	public String addAppo(HttpServletRequest request){
//		Integer userId = ((UserInfoBean)request.getSession().getAttribute("user")).getUserId();
		userPhyRecordBean.setUserId(1);
		String time = request.getParameter("time");
		System.out.println(time);
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
		appoBizImpl.addPhyRecord(userPhyRecordBean, time);
		return "";
	}
}
