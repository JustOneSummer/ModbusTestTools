package link.linxun.modbus.modbus.wrapper;

import com.serotonin.modbus4j.serial.SerialPortWrapper;
import gnu.io.NRSerialPort;
import link.linxun.modbus.config.SerialPortConfig;
import link.linxun.modbus.modbus.serialport.manager.SerialPortNrManager;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class SerialPortNrWrapperImpl implements SerialPortWrapper {
    private final SerialPortConfig config;
    private NRSerialPort nrSerialPort;

    public SerialPortNrWrapperImpl(SerialPortConfig config) {
        this.config = config;
    }

    @Override
    public void close() throws Exception {
        this.nrSerialPort.disconnect();
    }

    @Override
    public void open() throws Exception {
        this.nrSerialPort = SerialPortNrManager.openPort(this.config);
    }

    @Override
    public InputStream getInputStream() {
        return this.nrSerialPort.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        return this.nrSerialPort.getOutputStream();
    }

    @Override
    public int getBaudRate() {
        return this.nrSerialPort.getBaud();
    }

    @Override
    public int getFlowControlIn() {
        return 0;
    }

    @Override
    public int getFlowControlOut() {
        return 0;
    }

    @Override
    public int getDataBits() {
        return this.nrSerialPort.getDataBits();
    }

    @Override
    public int getStopBits() {
        return this.nrSerialPort.getStopBits();
    }

    @Override
    public int getParity() {
        return this.nrSerialPort.getParity();
    }
}
