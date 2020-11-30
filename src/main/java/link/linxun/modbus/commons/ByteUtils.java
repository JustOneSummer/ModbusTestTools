package link.linxun.modbus.commons;

import java.nio.ByteBuffer;
import java.util.Locale;

/**
 * byte处理
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ByteUtils {
    /**
     * 十六进制字符串转byte[]
     *
     * @param hex 十六进制字符串
     * @return byte[]
     */
    public static byte[] hexStringByte(String hex) {
        if (hex == null) {
            return new byte[]{};
        }
        final int index = 2;
        // 奇数位补0
        if (hex.length() % index != 0) {
            hex = "0" + hex;
        }
        int length = hex.length();
        ByteBuffer buffer = ByteBuffer.allocate(length / 2);
        for (int i = 0; i < length; i++) {
            String hexStr = hex.charAt(i) + "";
            i++;
            hexStr += hex.charAt(i);
            byte b = (byte) Integer.parseInt(hexStr, 16);
            buffer.put(b);
        }
        return buffer.array();
    }

    /**
     * byte[]转十六进制字符串
     *
     * @param array byte[]
     * @return 十六进制字符串
     */
    public static String byteArrayToHexString(byte[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        for (byte b : array) {
            buffer.append(byteToHex(b));
        }
        return buffer.toString();
    }

    /**
     * byte转十六进制字符
     *
     * @param b byte
     * @return 十六进制字符
     */
    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        return hex.toUpperCase(Locale.getDefault());
    }

    public static String byteToHexArr(byte... b) {
        StringBuilder builder = new StringBuilder();
        for (byte a : b) {
            builder.append(byteToHex(a));
        }
        return builder.toString();
    }

    /**
     * 将一个16位的short转换为长度为2的8位byte数组
     *
     * @param s 16位short
     * @return 8位bytes
     */
    public static byte[] shortToBytes(short s) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (s >> 8);
        arr[1] = (byte) (s & 0xff);
        return arr;
    }
}
