package org.xmgreat.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ShowReportAction")
public class ShowReportAction {

	@RequestMapping(value = "/show.action")
	public String getpic(String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
		File file = new File("E:\\培训\\课件\\1.预科\\1.Java开发环境.pdf");
		if (!file.exists()) {
			request.setAttribute("error", "附件已删除或不存在");
		}
		InputStream in = null;
		OutputStream os = null;
		try {
			response.setContentType("application/pdf"); // 设置返回内容格式
			in = new FileInputStream(file); // 用该文件创建一个输入流
			os = response.getOutputStream(); // 创建输出流
			byte[] b = new byte[1024];
			while (in.read(b) != -1) {
				os.write(b);
			}
			in.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
