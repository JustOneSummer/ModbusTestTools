package link.linxun.modbus;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import link.linxun.modbus.command.CommandReader;
import link.linxun.modbus.command.ModbusCommand;
import link.linxun.modbus.config.SerialPortConfig;
import link.linxun.modbus.modbus.ModbusReader;
import link.linxun.modbus.modbus.ModbusRtuUtils;
import link.linxun.modbus.modbus.config.ModbusProtocol;

import java.util.Scanner;

/**
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class Main {
    public static void main(String[] args) throws ModbusInitException, ModbusTransportException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入COM口：");
        String com = in.next();
        System.out.println("请输入地址码：");
        int address = in.nextInt();
        SerialPortConfig config = new SerialPortConfig();
        config.setPortName(com);
        config.setBaudRate(9600);
        config.setDataBits(8);
        config.setStopBits(1);
        config.setParity(0);
        ModbusMaster master = ModbusRtuUtils.getMaster(config);
        do {
            System.out.println("请输入寄存器地址：");
            int offset = in.nextInt();
            System.out.println("读取的字节数：");
            int num = in.nextInt();
            System.out.println("执行...");
            short[] data = ModbusCommand.commandReadShorts(new CommandReader(address, ModbusProtocol.READ_HOLDING_REGISTERS, offset, num), new ModbusReader(master));
            System.out.println("数据长度：" + data.length);
            for (short d : data) {
                System.out.println(d);
            }
            System.out.println("整体");
            for (short d : data) {
                System.out.print(d);
            }
            System.out.println();
            System.out.println("是否继续y/n");
        } while (!"Y".equals(in.next().toUpperCase()));
        ModbusRtuUtils.close(config.getPortName());
    }
}
