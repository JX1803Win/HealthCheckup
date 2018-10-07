package org.xmgreat.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;

public class Word2PdfUtil {

	private static boolean getLicense() {
		boolean result = false;
		try {
			// 凭证
			String licenseStr = "<License>\n" + "  <Data>\n" + "    <Products>\n"
					+ "      <Product>Aspose.Total for Java</Product>\n"
					+ "      <Product>Aspose.Words for Java</Product>\n" + "    </Products>\n"
					+ "    <EditionType>Enterprise</EditionType>\n"
					+ "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n"
					+ "    <LicenseExpiry>20991231</LicenseExpiry>\n"
					+ "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" + "  </Data>\n"
					+ "  <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n"
					+ "</License>";
			InputStream license = new ByteArrayInputStream(licenseStr.getBytes("UTF-8"));
			License asposeLic = new License();
			asposeLic.setLicense(license);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void doc2pdf(String wordPath, String pdfPath) {
		if (!getLicense()) {// 验证License,若不验证则转化出的pdf文档会有水印产生
//			boolean a = getLicense();
//			System.out.println(a);
			return;
		}
		try {
			long old = System.currentTimeMillis();// 转换开始前时间
			File file = new File(pdfPath);// 新建的PDF文件路径
			FileOutputStream os = new FileOutputStream(file); // 要转换的word文档的路径
			Document doc = new Document(wordPath); // 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
			doc.save(os, com.aspose.words.SaveFormat.PDF); // 转换结束后时间
			long now = System.currentTimeMillis();
			os.close();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		doc2pdf("E:\\培训\\项目\\健康体检散检系统项目\\我的文档\\体检导检单1537880302098.doc", 
				"E:\\培训\\项目\\健康体检散检系统项目\\我的文档\\体检导检单1537880302098.pdf");
	}
	
	public static void doc2pdf(File word, File pdf) {
		if (!getLicense()) {// 验证License,若不验证则转化出的pdf文档会有水印产生
			return;
		}
		try {
			long old = System.currentTimeMillis();// 转换开始前时间
			FileOutputStream os = new FileOutputStream(pdf); // 要转换的word文档的路径
			Document doc = new Document(word.getAbsolutePath()); // 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
			doc.save(os, com.aspose.words.SaveFormat.PDF); // 转换结束后时间
			long now = System.currentTimeMillis();
			os.close();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
