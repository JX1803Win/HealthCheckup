package org.xmgreat.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.MouthBean;
import org.xmgreat.bean.TriMouthBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;
import org.xmgreat.bean.WeekBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.bizImpl.DoctorBizImpl;
import org.xmgreat.util.DateUtils;

@Controller
@RequestMapping("/doctor")
public class PhysicalCheckerAction {
	@Resource
	public DoctorBizImpl doctorBizImpl;
	@Resource
	private SummaryBiz summaryBiz;
	public int pageNo;
	//查询体检人信息
		@RequestMapping(value="/medicalManInf.action")//为这个方法定义映射子路劲 
		public ModelAndView selectmedicalManInf (HttpServletRequest request,HttpServletResponse response,String userName,Long phone,Long barCode,String starDay,String endDay)throws Exception {
			String aString=request.getParameter("pageNo");
			if (aString!=null) {
				pageNo=Integer.parseInt(aString);
			}
			int size=doctorBizImpl.selectMedicalManNum(userName, phone, barCode, starDay,endDay);
			request.setAttribute("sizeM", size);
	  	    int AllPage = 0;
				if (size % 5 != 0) {
					AllPage = (size / 5) + 1;
				} else {
					AllPage = (size / 5);
				}			
				if (0 == pageNo) {
					pageNo = 1;
				} else {				
					if (pageNo < 1) {
						pageNo = 1;
					} else if (pageNo > AllPage) {
						pageNo = AllPage;
					}
				}  
				request.setAttribute("userName", userName);
			    request.setAttribute("phone", phone);
			    request.setAttribute("barCode", barCode);
			    request.setAttribute("starDay", starDay);
			    request.setAttribute("endDay", endDay);
			request.setAttribute("pageNoM", pageNo);
			request.setAttribute("AllPageM", AllPage);
		    List<UserPhyRecordBean> uprbList=doctorBizImpl.selectMedicalMan(userName, phone, barCode, starDay,endDay, pageNo);			    
		    request.setAttribute("uprbList", uprbList);    
			ModelAndView mav = new ModelAndView();
		  	mav.setViewName("backstage/selectUInf");
		  	return mav;
		}
	  
		//查询周统计
		@RequestMapping(value="/weekStatics.action")//为这个方法定义映射子路劲 
		@ResponseBody
		public WeekBean selectWeekStatics() throws Exception{
			//获得单天日期
			Date day = new Date(); 
			//format对象是用来以指定的时间格式格式化时间的 
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //这里的格式可以自己设置 
			//format()方法是用来格式化时间的方法 
			String times = simpleDateFormat.format(day); 			
			//获得本周周一的日期
			String weekBegin = simpleDateFormat.format(DateUtils.getBeginDayOfWeek());
			//获得本周周末的日期
			String weekEnd=simpleDateFormat.format(DateUtils.getEndDayOfWeek());
			//周二
			String weekTwo = simpleDateFormat.format(DateUtils.getdat(DateUtils.getBeginDayOfWeek(),1));
			//周三
			String weekThree = simpleDateFormat.format(DateUtils.getdat(DateUtils.getBeginDayOfWeek(),2));
			String weekFour = simpleDateFormat.format(DateUtils.getdat(DateUtils.getBeginDayOfWeek(),3));
			String weekFive = simpleDateFormat.format(DateUtils.getdat(DateUtils.getBeginDayOfWeek(),4));
			String weekSix = simpleDateFormat.format(DateUtils.getdat(DateUtils.getBeginDayOfWeek(),5));
			//查询单天用户注册数量
			int monday=doctorBizImpl.selectPhyTimeNum(weekBegin);
			int tuesday=doctorBizImpl.selectPhyTimeNum(weekTwo);
			int wednesday=doctorBizImpl.selectPhyTimeNum(weekThree);
			int thursday=doctorBizImpl.selectPhyTimeNum(weekFour);
			int friday=doctorBizImpl.selectPhyTimeNum(weekFive);
			int saturday=doctorBizImpl.selectPhyTimeNum(weekSix);
			int sunday=doctorBizImpl.selectPhyTimeNum(weekEnd);
			WeekBean weekBean=new WeekBean(monday, tuesday, wednesday, thursday, friday, saturday, sunday, weekBegin, weekTwo, weekThree, weekFour, weekFive, weekSix, weekEnd); 
		    return weekBean;
		}
		//查询周统计
			@RequestMapping(value="/mouthStatics.action")//为这个方法定义映射子路劲 
			@ResponseBody
			public MouthBean selectMouthStatics() throws Exception{
				//获得单天日期
				Date days = new Date(); 
				//format对象是用来以指定的时间格式格式化时间的 
				SimpleDateFormat simpleDateFormats = new SimpleDateFormat("yyyy-MM-dd"); //这里的格式可以自己设置 
				//format()方法是用来格式化时间的方法 
				String time = simpleDateFormats.format(days); 
				String firstandlast=DateUtils.getFirstAndLastOfMonth(time, "yyyy-MM-dd", "yyyy-MM-dd");
				String[]  strs=firstandlast.split("_");
				//本月第一天和最后一天的日期
				Date datestar=null;
				Date dateend=null;
				try {
					datestar=simpleDateFormats.parse(strs[0].toString());
					dateend=simpleDateFormats.parse(strs[1].toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//当前时间的周一
				//获得本周周一的日期
				String nowweekBegin = simpleDateFormats.format(DateUtils.getBeginDayOfWeek());
				//获得本周周末的日期
				String nowweekEnd=simpleDateFormats.format(DateUtils.getEndDayOfWeek());
//				DateUtils.getYouwantDay();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(days);
				 //第几周
			    int week = calendar.get(Calendar.WEEK_OF_MONTH);
			    String oneweekEnd=DateUtils.getYouwantDay(week, nowweekEnd);//返回第一周的最后一天
			    //第一周最后一天
			    Date oneweekEnds=null;
			    try {
					oneweekEnds=simpleDateFormats.parse(oneweekEnd);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				//第二周最后一天
				String twoweekEnd = simpleDateFormats.format(DateUtils.getweek(oneweekEnds,1));
				//第二周的第一天
				String twoweekStar=simpleDateFormats.format(DateUtils.getdat(oneweekEnds,1));
				Date twoweekStars=null;
			    try {
			    	twoweekStars=simpleDateFormats.parse(twoweekStar);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				//第三周最后一天
				String triweekEnd = simpleDateFormats.format(DateUtils.getweek(oneweekEnds,2));
				//第三周第一天
				String triweekStar = simpleDateFormats.format(DateUtils.getweek(twoweekStars,1));
				//第四周最后一天
				String fourweekEnd = simpleDateFormats.format(DateUtils.getweek(oneweekEnds,3));
				//第四周第一天
				String fourweekStar = simpleDateFormats.format(DateUtils.getweek(twoweekStars,2));
				//第五周的第一天
				String fivweekStar = simpleDateFormats.format(DateUtils.getweek(twoweekStars,3));
				int result=fourweekEnd.compareTo(strs[1].toString());
				int fivweek=0;
				if (result<0) {
					fivweek=doctorBizImpl.selectPhyTimeWeekNum(fivweekStar, strs[1].toString());
				}
				//每周注册的数量
				int oneweek=doctorBizImpl.selectPhyTimeWeekNum(strs[0].toString(), oneweekEnd);
				int twoweek=doctorBizImpl.selectPhyTimeWeekNum(twoweekStar, twoweekEnd);
				int triweek=doctorBizImpl.selectPhyTimeWeekNum(triweekStar, triweekEnd);
				int fourweek=doctorBizImpl.selectPhyTimeWeekNum(fourweekStar, fourweekEnd);
				
				MouthBean mouthBean=new MouthBean(oneweek, twoweek, triweek, fourweek, fivweek);
				return mouthBean;
			}
			//查询三月统计
					@RequestMapping(value="/triMouthStatics.action")//为这个方法定义映射子路劲 
					@ResponseBody
					public TriMouthBean selectTriMouthStatics() throws Exception{
						Date day2 = new Date(); 
						//format对象是用来以指定的时间格式格式化时间的 
						SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd"); //这里的格式可以自己设置 
						//format()方法是用来格式化时间的方法 
						String time2 = simpleDateFormat2.format(day2); 
						String firstandlast2=DateUtils.getFirstAndLastOfMonth(time2, "yyyy-MM-dd", "yyyy-MM-dd");
						String[]  strs2=firstandlast2.split("_");
						//本月第一天和最后一天的日期
						String fristday1=strs2[0].toString();
						String lastday1=strs2[1].toString();
						int trimouth=doctorBizImpl.selectPhyTimeWeekNum(fristday1, lastday1);
			        	//上个月第一天/最后一天
						String fristday2=DateUtils.getBeforeFirstMonthdate(1);
			        	String lastday2=DateUtils.getBeforeLastMonthdate(1);
			        	int twomouth=doctorBizImpl.selectPhyTimeWeekNum(fristday2, lastday2);
			        	//上上个月第一天、最后一天
						String fristday3=DateUtils.getBeforeFirstMonthdate(2);
			        	String lastday3=DateUtils.getBeforeLastMonthdate(2);
			        	int onemouth=doctorBizImpl.selectPhyTimeWeekNum(fristday3, lastday3);
			        	TriMouthBean triMouthBean=new TriMouthBean(onemouth, twomouth, trimouth);
			        	return triMouthBean;
					}
		
}
