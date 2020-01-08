package club.krislin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package club.krislin.utils
 * @ClassName DateUtils
 * @Description TODO
 * @Date 20/1/6 11:54
 * @Author LIM
 * @Version V1.0
 */
public class DateUtils {
    /**
     * 日期转字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String date2String(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 字符串转日期
     * @param str
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(str);
        return date;
    }
}
