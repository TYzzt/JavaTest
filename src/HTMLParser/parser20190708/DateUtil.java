package HTMLParser.parser20190708;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtil {
    /**
     * 日期格式为{@value},例如:"2004";
     */
    public static final String DATE_STYLE0 = "yyyy";
    /**
     * 日期格式为{@value},例如:"200408";
     */
    public static final String DATE_STYLE1 = "yyyyMM";

    /**
     * 日期格式为{@value},例如:"20040823";
     */
    public static final String DATE_STYLE2 = "yyyyMMdd";

    /**
     * 日期格式为"yyyy年MM月dd日 星期X",例如:"2006年05月26日 星期五";
     */
    public static final String DATE_STYLE3 = "yyyy年MM月dd日 E";

    /**
     * 日期格式为{@value},例如:"2006-05-26";
     */
    public static final String DATE_STYLE4 = "yyyy-MM-dd";

    /**
     * 日期格式为{@value},例如:"2006-05-26 17:11:01";
     */
    public static final String DATE_STYLE5 = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式为{@value},例如:"2006-05-26 17:11";
     */
    public static final String DATE_STYLE51 = "yyyy-MM-dd HH:mm";
    /**
     * 日期格式为{@value},例如:"2006.05.26.17.11.01.123";
     */
    public static final String DATE_STYLE8 = "yyyy.MM.dd.HH.mm.ss.SSS";

    /**
     * 日期格式为{@value},例如:"2006.05.26";
     */
    public static final String DATE_STYLE6 = "yyyy.MM.dd";


    /**
     * 日期格式为{@value},例如:"2006-05-26 16:06";
     */
    public static final String DATE_STYLE61 = "yyyy-MM-dd HH:mm";
    /**
     * 日期格式为"yyyy年MM月dd日 星期X",例如:"2006年05月26日 ";
     */
    public static final String DATE_STYLE7 = "yyyy年MM月dd日 ";

    /**
     * 所属期起日;
     */
    public static final String SSSQ_Q = "qq";

    /**
     * 所属期之日;
     */
    public static final String SSSQ_Z = "qz";
    /**
     * 起始日期
     */
    public static final String START_DATE = "STARTDATE";
    /**
     * 起始日期
     */
    public static final String END_DATE = "ENDDATE";

    /**
     * 参数：会计年度，会计区间，标示符(年月分开)
     */
    public static String getStartAndEndDate(String kjnd, String kjqj,
                                            String date_flag) {
        if (DateUtil.START_DATE.equals(date_flag)) {
            return kjnd + kjqj + "01";
        }
        // 取30天的月
        if (DateUtil.END_DATE.equals(date_flag)) {
            if ("04".equals(kjqj) || "06".equals(kjqj) || "09".equals(kjqj)
                    || "11".equals(kjqj)) {
                return kjnd + kjqj + "30";
            }
            // 取31天的月
            if ("01".equals(kjqj) || "03".equals(kjqj) || "05".equals(kjqj)
                    || "07".equals(kjqj) || "08".equals(kjqj)
                    || "10".equals(kjqj) || "12".equals(kjqj)) {
                return kjnd + kjqj + "31";
            }
            // 计算二月
            if ((Integer.parseInt(kjnd) % 4 == 0
                    && Integer.parseInt(kjnd) % 100 != 0 || Integer
                    .parseInt(kjnd) % 400 == 0)) {
                return kjnd + kjqj + "29";
            } else {
                return kjnd + kjqj + "28";
            }
        }

        return "";
    }

    /**
     * 参数：会计年度，会计区间，标示符(年月合并)
     */
    public static String getStartAndEndDate(String kjnd_kjqj, String date_flag) {
        String kjnd = kjnd_kjqj.substring(0, 4);
        String kjqj = kjnd_kjqj.substring(4, 6);
        if (DateUtil.START_DATE.equals(date_flag)) {
            return kjnd + kjqj + "01";
        }
        // 取30天的月
        if (DateUtil.END_DATE.equals(date_flag)) {
            if ("04".equals(kjqj) || "06".equals(kjqj) || "09".equals(kjqj)
                    || "11".equals(kjqj)) {
                return kjnd + kjqj + "30";
            }
            // 取31天的月
            if ("01".equals(kjqj) || "03".equals(kjqj) || "05".equals(kjqj)
                    || "07".equals(kjqj) || "08".equals(kjqj)
                    || "10".equals(kjqj) || "12".equals(kjqj)) {
                return kjnd + kjqj + "31";
            }
            // 计算二月
            if ((Integer.parseInt(kjnd) % 4 == 0
                    && Integer.parseInt(kjnd) % 100 != 0 || Integer
                    .parseInt(kjnd) % 400 == 0)) {
                return kjnd + kjqj + "29";
            } else {
                return kjnd + kjqj + "28";
            }
        }

        return null;
    }


    public static List getDateListByStr(String startDate, String endDate) {
        List dateList = new ArrayList();
        int intStart = Integer.parseInt(startDate);
        int intEnd = Integer.parseInt(endDate);
        for (; intStart <= intEnd; intStart++) {
            String time = Integer.toString(intStart);
            if (startDate.length() == 2 && time.length() == 1) {
                time = "0" + time;
            }
            dateList.add(time);
        }
        return dateList;
    }

    /**
     * 检验开始时间与结束时间的大小关系
     */
    public static boolean checkDate(String startDate, String endDate) {
        int intStart = Integer.parseInt(startDate);
        int intEnd = Integer.parseInt(endDate);
        if (intStart <= intEnd) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // System.out.println(DateUtil.getStartAndEndDate("1904","02",DateUtil.END_DATE));
//		System.out.println(DateUtil.getStartAndEndDate("190402",
//				DateUtil.END_DATE));
//		List list = DateUtil.getDateList("2000", "2010");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(((ComboxBean) list.get(i)).getText());
//		}
//
//		System.out.println(DateUtil.checkDate("09", "02"));
//		System.out.println(DateUtil.checkDate("2008", "2008"));
        new DateUtil().dateDiff("2009-8-21", "2010-8-23", "yyyy-MM-dd");
        List l = DateUtil.getDateListByStr("01", "12");
        System.out.println(l);
    }

    /**
     * 获取当前日期字符串;<br>
     *
     * @param style 日期样式;目前预定义的样式有:<br>
     *              {@link #DATE_STYLE0}:日期格式为"yyyy";<br>
     *              {@link #DATE_STYLE1}:日期格式为"yyyyMM";<br>
     *              {@link #DATE_STYLE2}:日期格式为"yyyyMMdd";<br>
     *              {@link #DATE_STYLE3}:日期格式为"yyyy年MM月dd日 星期X";<br>
     *              {@link #DATE_STYLE4}:日期格式为"yyyy-MM-dd";<br>
     *              {@link #DATE_STYLE5}:日期格式为"yyyy-MM-dd HH:mm:ss";<br>
     * @return String
     * @author C.Chen
     */
    public static String getDateStr(String style) {
        return getDateStr(style, new Date());
    }


    /**
     * 获取指定日期的字符串日期;<br>
     *
     * @param style 日期样式;目前预定义的样式有:<br>
     *              {@link #DATE_STYLE0}:日期格式为"yyyy";<br>
     *              {@link #DATE_STYLE1}:日期格式为"yyyyMM";<br>
     *              {@link #DATE_STYLE2}:日期格式为"yyyyMMdd";<br>
     *              {@link #DATE_STYLE3}:日期格式为"yyyy年MM月dd日 星期X";<br>
     *              {@link #DATE_STYLE4}:日期格式为"yyyy-MM-dd";<br>
     *              {@link #DATE_STYLE5}:日期格式为"yyyy-MM-dd HH:mm:ss";<br>
     * @param date  指定的日期;
     * @return String
     * @author C.Chen
     */
    public static String getDateStr(String style, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(style, Locale.CHINA);
        return sdf.format(date);
    }

    /**
     * 获取当前时间的上月的年、月;<br>
     * 例如：当前日期为“20070313”，返回日期为“200702”
     *
     * @return String 返回日期格式为"yyyyMM",例如:"200408";
     * @author C.Chen
     */
    public static String getLastMonth() {
        StringBuffer buff = new StringBuffer(10);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        // 为某年的一月份时
        if (month == 0) {
            year = year - 1;
            month = 12;
        }
        buff.append(year);
        buff.append((month < 10) ? "0" + month : "" + month);

        return buff.toString();
    }

    /**
     * 解析指定日期字符串,获得日期类型的对象;
     *
     * @param style   日期样式;目前预定义的样式有:<br>
     *                {@link #DATE_STYLE1}:日期格式为"yyyyMM";<br>
     *                {@link #DATE_STYLE2}:日期格式为"yyyyMMdd";<br>
     *                {@link #DATE_STYLE3}:日期格式为"yyyy年MM月dd日 星期X";<br>
     *                {@link #DATE_STYLE4}:日期格式为"yyyy-MM-dd";<br>
     *                {@link #DATE_STYLE5}:日期格式为"yyyy-MM-dd HH:mm:ss";<br>
     * @param dateStr 需要转换的日期字符串;
     * @return Date
     * @author C.Chen
     */
    public static Date parseDate(String style, String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(style, Locale.CHINA);
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 计算出某年某月的天数;
     *
     * @param year  指定的年份，格式为"yyyy";
     * @param month 指定的月份，格式为"MM";
     * @return int 指定月份的天数;
     * @author C.Chen
     */
    public static int getDaysOfMonth(String yyyy, String mm) {
        int year = Integer.parseInt(yyyy);
        int month = Integer.parseInt(mm);
        return getDaysOfMonth(year, month);
    }

    /**
     * 将日期格式格式化成指定的其他格式
     *
     * @param style     当前格式
     * @param dateStr   日期字符串
     * @param destStyle 目标格式
     * @return
     */
    public static String parseDateStr(String style, String dateStr, String destStyle) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(style, Locale.CHINA);
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
//			log.error("转换日期异常",e);
        }
        return getDateStr(destStyle, date);
    }

    /**
     * 计算出某年某月的天数;
     *
     * @param year  指定的年份;
     * @param month 指定的月份;
     * @return int 指定月份的天数;
     * @author C.Chen
     */
    public static int getDaysOfMonth(int year, int month) {
        int monthCount = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthCount = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthCount = 30;
                break;
            case 2:
                if (((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0) {
                    monthCount = 29;
                } else {
                    monthCount = 28;
                }
                break;
        }

        return monthCount;
    }

    /**
     * 获取指定日期之前（一定天数）的日期;
     *
     * @param date    指定的日期;
     * @param preDays 指定日期之前的天数;
     * @return Date
     * @author C.Chen
     */
    public static Date getBeforeDate(Date date, int days) {
        String tempDate = getDateStr(DATE_STYLE2, date);

        int yyyy = Integer.parseInt(tempDate.substring(0, 4));
        int mm = Integer.parseInt(tempDate.substring(4, 6));
        int dd = Integer.parseInt(tempDate.substring(6, 8));

        dd = dd - days;
        while (dd <= 0) {
            if (mm == 1) {
                yyyy = yyyy - 1;
                mm = 12;
            } else {
                mm = mm - 1;
            }

            dd = dd + getDaysOfMonth(yyyy, mm);
        }

        StringBuffer buff = new StringBuffer(10);
        buff.append(yyyy);
        buff.append((String.valueOf(mm).length() == 1) ? "0" + mm : String
                .valueOf(mm));
        buff.append((String.valueOf(dd).length() == 1) ? "0" + dd : String
                .valueOf(dd));

        return parseDate(DATE_STYLE2, buff.toString());
    }

    /**
     * 获取指定日期之后（一定天数）的日期;
     *
     * @param date    指定的日期;
     * @param preDays 指定日期之后的天数;
     * @return Date
     * @author C.Chen
     */
    public static Date getAfterDate(Date date, int days) {
        String tempDate = getDateStr(DATE_STYLE2, date);

        int yyyy = Integer.parseInt(tempDate.substring(0, 4));
        int mm = Integer.parseInt(tempDate.substring(4, 6));
        int dd = Integer.parseInt(tempDate.substring(6, 8));

        dd = dd + days;
        while (dd > getDaysOfMonth(yyyy, mm)) {
            if (mm == 12) {
                yyyy = yyyy + 1;
                mm = 1;
            } else {
                mm = mm + 1;
            }

            if (mm == 1)
                dd = dd - getDaysOfMonth(yyyy - 1, 12);
            else
                dd = dd - getDaysOfMonth(yyyy, mm - 1);
        }

        StringBuffer buff = new StringBuffer(10);
        buff.append(yyyy);
        buff.append((String.valueOf(mm).length() == 1) ? "0" + mm : String
                .valueOf(mm));
        buff.append((String.valueOf(dd).length() == 1) ? "0" + dd : String
                .valueOf(dd));

        return parseDate(DATE_STYLE2, buff.toString());
    }

    /**
     * 将日期字符串由8位("yyyyMMdd")转换为10位("yyyy-MM-dd");
     *
     * @param rq 8位的字符串日期;
     * @return String 10位的字符串日期,如果转换错误将返回NULL;
     */
    public static String getRq8To10(String rq) {
        String result = null;
        if (rq.length() == 10) {
            return rq;
        }
        if (rq.length() == 8) {
            result = rq.substring(0, 4) + "-" + rq.substring(4, 6) + "-"
                    + rq.substring(6, 8);
        }
        return result;
    }

    /**
     * 将日期字符串由10位("yyyy-MM-dd")转换为8位("yyyyMMdd");
     *
     * @param rq 10位的字符串日期;
     * @return String 8位的字符串日期,如果转换错误将返回NULL;
     * @author C.Chen
     */
    public static String getRq10To8(String rq) {
        String result = null;
        if (rq.length() == 8) {
            return rq;
        }
        if (rq.length() == 10) {
            result = rq.substring(0, 4) + rq.substring(5, 7)
                    + rq.substring(8, 10);
        }
        return result;
    }

    /**
     * 获取当前时间的毫秒数
     *
     * @return
     */
    public static String getCurrentTimeMillis() {
        return Long.toString(System.currentTimeMillis());
    }

    /**
     * 计算指定时间起止的相差天数
     *
     * @param startTime
     * @param endTime
     * @param format
     */
    public static long dateDiff(String startTime, String endTime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
/*
		long nh = 1000*60*60;//一小时的毫秒数

		long nm = 1000*60;//一分钟的毫秒数

		long ns = 1000;//一秒钟的毫秒数
*/
        long diff;

        try {

            //获得两个时间的毫秒时间差异

            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();

            long day = diff / nd;//计算差多少天
            return day;
/*	
			long hour = diff/nh;//计算差多少小时
	
			long min = diff/nm;//计算差多少分钟
	
			long sec = diff/ns;//计算差多少秒
*/
            //输出结果

//			System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");

        } catch (ParseException e) {
            e.printStackTrace();
            return 0l;
        }
    }


    /**
     * 获取每月的最后一天
     *
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    public static Integer getMonthLastdata(int year, int month) throws ParseException {
        List<Integer> monthList = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        if (monthList.contains(month))
            return 31;
        if (month == 2 && ((year % 4 == 0 || year % 400 == 0) && year % 100 != 0))
            return 29;
        else if (month == 2)
            return 28;
        else
            return 30;

    }

    /**
     * 比较时间大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                //System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                //System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算两个时间相差的秒数
     *
     * @param startDate
     * @param endDate
     * @return 秒数
     * @throws Exception
     */
    public static long secondBetween(String startDate, String endDate) throws Exception {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin = dfs.parse(startDate);
        Date end = dfs.parse(endDate);
        long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
        return between;
    }

    /**
     * 根据秒数获取时间串
     *
     * @param second (eg: 100s)
     * @return (eg : 00 : 01 : 40)
     */
    public static String getTimeStrBySecond(long second) {
        if (second <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        long hours = second / (60 * 60);
        if (hours > 0) {
            second -= hours * (60 * 60);
        }

        long minutes = second / 60;
        if (minutes > 0) {
            second -= minutes * 60;
        }

        return (hours > 10 ? (hours + "") : ("0" + hours)) + ":" + (minutes > 10 ? (minutes + "") : ("0" + minutes)) + ":" + (second > 10 ? (second + "") : ("0" + second));
    }
}
