package org.xmgreat.action;

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
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bizImpl.RoleBizImpl;
@Controller
@RequestMapping("/role")//整体的访问路劲
public class RightsManageAction {
	@Resource
	public RoleBizImpl roleBizImpl;
	public int pageNo;
	//权限管理
			@RequestMapping(value="/allRoles.action")//为这个方法定义映射子路劲 
			@ResponseBody
			public ModelAndView selectAllRoles (HttpServletRequest request,HttpServletResponse response,String roleName )throws Exception {
//				HttpSession session = request.getSession();
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
}
