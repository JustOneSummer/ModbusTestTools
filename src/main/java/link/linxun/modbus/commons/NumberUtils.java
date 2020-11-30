package link.linxun.modbus.commons;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

/**
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class NumberUtils {
    /**
     * 除数
     */
    private static final int DIVISOR = 10;

    public static int shortArrayToInt(short[] value) {
        int max = 4;
        if (value == null || value.length > max) {
            return 0;
        }
        StringBuilder data = new StringBuilder();
        for (short item : value) {
            data.append(item);
        }
        return Integer.parseInt(data.toString(),16);
    }

    /**
     * 小数点计算
     * 573计算后= 57.3
     *
     * @param num 待计算值
     * @return 结果
     */
    public static double numberDivisor10(double num) {
        return num / DIVISOR;
    }

    /**
     * 小数点计算
     * 573计算后= 57.3
     *
     * @param num 待计算值
     * @return 结果
     */
    public static double numberDivisor(double num, double divisor) {
        return num / divisor;
    }

    /**
     * 有符号转换
     *
     * @param b1 字节码
     * @param b2 字节码
     * @return 有符号整数
     */
    public static int convertTwoBytesToIntSigned(byte b1, byte b2) {
        return (b2 << 8) | (b1 & 0xFF);
    }


    /**
     * 有符号转换
     *
     * @param b1 字节码
     * @param b2 字节码
     * @param b3 字节码
     * @param b4 字节码
     * @return 有符号整数
     */
    public static int convertFourBytesToIntSigned(byte b1, byte b2, byte b3, byte b4) {
        return (b4 << 24) | (b3 & 0xFF) << 16 | (b2 & 0xFF) << 8 | (b1 & 0xFF);
    }

    /**
     * 无符号
     *
     * @param b1 字节码
     * @param b2 字节码
     * @return 无符号整数
     */
    public static int convertTwoBytesToIntUnsigned(byte b1, byte b2) {
        return (b2 & 0xFF) << 8 | (b1 & 0xFF);
    }

    /**
     * 无符号
     *
     * @param b1 字节码
     * @param b2 字节码
     * @param b3 字节码
     * @param b4 字节码
     * @return 无符号整数
     */
    public static long convertFourBytesToIntUnsigned(byte b1, byte b2, byte b3, byte b4) {
        return (long) (b4 & 0xFF) << 24 | (b3 & 0xFF) << 16 | (b2 & 0xFF) << 8 | (b1 & 0xFF);
    }

    /**
     * short转hex然后在转int 在转换数据类型时2组数据为一组时调用
     *
     * @param a 数据A
     * @param b 数据B
     * @return AB数据
     */
    public static int shortsToHexToInt(short a, short b) {
        return new BigInteger(hexZeroToTwoZeroOrToHex(a) + hexZeroToTwoZeroOrToHex(b), 16).intValue();
    }

    private static String hexZeroToTwoZeroOrToHex(short a) {
        return a == 0 ? "0000" : Integer.toHexString(a);
    }

    /**
     * maxLen补0 (字符个数总数64)
     *
     * @param data   数据
     * @param maxLen 总长度
     * @return 长度不足32字节时在末尾补0
     */
    public static String numberZero(String data, int maxLen) {
        if (StringUtils.isBlank(data)) {
            return zero(maxLen);
        }
        if (data.length() == maxLen) {
            return data;
        }
        return data + zero(maxLen - data.length());
    }

    /**
     * 补0操作
     *
     * @param maxLen 最大长度
     * @return 0
     */
    public static String zero(int maxLen) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

    /**
     * 数字去尾数0
     * <p>
     * 203400 -> 2034
     * <p>
     * 234 -> 234
     * </p>
     *
     * @param code 地区code - 整数
     * @return 去除尾数0后的整型字符
     */
    public static String removeTailZero(int code) {
        return removeTailZero(String.valueOf(code));
    }

    /**
     * 数字去尾数0
     * <p>
     * 203400 -> 2034
     * <p>
     * 234 -> 234
     * </p>
     *
     * @param code 地区code - 整数
     * @return 去除尾数0后的整型字符
     */
    public static String removeTailZero(String code) {

        char[] c = code.toCharArray();
        int cl = c.length;
        for (int i = cl - 1; i > 0; i--) {
            if (c[i] == 0x30) {
                c[i] = 0x20;
            } else {
                break;
            }
        }
        return StringUtils.trim(String.valueOf(c));
    }

    /**
     * 移除字符
     * remove = '0'
     * <p>
     * 203400 -> 2034
     * <p>
     * 234 -> 234
     *
     * @param src    参数
     * @param remove 移除的字符 char 类型 目前只支持单个
     * @return remove后的文本
     */
    public static String removeEndAll(String src, char remove) {
        char[] sc = src.toCharArray();
        int cl = sc.length;
        for (int i = cl - 1; i > 0; i--) {
            if (sc[i] == remove) {
                sc[i] = 0x20;
            } else {
                break;
            }
        }
        return String.valueOf(sc).trim();
    }
}
