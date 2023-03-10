package com.endlessway.api.datedemo.java8demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * ZoneId 时区
 */
public class DateJava8Demo {
    public static void main(String[] args) {
        /*
        | JDK8时间类类名    | 作用                   |
        | ----------------- | ---------------------- |
        | ZoneId            | 时区                   |
        | Instant           | 时间戳                 |
        | ZoneDateTime      | 带时区的时间           |
        | DateTimeFormatter | 用于时间的格式化和解析 |
        | LocalDate         | 年、月、日             |
        | LocalTime         | 时、分、秒             |
        | LocalDateTime     | 年、月、日、时、分、秒 |
        | Duration          | 时间间隔（秒，纳，秒） |
        | Period            | 时间间隔（年，月，日） |
        | ChronoUnit        | 时间间隔（所有单位）   | */

        /*
        static Set<string> getAvailableZoneIds() 获取Java中支持的所有时区
        static ZoneId systemDefault() 获取系统默认时区
        static Zoneld of(string zoneld) 获取一个指定时区
        */
        //1.获取所有的时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds.size());//600
        System.out.println(zoneIds);// Asia/Shanghai
//        for (String zoneId:zoneIds) {
//            System.out.println(zoneId);
//        }

        //2.获取当前系统的默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);//Asia/Shanghai

        //3.获取指定的时区
        ZoneId zoneId1 = ZoneId.of("Mexico/BajaNorte");
        System.out.println(zoneId1);//Asia/Pontianak

    }
}

/**
 * Instant 时间戳
 */
class InstantDemo {
    public static void main(String[] args) {
        /*
            static Instant now() 获取当前时间的Instant对象(标准时间)
            static Instant ofXxxx(long epochMilli) 根据(秒/毫秒/纳秒)获取Instant对象
            ZonedDateTime atZone(ZoneIdzone) 指定时区
            boolean isxxx(Instant otherInstant) 判断系列的方法
            Instant minusXxx(long millisToSubtract) 减少时间系列的方法
            Instant plusXxx(long millisToSubtract) 增加时间系列的方法
        */

        //获取当前时间的Instant对象
        Instant now = Instant.now();
        System.out.println(now);//2023-03-10T03:09:13.091Z

        //2.根据(秒/毫秒/纳秒)获取Instant对象
        Instant instant1 = Instant.ofEpochMilli(0L);
        System.out.println(instant1);//1970-01-01T00:00:00z

        Instant instant2 = Instant.ofEpochSecond(1L);
        System.out.println(instant2);//1970-01-01T00:00:01Z

        Instant instant3 = Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant3);//1970-01-01T00:00:027

        //3. 指定时区
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);


        //4.isXxx 判断
        Instant instant4 = Instant.ofEpochMilli(0L);
        Instant instant5 = Instant.ofEpochMilli(1000L);

        //5.用于时间的判断
        //isBefore:判断调用者代表的时间是否在参数表示时间的前面
        boolean result1 = instant4.isBefore(instant5);
        System.out.println(result1);//true

        //isAfter:判断调用者代表的时间是否在参数表示时间的后面
        boolean result2 = instant4.isAfter(instant5);
        System.out.println(result2);//false

        //6.Instant minusXxx(long millisToSubtract) 减少时间系列的方法
        Instant instant6 = Instant.ofEpochMilli(3000L);
        System.out.println(instant6);//1970-01-01T00:00:03Z

        Instant instant7 = instant6.minusSeconds(1);
        System.out.println(instant7);//1970-01-01T00:00:02Z

    }
}
/**
 * ZoneDateTime  带时区的时间
 */
class ZoneDateTimeDemo{
    public static void main(String[] args) {
        /*
            static ZonedDateTime now() 获取当前时间的ZonedDateTime对象
            static ZonedDateTime ofXxxx(。。。) 获取指定时间的ZonedDateTime对象
            ZonedDateTime withXxx(时间) 修改时间系列的方法
            ZonedDateTime minusXxx(时间) 减少时间系列的方法
            ZonedDateTime plusXxx(时间) 增加时间系列的方法
         */

        //1.获取当前时间对象(带时区)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);//2023-03-10T11:11:53.518+08:00[Asia/Shanghai]

        //2.获取指定的时间对象(带时区)1/年月日时分秒纳秒方式指定
        ZonedDateTime time1 = ZonedDateTime.of(2023, 10, 1,
                11, 12, 12, 0, ZoneId.of("Asia/Shanghai"));
        System.out.println(time1);

        //通过Instant + 时区的方式指定获取时间对象
        Instant instant = Instant.ofEpochMilli(0L);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time2 = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(time2);


        //3.withXxx 修改时间系列的方法
        ZonedDateTime time3 = time2.withYear(2000);
        System.out.println(time3);

        //4. 减少时间
        ZonedDateTime time4 = time3.minusYears(1);
        System.out.println(time4);

        //5.增加时间
        ZonedDateTime time5 = time4.plusYears(1);
        System.out.println(time5);
    }
}
/**
 * LocalDate  年、月、日
 */
class LocalDateDemo{
    public static void main(String[] args) {
        //获取当前时间的日历对象(包含 年月日)
        LocalDate now = LocalDate.now();
        System.out.println(now);//2023-03-10

        //获取指定的时间的日历对象
        LocalDate ldDate = LocalDate.of(2021, 9, 10);
        System.out.println(ldDate);//2021-09-10

        //get系列方法获取日历中的每一个属性值//获取年
        System.out.println(now.getYear());//2023
        System.out.println(now.getMonthValue());//3
        System.out.println(now.getDayOfMonth());//10
        System.out.println(now.getDayOfWeek());//FRIDAY->周五

        //is开头的方法表示判断
        System.out.println(ldDate.isBefore(ldDate));
        System.out.println(ldDate.isAfter(ldDate));

        //with开头的方法表示修改，只能修改年月日
        LocalDate withLocalDate = ldDate.withYear(2000);
        System.out.println(withLocalDate);

        //minus开头的方法表示减少，只能减少年月日
        LocalDate minusLocalDate = ldDate.minusYears(1);
        System.out.println(minusLocalDate);


        //plus开头的方法表示增加，只能增加年月日
        LocalDate plusLocalDate = ldDate.plusDays(1);
        System.out.println(plusLocalDate);

        // 判断今天是否是你的生日
        LocalDate birDate = LocalDate.of(2000, 1, 1);
        LocalDate nowDate1 = LocalDate.now();

        MonthDay birMd = MonthDay.of(birDate.getMonthValue(), birDate.getDayOfMonth());
        MonthDay nowMd = MonthDay.from(nowDate1);
        System.out.println(nowMd);
//        MonthDay birMd = MonthDay.from(birDate);
        System.out.println(birMd);

        System.out.println("今天是你的生日吗? " + birMd.equals(nowMd));//今天是你的生日吗?

    }
}
/**
 * DateTimeFormatter   用于时间的格式化和解析
 */
class DateTimeFormatterDemo{
    public static void main(String[] args) {
        /*
                    static DateTimeFormatter ofPattern(格式) 获取格式对象
                    String format(时间对象) 按照指定方式格式化
                */
        //获取时间对象
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        LocalDate now = LocalDate.now();
        // 解析/格式化器
        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化
        System.out.println(dtf1.format(time));
        System.out.println(dtf1.format(now));

        //解析
        System.out.println(LocalDate.parse("2022-09-10",dtf1));

        //把日期转换成字符串
        LocalDateTime arrivalDate  = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMdd yyyy  hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at :  %s %n", landing);
        }catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }

        //字符串互转
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time1 = LocalDateTime.now();
        String localTime = df.format(time1);
        LocalDateTime ldt = LocalDateTime.parse("2022-12-30 10:12:05",df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);

        //Date转LocalDateTime
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        System.out.println(localDateTime);

        //LocalDateTime 转Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZoneId zone1 = ZoneId.systemDefault();
        Instant instant1 = localDateTime1.atZone(zone1).toInstant();
        java.util.Date date1 = Date.from(instant1);
        System.out.println(date1);

        //LocalDateTime与LocalDate互转
        LocalDateTime now11 = LocalDateTime.now();
        LocalDate localDate = now11.toLocalDate();
        System.out.println(localDate);

        //LocalDate与Date互转
        LocalDate localDate1 = LocalDate.now();
        ZoneId zone11 = ZoneId.systemDefault();
        Instant instant11 = localDate1.atStartOfDay().atZone(zone11).toInstant();
        java.util.Date date11 = Date.from(instant11);
        System.out.println(date11);
    }
}

class CountDemo{
    public static void main(String[] args) {
        //在现有的时间上增加小时
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime1 = localTime.plusHours(2);//增加2小时
        System.out.println(localTime1);

        //计算一周后的日期
        LocalDate plusDate = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        System.out.println(plusDate);

        //计算一年前或一年后的日期
        LocalDate plusYear = LocalDate.now().plusYears(1);
        LocalDate minusYear = LocalDate.now().minusYears(1);
        System.out.println(plusYear);
        System.out.println(minusYear);

        //表示信用卡到期这类固定日期
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth mortgageDueDate = YearMonth.of(2022, Month.JANUARY);
        System.out.printf("Your Mortgage due date on %s %n", mortgageDueDate);

        //用 Java 判断日期是早于还是晚于另一个日期
        LocalDate tomorrow = LocalDate.of(2018,6,20);
        if(tomorrow.isAfter(LocalDate.now())){
            System.out.println("Tomorrow comes after today");
        }
        LocalDate yesterday = LocalDate.now().minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(LocalDate.now())){
            System.out.println("Yesterday is day before today");
        }

        //在 Java 8 中判断闰年
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println(leapYear);
        //计算两个日期之间的天数和月数
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2023, Month.MARCH, 20);
        Period period = Period.between(now, date);
        System.out.println("离下个时间还有" + period.getMonths() + " 个月");
    }
}
/**
 * LocalTime  时、分、秒
 */
class LocalTimeDemo{
    public static void main(String[] args) {
        // 获取本地时间的日历对象。(包含 时分秒)
        LocalTime nowTime = LocalTime.now();
        System.out.println("今天的时间:" + nowTime);

        int hour = nowTime.getHour();//时
        System.out.println("hour: " + hour);

        int minute = nowTime.getMinute();//分
        System.out.println("minute: " + minute);
    }
}
/**
 * LocalDateTime  年、月、日、时、分、秒
 */
class LocalDateTimeDemo{
    public static void main(String[] args) {
        // 当前时间的的日历对象(包含年月日时分秒)
        LocalDateTime nowDateTime = LocalDateTime.now();

        System.out.println("今天是:" + nowDateTime);//今天是：
        System.out.println(nowDateTime.getYear());//年
        System.out.println(nowDateTime.getMonthValue());//月
        System.out.println(nowDateTime.getDayOfMonth());//日
        System.out.println(nowDateTime.getHour());//时
        System.out.println(nowDateTime.getMinute());//分
        System.out.println(nowDateTime.getSecond());//秒
        System.out.println(nowDateTime.getNano());//纳秒
        // 日:当年的第几天
        System.out.println("dayofYear:" + nowDateTime.getDayOfYear());
        //星期
        System.out.println(nowDateTime.getDayOfWeek());
        System.out.println(nowDateTime.getDayOfWeek().getValue());
        //月份
        System.out.println(nowDateTime.getMonth());
        System.out.println(nowDateTime.getMonth().getValue());

        LocalDate ld = nowDateTime.toLocalDate();
        System.out.println(ld);

        LocalTime lt = nowDateTime.toLocalTime();
        System.out.println(lt.getHour());
        System.out.println(lt.getMinute());
        System.out.println(lt.getSecond());
    }
}
/**
 * Duration  时间间隔（秒，纳，秒）
 */
class DurationDemo{
    public static void main(String[] args) {
        // 本地日期时间对象。
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 出生的日期时间对象
        LocalDateTime birthDate = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
        System.out.println(birthDate);

        Duration duration = Duration.between(birthDate, today);//第二个参数减第一个参数
        System.out.println("相差的时间间隔对象:" + duration);

        System.out.println("============================================");
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的小时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数
    }
}

/**
 * Period  时间间隔（年，月，日）
 */
class PeriodDemo{
    public static void main(String[] args) {
        // 当前本地 年月日
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 生日的 年月日
        LocalDate birthDate = LocalDate.of(2000, 1, 1);
        System.out.println(birthDate);

        Period period = Period.between(birthDate, today);//第二个参数减第一个参数

        System.out.println("相差的时间间隔对象:" + period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println(period.toTotalMonths());
    }
}

/**
 * ChronoUnit  时间间隔（所有单位）
 */
class ChronoUnitDemo{
    public static void main(String[] args) {
        // 当前时间
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        // 生日时间
        LocalDateTime birthDate = LocalDateTime.of(2000, 1, 1,0, 0, 0);
        System.out.println(birthDate);

        System.out.println("相差的年数:" + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数:" + ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数:" + ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数:" + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分数:" + ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println("相差的秒数:" + ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数:" + ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的微秒数:" + ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的纳秒数:" + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的半天数:" + ChronoUnit.HALF_DAYS.between(birthDate, today));
        System.out.println("相差的十年数:" + ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪(百年)数:" + ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数:" + ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数:" + ChronoUnit.ERAS.between(birthDate, today));
    }
}
