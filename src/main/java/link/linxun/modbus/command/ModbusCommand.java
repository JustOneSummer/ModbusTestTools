package link.linxun.modbus.command;

import com.serotonin.modbus4j.exception.ModbusTransportException;
import link.linxun.modbus.modbus.ModbusReader;
import link.linxun.modbus.modbus.ModbusWriter;

/**
 * 读写命令管理
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ModbusCommand {
    /**
     * 写入
     *
     * @param writer       写指令{@linkplain CommandWriter}
     * @param modbusWriter 指令执行体{@linkplain ModbusWriter}
     * @return 执行结果
     * @throws ModbusTransportException 写异常
     */
    public static boolean commandWriter(CommandWriter writer, ModbusWriter modbusWriter) throws ModbusTransportException {
        switch (writer.getModbusProtocol()) {
            //05
            case WRITE_SINGLE_COIL:
                return modbusWriter.writeCoil(writer);
            //06
            case WRITE_SINGLE_REGISTER:
                return modbusWriter.writeRegister(writer);
            //10
            case WRITE_MULTIPLE_REGISTERS:
                return modbusWriter.writeRegisters(writer);
            //0F
            case WRITE_MULTIPLE_COILS:
                return modbusWriter.writeCoils(writer);
            default:
                return false;
        }
    }

    /**
     * 线圈读取
     *
     * @param reader       读指令{@linkplain CommandReader}
     * @param modbusReader 指令执行体{@linkplain ModbusReader}
     * @return 执行结果
     * @throws ModbusTransportException 读取异常
     */
    public static boolean[] commandReadBooleans(CommandReader reader, ModbusReader modbusReader) throws ModbusTransportException {
        switch (reader.getModbusProtocol()) {
            //01
            case READ_COILS:
                return modbusReader.readCoilStatus(reader);
            //02
            case READ_DISCRETE_INPUTS:
                return modbusReader.readInputStatus(reader);
            default:
                return null;
        }
    }

    /**
     * 寄存器读取
     *
     * @param reader       读指令{@linkplain CommandReader}
     * @param modbusReader 指令执行体{@linkplain ModbusReader}
     * @return 执行结果
     * @throws ModbusTransportException 读取异常
     */
    public static short[] commandReadShorts(CommandReader reader, ModbusReader modbusReader) throws ModbusTransportException {
        if (reader == null) {
            return null;
        }
        switch (reader.getModbusProtocol()) {
            //03
            case READ_HOLDING_REGISTERS:
                return modbusReader.readHoldingShort(reader);
            //04
            case READ_INPUT_REGISTERS:
                return modbusReader.readInputShort(reader);
            default:
                return null;
        }
    }
}
