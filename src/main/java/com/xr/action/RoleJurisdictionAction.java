package com.xr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xr.biz.JurisdictionBiz;
import com.xr.biz.RoleBiz;
import com.xr.biz.RoleJurisdictionBiz;
import com.xr.entity.Allxx;
import com.xr.entity.Jurisdiction;
import com.xr.entity.Role;
import com.xr.entity.RoleJurisdiction;

@Controller
public class RoleJurisdictionAction extends ActionSupport implements ModelDriven<RoleJurisdiction>{
	private static final long serialVersionUID = 1L;
	@Autowired	
	private RoleJurisdictionBiz roleJurisdiction;
	@Autowired
	private RoleBiz roleBiz;
	@Autowired
	private JurisdictionBiz  jurisdictionBiz;
	
	/**
	 * 权限角色查询
	 * @throws IOException 
	 */
	public void findByRoleJurisdiction(){
		HttpServletResponse resp= ServletActionContext.getResponse();
		PrintWriter out = null;
		resp.setCharacterEncoding("UTF-8");
		try {
			out=resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Role> role=null;
		try {
			role = roleBiz.findByRole();
			List<Allxx> map = roleJurisdiction.findByRoleJurisdiction(role);
			out.print(JSON.toJSONString(map));
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
		}
		
	}
	/**
	 * 角色权限
	 */
	public Object  findTree(Integer id){
		
			List<List<Jurisdiction>> li=new ArrayList<>();
			
			 List<Jurisdiction> findByNO = jurisdictionBiz.findByNO();
			 List<Jurisdiction> findByO = jurisdictionBiz.findByO();
			 li.add(findByO);
			 li.add(findByNO);
			List<HashMap<String, Object>> result = new ArrayList<>(); 
			List<Jurisdiction> roleJurisdictions=null;
			try {
				roleJurisdictions=roleJurisdiction.findByRoleJurisdiction(new Role());
			} catch (Exception e) {
				e.printStackTrace();
			}
		     //查询这个角色之前有哪些权限菜单
		    return fun(li, result, roleJurisdictions, id);
	}
	private Object fun( List li, List<HashMap<String, Object>> result, List<Jurisdiction> role, Integer id) {
	    	List<Jurisdiction> list = (List<Jurisdiction>) li.get(0);
	    	List<Jurisdiction> list1 = (List<Jurisdiction>) li.get(1);
	    	for(Jurisdiction m : list){
		        HashMap<String, Object> map = new HashMap<>();
		        map.put("id", m.getJid());
		        map.put("title", m.getJname());
		        map.put("spread", true);      //设置是否展开
		        List<HashMap<String, Object>> result1 = new ArrayList<>();
		        List<Jurisdiction> children = null;   //下级菜单
		        for (Jurisdiction non : list1) {
					if(m.getJid()==non.getPartid()){
						children.add(non);
					}
				}
		        if(m != null || children.size() == 0){
		            if(role.contains(jurisdictionBiz.findByJurisdictionNameId(m.getJname(), id))){    //判断该角色之前是否有这个权限菜单
		                map.put("checked", true);    //设置为选中状态
		            }
		        }
		        map.put("children", fun(children, result1, role, id));
		        result.add(map);
		    }
		
	    return result;
	}
	public void findByRoleJurisdictionTree(){
		HttpServletResponse resp= ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		PrintWriter out = null;
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		Object findTree = findTree(Integer.parseInt(id));
		try {
			out=resp.getWriter();
			System.out.println(JSON.toJSONString(findTree));
			out.print(JSON.toJSONString(findTree));
		} catch (IOException e) {
			e.printStackTrace();
			out.close();
		}
	}
	
	@Override
	public RoleJurisdiction getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
