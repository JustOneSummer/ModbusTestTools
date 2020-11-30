package link.linxun.modbus.commons;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class DateUtils {
    /**
     * 日期格式化-小时
     */
    public final static String SQL_LITE_YMD_H = "%Y-%m-%d %H";
    /**
     * 日期格式化-天
     */
    public final static String SQL_LITE_YMD = "%Y-%m-%d";
    /**
     * 入库最大数据写入间隔时间
     */
    public final static int CACHE_MAX_TIME = 60000;

    /**
     * 历史数据处理时间查询
     *
     * @param startDate 时间戳
     * @param endDate   时间戳
     * @return 计算后的时间
     */
    public static LocalDateTime[] processHistoryData(Long startDate, Long endDate) {
        String date = LocalDate.now(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_DATE);
        LocalDateTime start = LocalDateTime.parse(date + "T00:00");
        LocalDateTime end = LocalDateTime.parse(date + "T23:59");
        if (startDate != null && endDate != null) {
            start = DateUtils.epochMilliToLocalDateTime(startDate);
            end = DateUtils.epochMilliToLocalDateTime(endDate);
        }
        return new LocalDateTime[]{start, end};
    }

    /**
     * 获取当前日期时间戳
     *
     * @return 时间戳
     */
    public static String getToEpochMilli() {
        return String.valueOf(LocalDateTime.now(ZoneId.systemDefault()).toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }

    /**
     * 获取日期的时间戳 {@linkplain Long}
     *
     * @param dateTime 日期{@linkplain LocalDateTime}
     * @return 时间戳
     */
    public static String toEpochMilli(LocalDateTime dateTime) {
        return String.valueOf(dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }

    /**
     * 获取日期的时间戳 {@linkplain Long}
     *
     * @param dateTime 日期{@linkplain LocalDateTime}
     * @return 时间戳
     */
    public static long toEpochMilliLong(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 日期转换
     *
     * @param milli 毫秒
     * @return 日期
     */
    public static LocalDateTime epochMilliToLocalDateTime(long milli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneOffset.of("+8"));
    }

    /**
     * 获取sql时间 {@linkplain Timestamp}
     *
     * @return 时间
     */
    public static Timestamp getDateTime() {
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.systemDefault()));
    }
}
