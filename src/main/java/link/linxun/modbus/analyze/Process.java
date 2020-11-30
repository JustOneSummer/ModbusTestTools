package link.linxun.modbus.analyze;

/**
 * @author CaoXun
 * @date 2020/11/30 15:09 星期一
 */
public class Process {
    public static void pr(short[] data) {
        Ups ups = new Ups();
        ups.setUps1030_0(String.valueOf((data[0] >> 4 & 0x03)));
        ups.setUps1030_1(String.valueOf(data[0] >> 10 & 0x07));
        ups.setUps1040_0(String.valueOf(data[19] >> 6 & 0x01));
        ups.setUps1040_1(String.valueOf(data[19] & 0x07));
        ups.setUps1050_0(data[29]);
        ups.setUps1051_0(data[30]);
        ups.setUps1052_0(data[31]);
        ups.setUps1053_0(data[32]);
        ups.setUps1054_0(data[33]);
        ups.setUps1055_0(data[34]);
        ups.setUps1056_0(data[35]);
        ups.setUps1057_0(data[36]);
        ups.setUps1058_0(data[37]);
        ups.setUps1059_0(data[38]);
        ups.setUps1060_0(data[39]);
        ups.setUps1080_0(data[49]);
        ups.setUps1081_0(data[50]);
        ups.setUps1082_0(data[51]);
        System.out.println(ups.toString());
    }

    public static void main(String[] args) {
        int a = 288 & 32;
        short[] data = new short[]{5120};
        System.out.println(a);
        System.out.println((data[0] >> 10 & 0x07));
    }
}
