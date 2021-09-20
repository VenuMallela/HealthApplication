package in.hsp.venu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.hsp.venu.entity.Admin;
import in.hsp.venu.excel.AdminExcelExport;
import in.hsp.venu.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/show")
	public String showPage()
	{
		return"Admin";
	}
	
	@PostMapping("/save")
	public String saveData(@ModelAttribute Admin admin,Model model)
	{
		Integer id=service.saveAdmin(admin);
		String message="Admin'"+id+"'is Created";
		model.addAttribute("message",message);
		return"Admin";
	}
	
	@GetMapping("/all")
	public String getAllData(@ModelAttribute Admin admin,Model model)
	{
		List<Admin> list=service.getAllData();
		model.addAttribute("list",list);
		return"AdminData";
	}
	@GetMapping("/delete")
	public String deleteData(@RequestParam Integer id,Model model)
	{
		service.deleteAdmin(id);
		String message="Adimn'"+id+"'is deleted Successfully";
		model.addAttribute("message",message);
		List<Admin> list=service.getAllData();
		model.addAttribute("list",list);
		return"AdminData";
		
	}
	@GetMapping("/edit")
	public String editData(@RequestParam Integer id,Model model)
	{
		Admin admin=service.EditAdmin(id);
		model.addAttribute("admin",admin);
		return"AdminEditData";
	}
	
	@PostMapping("/update")
	public String updateData(@ModelAttribute Admin admin,Model model)
	{
		service.updateAdmin(admin);
		//model.addAttribute(admin);
		String message="Admin data '"+admin+"'is Successfully updated";
		model.addAttribute("message",message);
		return"redirect:all";
	}
	@GetMapping("/excel")
	   public ModelAndView excelData() {
		  ModelAndView m=new ModelAndView();
		 m.setView(new AdminExcelExport()); 
		 List<Admin> list=service.getAllData();
		 m.addObject("list",list);
	    return m;
}
	@GetMapping("/codecheck")
	public String codeValidate(@RequestParam String code)
	{
		String message="";
		if(service.isAdminCountExit(code))
		{
			message=code+"is Already Exit Please enter Another Code";
			
		}
		return message;
	}
}
