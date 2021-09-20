package in.hsp.venu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.hsp.venu.entity.Admin;

public class AdminExcelExport extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
		response.addHeader("content-Dispostion", "attachment;filename=admin.xlsx");
		@SuppressWarnings("unchecked")
		List<Admin> list=(List<Admin>)model.get("list");
		 
		    Sheet sheet=workbook.createSheet("ADMIN");
		
		setHead(sheet);
		
		setBody(sheet,list);
		
		
	}

	

	private void setHead(Sheet sheet) {
		
	Row row=sheet.createRow(0);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("CODE");
	row.createCell(2).setCellValue("NAME");
	row.createCell(3).setCellValue("NOTE");
		
	}
	
  private void setBody(Sheet sheet, List<Admin> list) {
		
		int rowNum=1;
		for(Admin add:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(add.getId());
			row.createCell(1).setCellValue(add.getCode());
			row.createCell(2).setCellValue(add.getName());
			row.createCell(3).setCellValue(add.getNote());
					
		}
		
	}
	

}
