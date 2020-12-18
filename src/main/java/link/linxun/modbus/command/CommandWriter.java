package link.linxun.modbus.command;


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
    private final ModbusProtocol.ModbusProtocolWriter writer;
    private final int offset;
    private final short[] writeData;

    public CommandWriter(int addressId, ModbusProtocol.ModbusProtocolWriter writer, int offset, short... writeData) {
        this.addressId = addressId;
        this.writer = writer;
        this.offset = offset;
        this.writeData = writeData;
    }

    public int getAddressId() {
        return addressId;
    }

    public ModbusProtocol.ModbusProtocolWriter getWriter() {
        return writer;
    }

    public int getOffset() {
        return offset;
    }

    public short[] getWriteData() {
        return writeData;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CommandWriter.class.getSimpleName() + "[", "]")
                .add("addressId=" + addressId)
                .add("writer=" + writer)
                .add("offset=" + offset)
                .add("writeData=" + Arrays.toString(writeData))
                .toString();
    }
}
