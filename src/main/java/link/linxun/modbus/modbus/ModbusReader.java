package link.linxun.modbus.modbus;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.*;
import link.linxun.modbus.command.CommandReader;

/**
 * 读取数据
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ModbusReader {
    private final ModbusMaster modbusMaster;

    public ModbusReader(ModbusMaster modbusMaster) {
        this.modbusMaster = modbusMaster;
    }

    /**
     * 线圈读取 开关量数据 0x01
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 开关数据
     * @throws ModbusTransportException m
     */
    public boolean[] readCoilStatus(CommandReader reader) throws ModbusTransportException {
        return this.readCoilStatus(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 开关数据 读取外围设备输入的开关量 0x02
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 开关状态
     * @throws ModbusTransportException m
     */
    public boolean[] readInputStatus(CommandReader reader) throws ModbusTransportException {
        return this.readInputStatus(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 读取外围设备输入的数据 0x04
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public byte[] readInputByte(CommandReader reader) throws ModbusTransportException {
        return this.readInputByte(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 读取外围设备输入的数据 0x04
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public short[] readInputShort(CommandReader reader) throws ModbusTransportException {
        return this.readInputShort(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 读取外围设备输入的数据 0x04
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public byte[] readInputByte(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        return this.readInputRegister(addressId, offset, numberOfBits).getData();
    }

    /**
     * 读取外围设备输入的数据 0x04
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public short[] readInputShort(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        return this.readInputRegister(addressId, offset, numberOfBits).getShortData();
    }

    /**
     * 读取外围设备输入的数据 0x03
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public byte[] readHoldingByte(CommandReader reader) throws ModbusTransportException {
        return this.readHoldingByte(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 读取外围设备输入的数据 0x03
     *
     * @param reader 指令体{@linkplain CommandReader}
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    public short[] readHoldingShort(CommandReader reader) throws ModbusTransportException {
        return this.readHoldingShort(reader.getAddressId(), reader.getOffset(), reader.getNumberOfBits());
    }

    /**
     * 读取保持寄存器数据 0x03
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 十进制数值
     * @throws ModbusTransportException m
     */
    public byte[] readHoldingByte(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        return this.readHoldingRegister(addressId, offset, numberOfBits).getData();
    }

    /**
     * 读取保持寄存器数据 0x03
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 十进制数值
     * @throws ModbusTransportException m
     */
    public short[] readHoldingShort(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        return this.readHoldingRegister(addressId, offset, numberOfBits).getShortData();
    }

    /**
     * 线圈读取 开关量数据 0x01
     *
     * @param addressId    地区id
     * @param offset       起始位
     * @param numberOfBits 寄存器长度
     * @return 开关数据
     * @throws ModbusTransportException m
     */
    public boolean[] readCoilStatus(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        ReadCoilsRequest request = new ReadCoilsRequest(addressId, offset, numberOfBits);
        ReadCoilsResponse response = (ReadCoilsResponse) modbusMaster.send(request);
        boolean[] booleans = response.getBooleanData();
        return valueRegroup(numberOfBits, booleans);
    }

    /**
     * 开关数据 读取外围设备输入的开关量 0x02
     *
     * @param addressId    设备地址
     * @param offset       起始位
     * @param numberOfBits 寄存器长度
     * @return 开关状态
     */
    public boolean[] readInputStatus(int addressId, int offset, int numberOfBits) throws ModbusTransportException {
        ReadDiscreteInputsRequest request = new ReadDiscreteInputsRequest(addressId, offset, numberOfBits);
        ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) modbusMaster.send(request);
        boolean[] booleans = response.getBooleanData();
        return valueRegroup(numberOfBits, booleans);
    }

    /**
     * 读取保持寄存器数据 0x03
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 十进制数值
     * @throws ModbusTransportException m
     */
    private ReadHoldingRegistersResponse readHoldingRegister(int addressId, int offset, int numberOfBits)
            throws ModbusTransportException {
        ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(addressId, offset, numberOfBits);
        return (ReadHoldingRegistersResponse) modbusMaster.send(request);
    }


    /**
     * 读取外围设备输入的数据 0x04
     *
     * @param addressId    地址id
     * @param offset       位置
     * @param numberOfBits numberOfBits
     * @return 设备数据
     * @throws ModbusTransportException m
     */
    private ReadInputRegistersResponse readInputRegister(int addressId, int offset, int numberOfBits)
            throws ModbusTransportException {
        ReadInputRegistersRequest request = new ReadInputRegistersRequest(addressId, offset, numberOfBits);
        return (ReadInputRegistersResponse) modbusMaster.send(request);
    }

    private boolean[] valueRegroup(int numberOfBits, boolean[] values) {
        boolean[] bs = new boolean[numberOfBits];
        int temp = 1;
        for (boolean b : values) {
            bs[temp - 1] = b;
            temp++;
            if (temp > numberOfBits) {
                break;
            }
        }
        return bs;
    }
}
