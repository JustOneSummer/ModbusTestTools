package link.linxun.modbus.config;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 串口配置参数
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class SerialPortConfig {
    /**
     * 串口名称
     */
    private String portName;
    /**
     * 波特率
     */
    private Integer baudRate;
    /**
     * 数据位
     */
    private Integer dataBits;
    /**
     * 停止位
     */
    private Integer stopBits;
    /**
     * 校验方式
     */
    private Integer parity;

    @Override
    public String toString() {
        return new StringJoiner(", ", SerialPortConfig.class.getSimpleName() + "[", "]")
                .add("portName='" + portName + "'")
                .add("baudRate=" + baudRate)
                .add("dataBits=" + dataBits)
                .add("stopBits=" + stopBits)
                .add("parity=" + parity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SerialPortConfig)) {
            return false;
        }
        SerialPortConfig that = (SerialPortConfig) o;
        return Objects.equals(portName, that.portName) &&
                Objects.equals(baudRate, that.baudRate) &&
                Objects.equals(dataBits, that.dataBits) &&
                Objects.equals(stopBits, that.stopBits) &&
                Objects.equals(parity, that.parity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portName, baudRate, dataBits, stopBits, parity);
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public Integer getDataBits() {
        return dataBits;
    }

    public void setDataBits(Integer dataBits) {
        this.dataBits = dataBits;
    }

    public Integer getStopBits() {
        return stopBits;
    }

    public void setStopBits(Integer stopBits) {
        this.stopBits = stopBits;
    }

    public Integer getParity() {
        return parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }
}
