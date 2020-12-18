package link.linxun.modbus.command;

import link.linxun.modbus.modbus.config.ModbusProtocol;

/**
 * 写线圈
 *
 * @author CaoXun
 * @date 2020/12/18 10:51 星期五
 */
public class CommandWriterCoils {
    /**
     * modbus通信地址
     */
    private final int addressId;
    /**
     * 通信代码
     */
    private final ModbusProtocol.ModbusProtocolWriter writer;
    /**
     * 寄存器起始地址
     */
    private final int offset;
    /**
     * 开关量
     */
    private final boolean[] writeData;

    /**
     * 单个线圈
     *
     * @param addressId modbus地址
     * @param writer    协议
     * @param offset    寄存器地址
     * @param writeData 开关量
     */
    public CommandWriterCoils(int addressId, ModbusProtocol.ModbusProtocolWriter writer, int offset, boolean writeData) {
        this.addressId = addressId;
        this.writer = writer;
        this.offset = offset;
        this.writeData = new boolean[]{writeData};
    }

    /**
     * 批量写线圈
     *
     * @param addressId modbus地址
     * @param writer    协议
     * @param offset    寄存器地址
     * @param writeData 开关量
     */
    public CommandWriterCoils(int addressId, ModbusProtocol.ModbusProtocolWriter writer, int offset, boolean[] writeData) {
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

    public boolean[] getWriteData() {
        return writeData;
    }
}
