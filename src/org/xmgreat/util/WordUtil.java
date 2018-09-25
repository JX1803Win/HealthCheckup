package org.xmgreat.util;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.imageio.ImageIO;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author 宋卓伟
 * @date 2018年9月23日
 * @description word工具类：根据ftl模板生成Word文档
 */
public class WordUtil {

	/**
	 * @param dataMap
	 *            word中需要展示的动态数据，用map集合来保存
	 * @param templateName
	 *            word模板名称，例如：teample.ftl
	 * @param filePath
	 *            文件生成的目标路径，例如：D:/
	 * @param fileName
	 *            生成的文件名称
	 */

	public static File createWord(Map<String, Object> dataMap, String templateName, String filePath, String fileName) {
		// 输出文件
		File outFile = new File(filePath + File.separator + fileName);
		try {
			// 创建配置实例
			Configuration configuration = new Configuration(Configuration.getVersion());

			// 设置编码
			configuration.setDefaultEncoding("UTF-8");

			// ftl模板文件
			configuration.setClassForTemplateLoading(WordUtil.class, "/org/xmgreat/util");

			// 获取模板
			Template template = configuration.getTemplate(templateName);

			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			// 生成文件
			template.process(dataMap, out);

			// 关闭流
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outFile;
	}

	/**
	 * @description 根据字符串生成（EAN8Encoder）条形码
	 * @param barcode 7位字符
	 * @return Base64编码
	 * @throws IOException
	 */
	public static String getImageString(String barcode) throws IOException {
		JBarcode jBarcode = new JBarcode(EAN8Encoder.getInstance(),WidthCodedPainter.getInstance(),EAN8TextPainter.getInstance());  
        jBarcode.setShowText(false);// 不显示条码号
        BufferedImage bufferedImage = null;
		try {
			bufferedImage = jBarcode.createBarcode(barcode);
		} catch (InvalidAtributeException e) {
			e.printStackTrace();
		}  
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
//        System.out.println(encoder.encode(outputStream.toByteArray()));
        return encoder.encode(outputStream.toByteArray());
	}
}