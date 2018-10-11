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
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bizImpl.RoleBizImpl;
@Controller
@RequestMapping("/role")//整体的访问路劲
public class MenuManageAction {
	@Resource
	public RoleBizImpl roleBizImpl;
	public int pageNo;
	@RequestMapping(value="/menuManager.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllMenu (HttpServletRequest request,HttpServletResponse response,String menuName )throws Exception {
		//一级菜单显示页面
		HttpSession session = request.getSession();
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
		int size=roleBizImpl.getMenuNum(menuName);
		request.setAttribute("sizeF", size);
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
			request.setAttribute("menuName", menuName);
			request.setAttribute("pageNoF", pageNo);
			request.setAttribute("AllPageF", AllPage);
 	   List<PermissionsInfBean> rbList =roleBizImpl.selectAllMenuInfo(menuName,pageNo);	 	  
 	   request.setAttribute("rbListF", rbList); 
  	   ModelAndView mav = new ModelAndView();
  	   mav.setViewName("backstage/menuManager");
  	   return mav;
	}
	//删除父类菜单
	@RequestMapping(value="/delMenu.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  delMenu (HttpServletRequest request,HttpServletResponse response,Integer permissionsId)throws Exception {			   
		roleBizImpl.deltblRolePer(permissionsId);
		roleBizImpl.delPerInfMenu(permissionsId);
		roleBizImpl.delPerInfAllMenu(permissionsId);
		return selectAllMenu(request, response, null);	    
	}
	//添加父类菜单
	@RequestMapping(value="/addFMenu.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  addFMenu (HttpServletRequest request,HttpServletResponse response,String menuNames)throws Exception {			   		
		roleBizImpl.addFMenu(menuNames);
		return selectAllMenu(request, response, null);	    
	}
	//修改父类菜单
	@RequestMapping(value="/updateFMenu.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  updateFMenu (HttpServletRequest request,HttpServletResponse response,Integer upmenuId,String upmenuName)throws Exception {			   			
				roleBizImpl.updateFMenu(upmenuId,upmenuName);
				return selectAllMenu(request, response, null);	    
	}
	@RequestMapping(value="/sonMenu.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllSonMenu (HttpServletRequest request,HttpServletResponse response,Integer permissionsId,String menuName )throws Exception {
		//二级菜单显示页面
		HttpSession session = request.getSession();
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
		int size=roleBizImpl.getSonMenuNum(permissionsId,menuName);
		request.setAttribute("sizeS", size);
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
			request.setAttribute("pageNoS", pageNo);
			request.setAttribute("AllPageS", AllPage);
 	   List<PermissionsInfBean> rbList =roleBizImpl.selectAllSonMenuInfo(permissionsId,pageNo,menuName);	 	  
 	   request.setAttribute("rbListS", rbList); 
  	   ModelAndView mav = new ModelAndView();
  	   mav.setViewName("backstage/sonMenuManager");
  	   return mav;
	}
	//删除子类菜单
	@RequestMapping(value="/delSonMenu.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  delSonMenu (HttpServletRequest request,HttpServletResponse response,Integer permissionsId)throws Exception {			   
		roleBizImpl.deltblRolePer(permissionsId);
		roleBizImpl.delPerInfMenu(permissionsId);
		Integer menuId=roleBizImpl.selectAllFMenus(permissionsId);
		return selectAllSonMenu(request, response,menuId, null);	    
	}
	        //添加子类菜单
			@RequestMapping(value="/addSMenu.action")//为这个方法定义映射子路劲 
			@ResponseBody
			public ModelAndView  addSMenu (HttpServletRequest request,HttpServletResponse response,Integer upperMenu,String menuNames,String url)throws Exception {			   		
				roleBizImpl.addSMenu(upperMenu,menuNames,url);
				return selectAllSonMenu(request, response, upperMenu,null);	    
			}
			
			//修改子类菜单
			@RequestMapping(value="/updateSMenu.action")//为这个方法定义映射子路劲 
			@ResponseBody
			public ModelAndView  updateSMenu (HttpServletRequest request,HttpServletResponse response,Integer upmenuId,String upmenuName,String upurlAddress,Integer uppreMenu)throws Exception {			   			
						roleBizImpl.updateSMenu(upmenuId,upmenuName,upurlAddress);
						return selectAllSonMenu(request, response,uppreMenu, null);	    
			}
			//查询菜单是否已经存在
			@RequestMapping(value="/testaddFMenu.action")//为这个方法定义映射子路劲 
			@ResponseBody						
			public boolean selectRoleAlive(HttpServletRequest request) {
				String menuName=request.getParameter("menuName");
				Boolean bl=roleBizImpl.selectMenuAlive(menuName);
				return bl;
			}	
			
			
			
}
