package com.ule.cerservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author fanxunli
 * @Description:
 * @Param:
 * @Return:
 * @Create: 19-1-10 下午5:46
 */
public class DateUtil {
	public static void main(String[] args) throws ParseException {
		//plusDay2(-1);
		plusDay2(7);
	}


	/**
	 * 指定日期加上天数后的日期
	 * @param num 为增加的天数
	 * @param newDate 创建时间
	 * @return
	 * @throws ParseException
	 */
	public static String plusDay(int num,String newDate) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  currdate = format.parse(newDate);
		System.out.println("现在的日期是：" + currdate);
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		currdate = ca.getTime();
		String enddate = format.format(currdate);
		System.out.println("增加天数以后的日期：" + enddate);
		return enddate;
	}

	/**
	 * 当前日期加上天数后的日期
	 * @param num 为增加的天数
	 * @return
	 */
	public static String plusDay2(int num){
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currdate = format.format(d);
		System.out.println("现在的日期是：" + currdate);

		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		d = ca.getTime();
		String enddate = format.format(d);
		System.out.println("增加天数以后的日期：" + enddate);
		return enddate;
	}

}
