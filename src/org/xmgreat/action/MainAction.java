package org.xmgreat.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backstage")
@Scope("prototype")
public class MainAction
{
	@RequestMapping(value = "/head")
	public String head(HttpServletRequest request)
	{
		return "backstage/head";
	}

	@RequestMapping(value = "/left")
	public String left(HttpServletRequest request)
	{
		return "backstage/left";
	}

	@RequestMapping(value = "/main")
	public String main(HttpServletRequest request)
	{
		return "backstage/main";
	}

}
