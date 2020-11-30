package link.linxun.modbus.analyze;

import java.util.StringJoiner;

/**
 * ups协议
 *
 * @author CaoXun
 * @date 2020/11/30 14:48 星期一
 */
public class Ups {
    /**
     * 市电电压 5-4  110000=00  100000=01 10000=10
     */
    private String ups1030_0;

    /**
     * 蓄电池总电压 12-10  000：正常 0
     * 001：电池无 1
     * 010：低于下限（关机点） 2
     * 011：高于上限（电压过高 ） 3
     * 100：接反 4
     * 101：预告警 5
     */
    private String ups1030_1;
    /**
     * 开关机 6
     */
    private String ups1040_0;
    /**
     * 供电方式 2-1-0 000：整流电池均不供电
     * 001：主路逆变供电
     * 010：电池逆变供电
     * 011：旁路供电
     * 100：联合逆变供电
     */
    private String ups1040_1;
    /**
     * 交流输入相电压 A
     */
    private int ups1050_0;
    /**
     * 交流输入相电压 B
     */
    private int ups1051_0;
    /**
     * 交流输入相电压 C
     */
    private int ups1052_0;
    /**
     * 交流输出相电压 A
     */
    private int ups1053_0;
    /**
     * 交流输出相电压 B
     */
    private int ups1054_0;
    /**
     * 交流输出相电压 C
     */
    private int ups1055_0;
    /**
     * 交流输出电流 A
     */
    private int ups1056_0;
    /**
     * 交流输出电流 B
     */
    private int ups1057_0;
    /**
     * 交流输出电流 C
     */
    private int ups1058_0;
    /**
     * 直流输入电压（电池电压）
     */
    private int ups1059_0;
    /**
     * 输出频率（三相一致）
     */
    private int ups1060_0;
    /**
     * A 相输出有功功率
     */
    private int ups1080_0;
    /**
     * B 相输出有功功率
     */
    private int ups1081_0;
    /**
     * C 相输出有功功率
     */
    private int ups1082_0;

    @Override
    public String toString() {
        return new StringJoiner(", ", Ups.class.getSimpleName() + "[", "]")
                .add("市电电压=" + ups1030_0)
                .add("蓄电池总电压=" + ups1030_1)
                .add("开关机=" + ups1040_0)
                .add("供电方式=" + ups1040_1)
                .add("交流输入相电压A=" + ups1050_0)
                .add("交流输入相电压B=" + ups1051_0)
                .add("交流输入相电压C=" + ups1052_0)
                .add("交流输出相电压A=" + ups1053_0)
                .add("交流输出相电压B=" + ups1054_0)
                .add("交流输出相电压C=" + ups1055_0)
                .add("交流输出电流=A" + ups1056_0)
                .add("交流输出电流=B" + ups1057_0)
                .add("交流输出电流=C" + ups1058_0)
                .add("直流输入电压（电池电压）=" + ups1059_0)
                .add("输出频率（三相一致）=" + ups1060_0)
                .add("A 相输出有功功率=" + ups1080_0)
                .add("B 相输出有功功率=" + ups1081_0)
                .add("C 相输出有功功率=" + ups1082_0)
                .toString();
    }

    public String getUps1030_0() {
        return ups1030_0;
    }

    public void setUps1030_0(String ups1030_0) {
        this.ups1030_0 = ups1030_0;
    }

    public String getUps1030_1() {
        return ups1030_1;
    }

    public void setUps1030_1(String ups1030_1) {
        this.ups1030_1 = ups1030_1;
    }

    public String getUps1040_0() {
        return ups1040_0;
    }

    public void setUps1040_0(String ups1040_0) {
        this.ups1040_0 = ups1040_0;
    }

    public String getUps1040_1() {
        return ups1040_1;
    }

    public void setUps1040_1(String ups1040_1) {
        this.ups1040_1 = ups1040_1;
    }

    public int getUps1050_0() {
        return ups1050_0;
    }

    public void setUps1050_0(int ups1050_0) {
        this.ups1050_0 = ups1050_0;
    }

    public int getUps1051_0() {
        return ups1051_0;
    }

    public void setUps1051_0(int ups1051_0) {
        this.ups1051_0 = ups1051_0;
    }

    public int getUps1052_0() {
        return ups1052_0;
    }

    public void setUps1052_0(int ups1052_0) {
        this.ups1052_0 = ups1052_0;
    }

    public int getUps1053_0() {
        return ups1053_0;
    }

    public void setUps1053_0(int ups1053_0) {
        this.ups1053_0 = ups1053_0;
    }

    public int getUps1054_0() {
        return ups1054_0;
    }

    public void setUps1054_0(int ups1054_0) {
        this.ups1054_0 = ups1054_0;
    }

    public int getUps1055_0() {
        return ups1055_0;
    }

    public void setUps1055_0(int ups1055_0) {
        this.ups1055_0 = ups1055_0;
    }

    public int getUps1056_0() {
        return ups1056_0;
    }

    public void setUps1056_0(int ups1056_0) {
        this.ups1056_0 = ups1056_0;
    }

    public int getUps1057_0() {
        return ups1057_0;
    }

    public void setUps1057_0(int ups1057_0) {
        this.ups1057_0 = ups1057_0;
    }

    public int getUps1058_0() {
        return ups1058_0;
    }

    public void setUps1058_0(int ups1058_0) {
        this.ups1058_0 = ups1058_0;
    }

    public int getUps1059_0() {
        return ups1059_0;
    }

    public void setUps1059_0(int ups1059_0) {
        this.ups1059_0 = ups1059_0;
    }

    public int getUps1060_0() {
        return ups1060_0;
    }

    public void setUps1060_0(int ups1060_0) {
        this.ups1060_0 = ups1060_0;
    }

    public int getUps1080_0() {
        return ups1080_0;
    }

    public void setUps1080_0(int ups1080_0) {
        this.ups1080_0 = ups1080_0;
    }

    public int getUps1081_0() {
        return ups1081_0;
    }

    public void setUps1081_0(int ups1081_0) {
        this.ups1081_0 = ups1081_0;
    }

    public int getUps1082_0() {
        return ups1082_0;
    }

    public void setUps1082_0(int ups1082_0) {
        this.ups1082_0 = ups1082_0;
    }
}
