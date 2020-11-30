package link.linxun.modbus.modbus;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import link.linxun.modbus.config.SerialPortConfig;
import link.linxun.modbus.modbus.wrapper.SerialPortNrWrapperImpl;

/**
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ModbusRtuUtils {

    /**
     * 工厂模式
     */
    static ModbusFactory modbusFactory;

    static {
        modbusFactory = new ModbusFactory();
    }


    /**
     * 初始化主站
     *
     * @param configDO 配置信息
     * @return 主站
     * @throws ModbusInitException 初始化失败
     */
    public static ModbusMaster getMaster(SerialPortConfig configDO) throws ModbusInitException {
        ModbusMaster master = modbusFactory.createRtuMaster(new SerialPortNrWrapperImpl(configDO));
        master.init();
        return master;
    }
}
