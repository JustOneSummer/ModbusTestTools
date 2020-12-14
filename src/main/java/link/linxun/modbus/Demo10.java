package link.linxun.modbus;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import link.linxun.modbus.command.CommandWriter;
import link.linxun.modbus.command.ModbusCommand;
import link.linxun.modbus.config.SerialPortConfig;
import link.linxun.modbus.modbus.ModbusReader;
import link.linxun.modbus.modbus.ModbusRtuUtils;
import link.linxun.modbus.modbus.ModbusWriter;
import link.linxun.modbus.modbus.config.ModbusProtocol;

/**
 * @author CaoXun
 * @date 2020/12/10 11:54 星期四
 */
public class Demo10 {
    public static void main(String[] args) throws ModbusInitException, ModbusTransportException {
        SerialPortConfig config = new SerialPortConfig();
        config.setPortName("COM1");
        config.setBaudRate(9600);
        config.setDataBits(8);
        config.setStopBits(1);
        config.setParity(0);
        ModbusMaster master = ModbusRtuUtils.getMaster(config);
        System.out.println("发送指令");
        CommandWriter writer = new CommandWriter(1, ModbusProtocol.WRITE_MULTIPLE_REGISTERS, 21, (short) 22);
        boolean b = ModbusCommand.commandWriter(writer, new ModbusWriter(master));
        System.out.println(b);
    }
}
