package link.linxun.modbus.commons;

/**
 * 大小端模式转换
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class BigEndUtils {

    /**
     * int转字节码  大端模式
     *
     * @param data int值
     * @return 字节码
     */
    public static byte[] intToByteArrBig(int data) {
        return new byte[]{
                (byte) ((data >> 24) & 0xFF),
                (byte) ((data >> 16) & 0xFF),
                (byte) ((data >> 8) & 0xFF),
                (byte) (data & 0xFF)
        };
    }

    /**
     * int转字节码  大端模式
     *
     * @param data int值
     * @return 字节码
     */
    public static byte[] intToByteArrEnd(int data) {
        return new byte[]{(byte) (data & 0xFF),
                (byte) ((data >> 8) & 0xFF),
                (byte) ((data >> 16) & 0xFF),
                (byte) ((data >> 24) & 0xFF)
        };
    }


    /**
     * 大端
     *
     * @param data 字节码
     * @return 大端输出
     */
    public static int big(byte[] data) {
        return (data[0] & 0xFF) |
                (data[1] & 0xFF) << 8 |
                (data[2] & 0xFF) << 16 |
                (data[3] & 0xFF) << 24;
    }

    /**
     * 小端
     *
     * @param data 字节码
     * @return 小端输出
     */
    public static int end(byte[] data) {
        return (data[0] & 0xFF) << 24 |
                (data[1] & 0xFF) << 16 |
                (data[2] & 0xFF) << 8 |
                (data[3] & 0xFF);
    }

    /**
     * 小端
     *
     * @param data 字节码
     * @return 小端输出
     */
    public static short bigShort(byte[] data) {
        return (short) ((data[0] & 0xFF) | (data[1] & 0xFF) << 8);
    }

    /**
     * 小端
     *
     * @param data 字节码
     * @return 小端输出
     */
    public static short endShort(byte[] data) {
        return (short) ((data[1] & 0xFF) << 8 | (data[0] & 0xFF));
    }

    /**
     * 大端
     *
     * @param data 字节码
     * @return 大端输出
     */
    public static long bigLong(byte[] data) {
        return ((long) (data[0] & 0xFF)) |
                ((long) (data[1] & 0xFF)) << 8 |
                ((long) (data[2] & 0xFF)) << 16 |
                ((long) (data[3] & 0xFF)) << 24 |
                ((long) (data[4] & 0xFF)) << 32 |
                ((long) (data[5] & 0xFF)) << 40 |
                ((long) (data[6] & 0xFF)) << 48 |
                ((long) (data[7] & 0xFF)) << 56;
    }

    /**
     * 小端
     *
     * @param data 字节码
     * @return 小端输出
     */
    public static long endLong(byte[] data) {
        return ((long) (data[0] & 0xFF)) << 56 |
                ((long) (data[1] & 0xFF)) << 48 |
                ((long) (data[2] & 0xFF)) << 40 |
                ((long) (data[3] & 0xFF)) << 32 |
                ((long) (data[4] & 0xFF)) << 24 |
                ((long) (data[5] & 0xFF)) << 16 |
                ((long) (data[6] & 0xFF)) << 8 |
                ((long) (data[7] & 0xFF));
    }
}
