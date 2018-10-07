package org.xmgreat.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xmgreat.annotation.SystemLog;
import org.xmgreat.bean.LogBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.mapper.LogMapper;

@Aspect
public class LogAop
{
	@Resource
	private LogBean logBean;
	@Resource
	private LogMapper logMapper;

	// 配置接入点
	@Pointcut("execution(* org.xmgreat.action..*.*(..))")
	private void controllerAspect()
	{
	}// 定义一个切入点

	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable
	{
		// 获取登录用户id
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (request.getSession().getAttribute("admin") == null)
		{
			return pjp.proceed();
		}
		ManagerBean managerBean = (ManagerBean) request.getSession().getAttribute("admin");
		logBean.setAdminId(managerBean.getAdminId());
		// 获取系统时间
		String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		logBean.setExecutionDate(time);
		// 获取系统ip
		String IP = IPAddress.getIPAddress(request);
		logBean.setIp(IP);
		// 方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
		long start = System.currentTimeMillis();
		// 拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		// 拦截的方法名称。当前正在执行的方法
		String methodName = pjp.getSignature().getName();
		// 拦截的方法参数
		Object[] args = pjp.getArgs();
		// 拦截的放参数类型
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		if (!(sig instanceof MethodSignature))
		{
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature) sig;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();

		Object object = null;
		// 获得被拦截的方法
		Method method = null;
		try
		{
			method = target.getClass().getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (null != method)
		{
			// 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
			if (method.isAnnotationPresent(SystemLog.class))
			{
				SystemLog systemlog = method.getAnnotation(SystemLog.class);
				logBean.setModule(systemlog.module());
				logBean.setMethod(systemlog.methods());
				try
				{
					object = pjp.proceed();
					long end = System.currentTimeMillis();
					// 将计算好的时间保存在实体中
					logBean.setRsponseDate("" + (end - start));
					logBean.setCommite("执行成功！");
					// 保存进数据库
					logMapper.addLog(logBean);
				} catch (Throwable e)
				{
					// TODO Auto-generated catch block
					long end = System.currentTimeMillis();
					logBean.setRsponseDate("" + (end - start));
					logBean.setCommite("执行失败");
					// 保存进数据库
					logMapper.addLog(logBean);
				}
			} else
			{// 没有包含注解
				object = pjp.proceed();
			}
		} else
		{ // 不需要拦截直接执行
			object = pjp.proceed();
		}
		return object;
	}
}
