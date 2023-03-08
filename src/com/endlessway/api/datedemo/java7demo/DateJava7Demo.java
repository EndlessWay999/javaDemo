package com.endlessway.api.datedemo.java7demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateJava7Demo {
    public static void main(String[] args) {
        //获取当前时间
        Date date1 = new Date();
        System.out.println(date1); //Wed Mar 08 22:14:58 CST 2023
        //将毫秒值转换日期对象
        Date date2 = new Date(0L);
        System.out.println(date2);//Thu Jan 01 08:00:00 CST 1970

    }
}

class DateJava7Demo1{
    public static void main(String[] args) {
        //把日期对象转换成对应的时间毫秒值
        Date  date1 = new Date();
        long time = date1.getTime();
        System.out.println(time);
        System.out.println((time/1000/60/60/24)+"天");//19424天
        System.out.println((time/1000/60/60/24/365)+"年");//53年
        System.out.println((time/1000)+"秒");//1678285609秒
        System.out.println((time/1000/60/60)+"时");//466190时
        System.out.println((time/1000/60/60)+"分");//466190分

        //把方法参数给定的毫秒值设置给日期对象
        Date  date2 = new Date();
        date2.setTime(1678285000000L);
        System.out.println(date2); //Wed Mar 08 22:16:40 CST 2023
    }
}
class SimpleDateFormatDemo{
    public static void main(String[] args) throws ParseException {
        /*
         * | 标识字母（区分大小写） | 含义 |
         * | ---------------------- | ---- |
         * | y                      | 年   |
         * | M                      | 月   |
         * | d                      | 日   |
         * | H                      | 时   |
         * | m                      | 分   |
         * | s                      | 秒   |
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将Date对象格式化为字符串
        Date  date1 = new Date();
        String dateStr = sdf.format(date1);
        System.out.println(dateStr);

        Date date2 = sdf.parse("1970-01-01 00:00:00");
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        System.out.println(2023-1970);
        System.out.println(((time1-time2)/1000/60/60/24)+"天");//19424天
        System.out.println(((time1-time2)/1000/60/60/24/365)+"年");//53年
        System.out.println(((time1-time2)/1000)+"秒");//1678285609秒
        System.out.println(((time1-time2)/1000/60/60)+"时");//466190时
        System.out.println(((time1-time2)/1000/60/60)+"分");//466190分
    }

}

class CalendarDemo{
    public static void main(String[] args) {
        //获取获取一个GregorianCalendar对象
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);//java.util.GregorianCalendar[time=1678286182324,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=2,WEEK_OF_YEAR=10,WEEK_OF_MONTH=2,DAY_OF_MONTH=8,DAY_OF_YEAR=67,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=10,HOUR_OF_DAY=22,MINUTE=36,SECOND=22,MILLISECOND=324,ZONE_OFFSET=28800000,DST_OFFSET=0]

        //获取属性
        int year = instance.get(Calendar.YEAR);
        System.out.println(year);//2023
        int month = instance.get(Calendar.MONTH) + 1;//Calendar的月份值是0-11
        System.out.println(month);//3
        int day = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);//8
        int hour = instance.get(Calendar.HOUR);
        System.out.println(hour);//10
        int minute = instance.get(Calendar.MINUTE);
        System.out.println(minute);//38
        int second = instance.get(Calendar.SECOND);
        System.out.println(second);//5

        //获取星期
        int week = instance.get(Calendar.DAY_OF_WEEK);//返回值范围：1--7，分别表示："星期日","星期一","星期二",...,"星期六"
        System.out.println(week);//4
        System.out.println(getWeek(week));//周四



    }

    //查表法，查询星期几
    public static String getWeek(int w) {//w = 1 --- 7
        //做一个表(数组)
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //            索引      [0]      [1]       [2]      [3]       [4]      [5]      [6]
        //查表
        return weekArray[w - 1];
    }
}

class SetDemo{
    public static void main(String[] args) {
        //获取获取一个GregorianCalendar对象
        Calendar instance = Calendar.getInstance();

        //set方法
        //计算女朋友出生那天是星期几(假如女朋友出生日期为：1997年12月02日)
        instance.set(Calendar.YEAR, 1997);
        instance.set(Calendar.MONTH, 12);//转换为Calendar内部的月份值
        instance.set(Calendar.DAY_OF_MONTH, 2);

        int w = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("女朋友出生那天是：" + getWeek(w));


    }

    //查表法，查询星期几
    public static String getWeek(int w) {//w = 1 --- 7
        //做一个表(数组)
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //            索引      [0]      [1]       [2]      [3]       [4]      [5]      [6]
        //查表
        return weekArray[w - 1];
    }
}

class AddDemo{
    public static void main(String[] args) {
        //获取获取一个GregorianCalendar对象
        Calendar instance = Calendar.getInstance();


        //add方法
        instance.add(Calendar.YEAR,20);
        System.out.println(instance.get(Calendar.YEAR));

    }
}
