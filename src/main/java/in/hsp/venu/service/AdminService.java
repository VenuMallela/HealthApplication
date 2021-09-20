package in.hsp.venu.service;

import java.util.List;

import in.hsp.venu.entity.Admin;

public interface AdminService  {
	
	public Integer saveAdmin(Admin admin);
	public List<Admin> getAllData();
	public void deleteAdmin(Integer id);
	public Admin EditAdmin(Integer id);
	public void updateAdmin(Admin admin);
	
	public boolean isAdminCountExit(String code);
	

}
