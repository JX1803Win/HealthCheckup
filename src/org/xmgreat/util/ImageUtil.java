package org.xmgreat.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// 生成  验证码  和  验证码图片  的类
public final class ImageUtil
{

	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I' };
	private static final int SIZE = 4; // 验证码图片中文字的个数
	private static final int LINES = 120; // 验证码图片中的干扰线的数量
	private static final int WIDTH = 80; // 验证码图片的宽度
	private static final int HEIGHT = 34; // 验证码图片的高度
	private static final int FONT_SIZE = 19;// 验证码图片中文字的大小

	/**
	 * 生成验证码和验证码图片的方法，并封装在Map中。
	 * 
	 * 其中Map的key是验证码，Map的value是验证码图片。
	 */
	public static Map<String, BufferedImage> createImage()
	{

		StringBuffer sb = new StringBuffer();

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics graphic = image.getGraphics();
		// 生成随机类
		Random ran = new Random();
		// 设定背景色
		graphic.setColor(getRandColor(200, 250));
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 设定字体
		graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
		// 画随机字符
		for (int i = 1; i <= SIZE; i++)
		{
			int r = ran.nextInt(chars.length);
			graphic.setColor(new Color(20 + ran.nextInt(110), 20 + ran.nextInt(110), 20 + ran.nextInt(110)));
			graphic.drawString(chars[r] + "", (i - 1) * WIDTH / SIZE, HEIGHT / 2);
			sb.append(chars[r]);// 将字符保存，存入Session
		}
		// 随机产生LINES条干扰线，使图象中的认证码不易被其它程序探测到
		graphic.setColor(getRandColor(160, 200));
		for (int i = 0; i < LINES; i++)
		{
			int x = ran.nextInt(WIDTH);
			int y = ran.nextInt(HEIGHT);
			int xl = ran.nextInt(12);
			int yl = ran.nextInt(12);
			graphic.drawLine(x, y, x + xl, y + yl);
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}

	/**
	 * 将图片传入输入流的方法
	 */
	public static InputStream getInputStream(BufferedImage image) throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		byte[] imageBts = bos.toByteArray();
		InputStream in = new ByteArrayInputStream(imageBts);
		return in;
	}

	// 给定范围获得随机颜色
	private static Color getRandColor(int fc, int bc)
	{
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}