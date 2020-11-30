package link.linxun.modbus.commons;

/**
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class VolatilityDataUtils {
    /**
     * 区间波动计算
     *
     * @param a             数据A
     * @param b             数据B
     * @param volatilityDat 区间值
     * @return 是否超过
     */
    public static boolean analyze(Double a, Double b, double volatilityDat) {
        a = NullNumberUtils.nullToZero(a);
        b = NullNumberUtils.nullToZero(b);
        return ((a - b) >= volatilityDat) || (b - a) >= volatilityDat;
    }

    /**
     * 区间波动计算
     *
     * @param a             数据A
     * @param b             数据B
     * @param volatilityDat 区间值
     * @return 是否超过
     */
    public static boolean analyze(Integer a, Integer b, int volatilityDat) {
        a = NullNumberUtils.nullToZero(a);
        b = NullNumberUtils.nullToZero(b);
        return ((a - b) >= volatilityDat) || (b - a) >= volatilityDat;
    }

    /**
     * 上限判断
     *
     * @param a         数据A
     * @param threshold 上限
     * @return 是否
     */
    public static boolean checkUpper(Double a, double threshold) {
        a = NullNumberUtils.nullToZero(a);
        return a > threshold;
    }


    /**
     * 下限判断
     *
     * @param a         数据A
     * @param threshold 下限
     * @return 是否
     */
    public static boolean checkLower(Double a, double threshold) {
        a = NullNumberUtils.nullToZero(a);
        return a < threshold;
    }

}
