package link.linxun.modbus.modbus.serialport.manager;

import gnu.io.NRSerialPort;
import link.linxun.modbus.config.SerialPortConfig;

/**
 * NRSerialPort
 * https://github.com/NeuronRobotics/nrjavaserial
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class SerialPortNrManager {

    /**
     * 打开串口
     *
     * @param config 串口配置
     * @return {@linkplain NRSerialPort}
     */
    public static NRSerialPort openPort(SerialPortConfig config) {
        NRSerialPort nrSerialPort = new NRSerialPort(config.getPortName(), config.getBaudRate(), config.getParity(), config.getDataBits(), config.getStopBits());
        nrSerialPort.connect();
        return nrSerialPort;
    }

    /**
     * 关闭串口
     *
     * @param serialPort 串口对象
     */
    public static void closePort(NRSerialPort serialPort) {
        if (serialPort != null) {
            serialPort.disconnect();
        }
    }
}
