package org.xmgreat.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.util.WordUtil;

@Controller
@RequestMapping("/ReportAction")
public class ReportAction {
	/**
	 * @description 下载体检报告
	 * @param request 请求
	 * @param response 响应
	 * @return
	 */
	@RequestMapping("/downloadReport.action")
	public String downloadReport(HttpServletRequest request, HttpServletResponse response) {
		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;

		try {
			request.setCharacterEncoding("utf-8");

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("barcode", WordUtil.getImageString("2345678"));// 条形码
			dataMap.put("userName", "张三");

			List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
			for (int i = 1; i <= 5; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("i", i);
				map.put("officeName", "科室" + i);
				map.put("projectName", "项目" + i);
				newsList.add(map);
			}
			dataMap.put("myListData", newsList);

			List<Map<String, List<Map<String, Object>>>> projectList = new ArrayList<>();
			for (int j = 1; j <= 2; j++) {
				Map<String, List<Map<String, Object>>> project = new HashMap<>();
				List<Map<String, Object>> detailList = new ArrayList<>();
				for (int i = 1; i <= 3; i++) {
					Map<String, Object> detail = new HashMap<>();
					detail.put("i", i);
					detail.put("detailName", "细项" + i);
					detail.put("result", "结果" + i);
					detail.put("unit", "单位" + i);
					detail.put("reference", "参考值" + i);
					detail.put("hint", "提示" + i);
					detailList.add(detail);
				}
				project.put("项目" + j, detailList);
				List<Map<String, Object>> list = new ArrayList<>();
				Map<String, Object> info = new HashMap<>();
				info.put("officeName", "检查室" + j);
				info.put("manageName", "医生" + j);
				list.add(info);
				project.put("info", list);
				projectList.add(project);
			}
			dataMap.put("projects", projectList);

			// 文件路径
			String filePath = "E:\\培训\\项目\\健康体检散检系统项目\\我的文档";

			// 文件名称
			String fileName = "体检报告" + System.currentTimeMillis() + ".doc";

			// 生成word
			file = WordUtil.createWord(dataMap, "体检报告.ftl", filePath, fileName);

			fin = new FileInputStream(file);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			response.addHeader("Content-Disposition", "attachment;filename=体检报告.doc");

			out = response.getOutputStream();
			byte[] buffer = new byte[1024];// 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while ((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return null;
	}
}
