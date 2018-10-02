package org.xmgreat.util;

 import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;

import com.sun.jmx.snmp.Timestamp;

public class DateUtils {
	 //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    //获取当天的结束时间
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
  //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取明天的开始时间
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }
    //获取明天的结束时间
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }  
  	//获取本周的开始时间
  	public static Date getBeginDayOfWeek() {
  		Date date = new Date();
  		if (date == null) {
  			return null;
  		}
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(date);
  		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
  		if (dayofweek == 1) {
  			dayofweek += 7;
  		}
  		cal.add(Calendar.DATE, 2 - dayofweek);
  		return cal.getTime();
  	}
  	public static Date getdat(Date date,int a) {
  		 Calendar   calendar   =   new   GregorianCalendar(); 
  	     calendar.setTime(date); 
  	     calendar.add(calendar.DATE,a);//把日期往后增加一天.整数往后推,负数往前移动 
  	     date=calendar.getTime();   //这个时间就是日期往后推一天的结果        
       return date;
       
  	}
  	//一周
  	public static Date getweek(Date date,int a) {
 		 Calendar   calendar   =   new   GregorianCalendar(); 
 	     calendar.setTime(date); 	     
 	     calendar.add(Calendar.WEEK_OF_YEAR,a);//把日期往后增加一周.整数往后推,负数往前移动 
 	     date=calendar.getTime();   //这个时间就是日期往后推一周的结果        
      return date;
      
 	}
  	//获取本周的结束时间
  	public static Date getEndDayOfWeek(){
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(getBeginDayOfWeek());  
  		cal.add(Calendar.DAY_OF_WEEK, 6); 
  		Date weekEndSta = cal.getTime();
  		return weekEndSta;
  	}
    //两个日期相减得到的天数
    public static int getDiffDays(Date beginDate, Date endDate) {

           if (beginDate == null || endDate == null) {
               throw new IllegalArgumentException("getDiffDays param is null!");
           }

           long diff = (endDate.getTime() - beginDate.getTime())
                   / (1000 * 60 * 60 * 24);

           int days = new Long(diff).intValue();

           return days;
       }
  //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static String getFirstAndLastOfMonth(String dataStr,String dateFormat,String resultDateFormat) {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        try {
			c.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = new SimpleDateFormat(resultDateFormat).format(c.getTime());

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat(resultDateFormat).format(ca.getTime());
        return first+"_"+last;
    }
  //获取上个月的第一天
    public static String  getBeforeFirstMonthdate(int a ){
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.MONTH, -a);
    calendar.set(Calendar.DAY_OF_MONTH, a);
    System.out.println("上个月第一天："+format.format(calendar.getTime()));
    return format.format(calendar.getTime());
    }
    //获取上个月的最后一天
    public static String getBeforeLastMonthdate(int a ){
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar=Calendar.getInstance();
    int month=calendar.get(Calendar.MONTH);
    calendar.set(Calendar.MONTH, month-a);
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    System.out.println("上个月最后一天："+sf.format(calendar.getTime()));
    return sf.format(calendar.getTime());
    }
    public static String getYouwantDay(int week,String nowweekEnd) {
    	SimpleDateFormat simpleDateFormats = new SimpleDateFormat("yyyy-MM-dd");
        String oneWeekEnd=null;
        Date nowweekEnds=null;		
		try {
			nowweekEnds=simpleDateFormats.parse(nowweekEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (week==1) {
			//开始时间为1号结束为nowweekEnd
    		//返回第一周的最后一天
    		oneWeekEnd=nowweekEnd;
    		return oneWeekEnd;
		}else if (week==2) {			
				oneWeekEnd = simpleDateFormats.format(getweek(nowweekEnds, -1));
				return oneWeekEnd;
		}else if (week==3) {
			oneWeekEnd = simpleDateFormats.format(getweek(nowweekEnds, -2));
			return oneWeekEnd;
		}else if (week==4) {
			oneWeekEnd = simpleDateFormats.format(getweek(nowweekEnds, -3));
			return oneWeekEnd;
		}else {
			oneWeekEnd = simpleDateFormats.format(getweek(nowweekEnds, -4));
			return oneWeekEnd;
		}
    	
    }
    
}
