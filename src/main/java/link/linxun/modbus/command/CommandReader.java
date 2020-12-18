package link.linxun.modbus.command;


import link.linxun.modbus.modbus.config.ModbusProtocol;

import java.util.StringJoiner;

/**
 * 读命令
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class CommandReader {
    /**
     * modbus地址
     */
    private final int addressId;
    /**
     * 协议code
     */
    private final ModbusProtocol.ModbusProtocolRead read;
    /**
     * 寄存器起始地址
     */
    private final int offset;
    /**
     * 读几个寄存器
     */
    private final int numberOfBits;

    public CommandReader(int addressId, ModbusProtocol.ModbusProtocolRead read, int offset, int numberOfBits) {
        this.addressId = addressId;
        this.read = read;
        this.offset = offset;
        this.numberOfBits = numberOfBits;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CommandReader.class.getSimpleName() + "[", "]")
                .add("addressId=" + addressId)
                .add("read=" + read)
                .add("offset=" + offset)
                .add("numberOfBits=" + numberOfBits)
                .toString();
    }

    public int getAddressId() {
        return addressId;
    }

    public ModbusProtocol.ModbusProtocolRead getRead() {
        return read;
    }

    public int getOffset() {
        return offset;
    }

    public int getNumberOfBits() {
        return numberOfBits;
    }
}
