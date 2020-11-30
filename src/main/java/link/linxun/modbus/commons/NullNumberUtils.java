package link.linxun.modbus.commons;

/**
 * Null数值类型处理
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class NullNumberUtils {
    /**
     * Double 空指针转0
     *
     * @param d {@linkplain Double}
     * @return null返回0 否则返回实际值
     */
    public static double nullToZero(Double d) {
        return d == null ? 0 : d;
    }

    /**
     * Integer 空指针转0
     *
     * @param d {@linkplain Integer}
     * @return null返回0 否则返回实际值
     */
    public static int nullToZero(Integer d) {
        return d == null ? 0 : d;
    }

    public static String nullToZeros(Integer d) {
        return d == null ? "0" : String.valueOf(d);
    }

    public static String nullToZeros(Double d) {
        return d == null ? "0" : String.valueOf(d);
    }

    public static String tdsMaxToNa(Double d) {
        final double max = 3270;
        if (d >= max) {
            return "N/A";
        }
        return String.valueOf(d);
    }
}
