package link.linxun.modbus.command;


import link.linxun.modbus.commons.NumberUtils;
import link.linxun.modbus.modbus.config.ModbusProtocol;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 写命令
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class CommandWriter {
    /**
     * modbus通信地址
     */
    private final int addressId;
    /**
     * 通信代码
     */
    private final ModbusProtocol modbusProtocol;
    private final int offset;
    private final short[] writeData;
    private final boolean[] writeValue;

    public CommandWriter(int addressId, ModbusProtocol modbusProtocol, int offset, short... writeData) {
        this.addressId = addressId;
        this.modbusProtocol = modbusProtocol;
        this.offset = offset;
        this.writeData = writeData;
        this.writeValue = null;
    }

    public CommandWriter(int addressId, ModbusProtocol modbusProtocol, int offset, boolean... writeData) {
        this.addressId = addressId;
        this.modbusProtocol = modbusProtocol;
        this.offset = offset;
        this.writeData = null;
        this.writeValue = writeData;
    }

    public int getAddressId() {
        return addressId;
    }

    public ModbusProtocol getModbusProtocol() {
        return modbusProtocol;
    }

    public int getOffset() {
        return offset;
    }

    public short[] getWriteData() {
        return writeData;
    }

    public int getWriteDataInt() {
        return NumberUtils.shortArrayToInt(writeData);
    }

    public boolean[] getWriteValue() {
        return writeValue;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CommandWriter.class.getSimpleName() + "[", "]")
                .add("addressId=" + addressId)
                .add("modbusProtocol=" + modbusProtocol)
                .add("offset=" + offset)
                .add("writeData=" + Arrays.toString(writeData))
                .add("writeValue=" + Arrays.toString(writeValue))
                .toString();
    }
}
