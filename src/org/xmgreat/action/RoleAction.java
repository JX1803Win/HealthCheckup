package org.xmgreat.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bizImpl.RoleBizImpl;

import com.google.gson.Gson;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;



@Controller
@RequestMapping("/role")//整体的访问路劲
public class RoleAction {
	@Resource
	public RoleBizImpl roleBizImpl;
	public int pageNo;
	@RequestMapping(value="/blackuserLogin.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView selectAllRole (HttpServletRequest request,HttpServletResponse response,String roleName )throws Exception {
		HttpSession session = request.getSession();
		String aString=request.getParameter("pageNo");
		if (aString!=null) {
			pageNo=Integer.parseInt(aString);
		}
		int size=roleBizImpl.getRoleNum(roleName);
		session.setAttribute("sizeL", size);
  	    int AllPage = 0;
			if (size % 3 != 0) {
				AllPage = (size / 3) + 1;
			} else {
				AllPage = (size / 3);
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
		session.setAttribute("pageNo", pageNo);
		session.setAttribute("AllPage", AllPage);
 	    List<RoleBean> rbList =roleBizImpl.selectAllRoleInfo(roleName,pageNo);
  	    session.setAttribute("rbList", rbList); 
  	    ModelAndView mav = new ModelAndView();
  	    mav.setViewName("backstage/roleManager");
  	    return mav;
	}
	//删除角色
	@RequestMapping(value="/del.action")//为这个方法定义映射子路劲 
	@ResponseBody
	public ModelAndView  dellRole (HttpServletRequest request,HttpServletResponse response,Integer roleId)throws Exception {			   
		roleBizImpl.delManageRole(roleId);
		roleBizImpl.delRole(roleId);
		roleBizImpl.deltblRulePermissions(roleId);
		return selectAllRole(request, response, null);	    
	}
     //添加角色
	@RequestMapping(value="/add.action")//为这个方法定义映射子路劲 	
	public ModelAndView  addRole (HttpServletRequest request,HttpServletResponse response,String roleNames)throws Exception {			   		
		roleBizImpl.addRole(roleNames);
		return selectAllRole(request, response, null);	    
	}
	 //修改角色名
		@RequestMapping(value="/update.action")//为这个方法定义映射子路劲 
		@ResponseBody
		public ModelAndView  updateRole (HttpServletRequest request,HttpServletResponse response,Integer uproleId,String uproleName)throws Exception {			   			
			roleBizImpl.updateRole(uproleId,uproleName);
			return selectAllRole(request, response, null);	    
		}
	//权限管理
		@RequestMapping(value="/allRoles.action")//为这个方法定义映射子路劲 
		@ResponseBody
		public ModelAndView selectAllRoles (HttpServletRequest request,HttpServletResponse response,String roleName )throws Exception {
//			HttpSession session = request.getSession();
			String aString=request.getParameter("pageNo");
			if (aString!=null) {
				pageNo=Integer.parseInt(aString);
			}
			int size=roleBizImpl.getRoleNum(roleName);
			request.setAttribute("sizeL", size);
	  	    int AllPage = 0;
				if (size % 3 != 0) {
					AllPage = (size / 3) + 1;
				} else {
					AllPage = (size / 3);
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
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("AllPage", AllPage);
	 	    List<RoleBean> rbList =roleBizImpl.selectAllRoleInfo(roleName,pageNo);
	 	    request.setAttribute("rbList", rbList); 
	  	    ModelAndView mav = new ModelAndView();
	  	    mav.setViewName("backstage/permissionsMagr");
	  	    return mav;
		}	
		//获得角色下的菜单
		@ResponseBody
		@RequestMapping(value="/permissionsMagr.action")		
		public  Map<String, List<PermissionsInfBean>> selectPermissionsMagr(HttpServletRequest request){			
			String roleName=request.getParameter("userName");
			HttpSession session=request.getSession();
			session.setAttribute("theNextUser", roleName);
			Map<String, List<PermissionsInfBean>> pibMap=new HashMap<String,List<PermissionsInfBean>>();
			List<PermissionsInfBean> list1=roleBizImpl.selectAllMenu();
			List<PermissionsInfBean> list2=roleBizImpl.selectAllFMenu();
			List<PermissionsInfBean> list3=roleBizImpl.selectAllMenuRole(roleName);
			List<PermissionsInfBean> list4=roleBizImpl.selectAllFMenuRole(roleName);
			pibMap.put("a1", list1);
			pibMap.put("a2", list2);
			pibMap.put("a3", list3);
			pibMap.put("a4", list4);			
			return pibMap;
		}
		@ResponseBody
		@RequestMapping(value="/permission.action")
		public ModelAndView  permission (HttpServletRequest request,HttpServletResponse response,String menuName,String roleName)throws Exception {			   			
			//查询菜单下的权限id（list）
			List<PermissionsInfBean> pb = new ArrayList<PermissionsInfBean>();			
			if (menuName!=null && menuName!="") {
				String [] menuNames = menuName.split("\\s+");				
	            for (int i = 1; i < menuNames.length; i++) {
	            	System.out.println(menuNames[i]);
	            	PermissionsInfBean permissionsInfBean=roleBizImpl.selectAllPer(menuNames[i]);
	            	pb.add(permissionsInfBean);          	
				}
			}else {
				pb=null;
			}
			//查询对应角色Id
			String [] roleNames = roleName.split("\\s+");
			int roleId=roleBizImpl.selectRoleId(roleNames[1]);
			//删除角色下的所有权限
			roleBizImpl.delRolePermissions(roleId);
			//添加角色权限
			if (pb!=null) {
				roleBizImpl.addRolePermissions(pb,roleId);
			}
			
			return selectAllRoles(request, response, null);	    
		}
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
			return selectAllSonMenu(request, response,permissionsId, null);	    
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
				
				
				
				
				
				
}
