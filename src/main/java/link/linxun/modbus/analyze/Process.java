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
        ups.setUps1040_0(String.valueOf(data[10] >> 6 & 0x01));
        ups.setUps1040_1(String.valueOf(data[10] & 0x07));
        ups.setUps1050_0(data[20]);
        ups.setUps1051_0(data[21]);
        ups.setUps1052_0(data[22]);
        ups.setUps1053_0(data[23]);
        ups.setUps1054_0(data[24]);
        ups.setUps1055_0(data[25]);
        ups.setUps1056_0(data[26]);
        ups.setUps1057_0(data[27]);
        ups.setUps1058_0(data[28]);
        ups.setUps1059_0(data[29]);
        ups.setUps1060_0(data[30]);
        ups.setUps1080_0(data[50]);
        ups.setUps1081_0(data[51]);
        ups.setUps1082_0(data[52]);
        System.out.println(ups.toString());
    }
}
