package org.xmgreat.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.util.ImageUtil;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class PicAction
{
	@RequestMapping(value = "/validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, BufferedImage> map = ImageUtil.createImage();
		String keyCode = map.keySet().iterator().next();
		BufferedImage img = map.get(keyCode);
		try
		{
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(img, "jpg", sos);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		request.getSession().setAttribute("keyCode", keyCode);
	}

}
