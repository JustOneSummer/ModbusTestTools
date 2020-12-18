package link.linxun.modbus.modbus;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.msg.*;
import link.linxun.modbus.command.CommandWriter;
import link.linxun.modbus.command.CommandWriterCoils;

/**
 * 写入类
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ModbusWriter {
    private final ModbusMaster modbusMaster;

    public ModbusWriter(ModbusMaster modbusMaster) {
        this.modbusMaster = modbusMaster;
    }

    /**
     * 写单个（线圈）开关量数据 0x05
     *
     * @param commandWriter 指令体
     * @return 是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeCoil(CommandWriterCoils commandWriter) throws ModbusTransportException {
        return this.writeCoil(commandWriter.getAddressId(), commandWriter.getOffset(), commandWriter.getWriteData()[0]);
    }

    /**
     * 写单个（线圈）开关量数据 0x05
     *
     * @param addressId   地址id
     * @param writeOffset 位置
     * @param writeValue  值
     * @return 是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeCoil(int addressId, int writeOffset, boolean writeValue)
            throws ModbusTransportException {
        // 创建请求
        WriteCoilRequest request = new WriteCoilRequest(addressId, writeOffset, writeValue);
        // 发送请求并获取响应对象
        WriteCoilResponse response = (WriteCoilResponse) modbusMaster.send(request);
        return !response.isException();
    }

    /**
     * 写多个开关量数据（线圈） 0x0F
     *
     * @param commandWriter 指令体
     * @return 是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeCoils(CommandWriterCoils commandWriter) throws ModbusTransportException {
        return this.writeCoils(commandWriter.getAddressId(), commandWriter.getOffset(), commandWriter.getWriteData());
    }

    /**
     * 写多个开关量数据（线圈） 0x0F
     *
     * @param addressId   地址id
     * @param startOffset 开始位置
     * @param data        写入的数据
     * @return 是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeCoils(int addressId, int startOffset, boolean[] data)
            throws ModbusTransportException {
        // 创建请求
        WriteCoilsRequest request = new WriteCoilsRequest(addressId, startOffset, data);
        // 发送请求并获取响应对象
        WriteCoilsResponse response = (WriteCoilsResponse) modbusMaster.send(request);
        return !response.isException();

    }

    /**
     * 保持寄存器写单个 0x06
     *
     * @param commandWriter 指令体
     * @throws ModbusTransportException m
     */
    public boolean writeRegister(CommandWriter commandWriter) throws ModbusTransportException {
        return this.writeRegister(commandWriter.getAddressId(), commandWriter.getOffset(), commandWriter.getWriteData()[0]);
    }

    /**
     * 保持寄存器写单个 0x06
     *
     * @param addressId   地址id
     * @param writeOffset 开始位置
     * @param writeValue  写入的数据
     * @throws ModbusTransportException m
     */
    public boolean writeRegister(int addressId, int writeOffset, int writeValue)
            throws ModbusTransportException {
        // 创建请求对象
        WriteRegisterRequest request = new WriteRegisterRequest(addressId, writeOffset, writeValue);
        // 发送请求并获取响应对象
        WriteRegisterResponse response = (WriteRegisterResponse) modbusMaster.send(request);
        return !response.isException();

    }

    /**
     * 保持寄存器写入多个模拟量数据 0x10
     *
     * @param commandWriter 指令体
     * @return 返回是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeRegisters(CommandWriter commandWriter) throws ModbusTransportException {
        return this.writeRegisters(commandWriter.getAddressId(), commandWriter.getOffset(), commandWriter.getWriteData());
    }

    /**
     * 保持寄存器写入多个模拟量数据 0x10
     *
     * @param addressId   地址id
     * @param startOffset 起始位置偏移量值
     * @param data        写入的数据
     * @return 返回是否写入成功
     * @throws ModbusTransportException m
     */
    public boolean writeRegisters(int addressId, int startOffset, short[] data)
            throws ModbusTransportException {
        // 创建请求对象
        WriteRegistersRequest request = new WriteRegistersRequest(addressId, startOffset, data);
        // 发送请求并获取响应对象
        WriteRegistersResponse response = (WriteRegistersResponse) modbusMaster.send(request);
        return !response.isException();
    }

    /**
     * 根据类型写数据（如:写入Float类型的模拟量、Double类型模拟量、整数类型Short、Integer、Long） 0x03
     *
     * @param addressId 地址id
     * @param offset    位置
     * @param value     写入值
     * @param dataType  类型定义在 {@linkplain com.serotonin.modbus4j.code.DataType}类中
     * @throws ModbusTransportException m
     */
    public void writeHoldingRegister(int addressId, int offset, Number value, int dataType) throws ErrorResponseException, ModbusTransportException {
        // 类型
        BaseLocator<Number> locator = BaseLocator.holdingRegister(addressId, offset, dataType);
        modbusMaster.setValue(locator, value);
    }
}
