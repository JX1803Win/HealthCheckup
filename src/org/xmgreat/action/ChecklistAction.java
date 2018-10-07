package org.xmgreat.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.biz.PhyBiz;
import org.xmgreat.util.Word2PdfUtil;
import org.xmgreat.util.WordUtil;

@Controller
@RequestMapping("/ChecklistAction")
public class ChecklistAction {
	@Resource
	private PhyBiz phyBizImpl;
	private File file = null;
	private InputStream fin = null;
	private ServletOutputStream out = null;

	@RequestMapping("/download.action")
	public String download(HttpServletRequest request, HttpServletResponse response) {
		Long physicaiId = Long.parseLong(request.getParameter("physicaiId"));
		Map<String, Object> map = phyBizImpl.createChecklist(physicaiId);
		// 文件路径
		String filePath = "C:\\";
		// 文件名称
		String fileName = "体检导检单" + physicaiId + ".doc";
		// 生成word
		file = WordUtil.createWord(map, "体检导检单.ftl", filePath, fileName);
		try {
			fin = new FileInputStream(file);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			response.addHeader("Content-Disposition", "attachment;filename="+fileName);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];// 缓冲区
			int bytesToRead = -1;
			while ((bytesToRead = fin.read(buffer)) != -1) {// 通过循环将读入的Word文件的内容输出到浏览器中
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
	
	@RequestMapping("/preview.action")
	public String preview(HttpServletRequest request, HttpServletResponse response) {
		Long physicaiId = Long.parseLong(request.getParameter("physicaiId"));
		Map<String, Object> map = phyBizImpl.lookChecklist(physicaiId);
		// 文件路径
		String filePath = "C:\\";
		// doc文件名称
		String docFileName = "体检导检单" + physicaiId + ".doc";
		// pdf文件名称
		String pdfFileName = "体检导检单" + physicaiId + ".pdf";
		// 生成word
		file = WordUtil.createWord(map, "体检导检单.ftl", filePath, docFileName);
		File pdfFile = new File(filePath + pdfFileName);
		// word转pdf
		Word2PdfUtil.doc2pdf(file, pdfFile);
		InputStream in = null;
		OutputStream os = null;
		try {
//			response.reset();
			response.setContentType("application/pdf"); // 设置返回内容格式
			in = new FileInputStream(pdfFile); // 用该文件创建一个输入流
			os = response.getOutputStream(); // 创建输出流
			byte[] b = new byte[1024];
			while (in.read(b) != -1) {
				os.write(b);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != os) {
					os.close();
				}
				if (null != file) {
					file.delete(); // 删除临时word文件
				}
				if (null != pdfFile) {
					pdfFile.delete(); // 删除临时pdf文件
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return "backstage/preview";
	}
	
	
	@RequestMapping("/goChecklist.action")
	public String goChecklist() {
		return "backstage/checklist";
	}
	
	@RequestMapping("/query.action")
	public String query(HttpServletRequest request) {
		Long physicaiId = Long.parseLong(request.getParameter("physicaiId"));
		request.setAttribute("physicaiId", physicaiId);
		request.setAttribute("uprb", phyBizImpl.queryByPhyId(physicaiId));
		return "backstage/checklist";
	}
}
