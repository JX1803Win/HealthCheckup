package org.xmgreat.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ObjectExcelView extends AbstractExcelView
{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		// 这个是下载后的excel的文件名
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String filename = "健康体检后台操作日志   " + df.format(date);
		System.out.println(filename);
		response.setContentType("application/octet-stream");
		filename = new String(filename.getBytes("GB2312"), "ISO_8859_1");
		response.setHeader("Content-Disposition", "attachment;filename=" + filename + ".xls");
		// excel的第几页
		HSSFSheet sheet;
		HSSFCell cell;
		// 设置一下第一页
		sheet = workbook.createSheet("sheet1");
		// 从springmvc中获取出来放入View的信息，就是Value
		List<String> titles = (List<String>) model.get("titles");

		// 标题样式,就是titles的样式，包括字体，大小
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 标题字体
		HSSFFont headerFont = workbook.createFont();
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short) 11);
		headerStyle.setFont(headerFont);
		short width = 20, height = 25 * 20;
		int len = titles.size();
		sheet.setDefaultColumnWidth(width);
		// 设置标题，将从title的东西获取出来~
		for (int i = 0; i < len; i++)
		{
			// 获取titles的值！
			String title = titles.get(i);
			// 第一页，第一行，第几列的将数title插进去
			cell = getCell(sheet, 0, i);
			// 设置风格
			cell.setCellStyle(headerStyle);
			// 这个不用说了吧
			setText(cell, title);
		}
		// 这个要改改高度~~
		sheet.getRow(0).setHeight(height);
		// 以下就是内容样式了。都差不多，不写注释了。。吐血
		HSSFCellStyle contentStyle = workbook.createCellStyle();
		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		List<Map<String, Object>> varList = (List<Map<String, Object>>) model.get("objData");
		System.out.println(varList);
		int varCount = varList.size();
		for (int i = 0; i < varCount; i++)
		{
			Map<String, Object> vpd = varList.get(i);
			for (int j = 0; j < len; j++)
			{
				// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				String varstr = String.valueOf(vpd.get("var" + (j + 1))) != null
						? String.valueOf(vpd.get("var" + (j + 1)))
						: "";
				// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				cell = getCell(sheet, i + 1, j);
				cell.setCellStyle(contentStyle);
				setText(cell, varstr);
			}
		}
	}

}
