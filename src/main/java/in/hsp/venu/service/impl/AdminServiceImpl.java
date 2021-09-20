package in.hsp.venu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hsp.venu.entity.Admin;
import in.hsp.venu.repository.AdminRepository;
import in.hsp.venu.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repo;
	@Override
	public Integer saveAdmin(Admin admin) {
		
		    	admin=repo.save(admin);
		
		return admin.getId();
	}
	
	@Override
	public List<Admin> getAllData() {
		
		 List<Admin> list=repo.findAll();
		return list;
	}
	
	@Override
	public void deleteAdmin(Integer id) {
		repo.deleteById(id);	
	}
	@Override
	public Admin EditAdmin(Integer id) {
		
		       Optional<Admin> optional=repo.findById(id);
		       if(optional.isPresent())
		       {
		    	       Admin ad=optional.get();
		    	       return ad;
		       }
		       
		
		return null;
	}
	
	@Override
	public void updateAdmin(Admin admin) {
		repo.save(admin);
		
	}
	
	@Override
	public boolean isAdminCountExit(String code) {
		 
		   /* Integer id=repo.adminCountExit(code);
		         boolean ob=id>0 ? true:false;
		        		 return ob;*/
		        
		return repo.adminCountExit(code)>0;
	}

}
