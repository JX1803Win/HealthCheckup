package org.xmgreat.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bizImpl.DoctorBizImpl;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



@Controller
@RequestMapping("fileAction")
public class ExcellAction {
	@Resource
	public DoctorBizImpl doctorBizImpl;
	/*
	 * 生成excel并导出
	 */
	@RequestMapping("/exportExcell.action")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String userName,Long phone,Long barCode,String starDay,String end) throws Exception{
		Date now = new Date();
		InputStream fin = null;
		ServletOutputStream out = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowdate = df.format(now);
        // 打开文件
        File file=new File("C:\\"+nowdate + ".xls");      
        WritableWorkbook book = Workbook.createWorkbook(file);
        
        // 生成名为"第一页"的工作表，参数0表示这是第一
        WritableSheet sheet = book.createSheet("第一页", 0);

        // 设置字体为宋体,16号字,加粗,颜色为黑色
        WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
        font1.setColour(Colour.BLACK);
        WritableCellFormat format1 = new WritableCellFormat(font1);
        format1.setAlignment(jxl.format.Alignment.CENTRE);
        format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

        Label labelA = new Label(0, 0, "序号", format1);
        Label labelB = new Label(1, 0, "姓名", format1);
        Label labelC = new Label(2, 0, "性别", format1);
        Label labelD = new Label(3, 0, "年龄", format1);
        Label labelE = new Label(4, 0, "联系电话", format1);
        Label labelF = new Label(5, 0, "体检时间", format1);

        // 将定义好的单元格添加到工作表中
        sheet.addCell(labelA);
        sheet.addCell(labelB);
        sheet.addCell(labelC);
        sheet.addCell(labelD);
        sheet.addCell(labelE);
        sheet.addCell(labelF);
        //接收数据
		if (phone==null) {
			phone=(long) 0;
		}
		if (barCode==null) {
			barCode=(long) 0;
		}
        List<UserInfoBean> uprbList=doctorBizImpl.selectMedicalManS(userName, phone, barCode, starDay,end); 
        for (int i = 0; i < uprbList.size(); i++) {
            Label labelAi = new Label(0, i + 1, String.valueOf(i+1));
            Label labelBi = new Label(1, i + 1, uprbList.get(i).getUserName());
            Label labelCi = new Label(2, i + 1, uprbList.get(i).getSex());
            Label labelDi = new Label(3, i + 1, String.valueOf(uprbList.get(i).getAge()));
            Label labelEi = new Label(4, i + 1, String.valueOf(uprbList.get(i).getPhone()));
            Label labelFi;
            if (uprbList.get(i).getUserPhyRecordBean().getPhyTime()!=null) {
            	labelFi = new Label(5, i + 1, uprbList.get(i).getUserPhyRecordBean().getPhyTime());
			}else {
				String appoTime=doctorBizImpl.selectAppoTime(uprbList.get(i).getUserPhyRecordBean().getPhysicaiId());
				labelFi = new Label(5, i + 1, appoTime);
			}                        
            sheet.addCell(labelAi);
            sheet.addCell(labelBi);
            sheet.addCell(labelCi);
            sheet.addCell(labelDi);
            sheet.addCell(labelEi);
            sheet.addCell(labelFi);
           
        }  
     // 写入数据并关闭文件
        book.write();
        
        book.close();        
        fin = new FileInputStream(file);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/excel");
		response.addHeader("Content-Disposition", "attachment;filename="+nowdate + ".xls");

		out = response.getOutputStream();
		byte[] buffer = new byte[1024];// 缓冲区
		int bytesToRead = -1;
		// 通过循环将读入的Word文件的内容输出到浏览器中
		while ((bytesToRead = fin.read(buffer)) != -1) {
			out.write(buffer, 0, bytesToRead);
		}
	
		try {
			if (fin != null) {
				fin.close();
			}
			if (out != null) {
				out.close();
			}
			if (file != null) {
				file.delete(); // 删除临时文件
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
	
}
