package link.linxun.modbus.modbus;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import link.linxun.modbus.config.SerialPortConfig;
import link.linxun.modbus.modbus.wrapper.SerialPortNrWrapperImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

    private static ConcurrentMap<String, SerialPortNrWrapperImpl> map = new ConcurrentHashMap<>(16);


    /**
     * 初始化主站
     *
     * @param configDO 配置信息
     * @return 主站
     * @throws ModbusInitException 初始化失败
     */
    public static ModbusMaster getMaster(SerialPortConfig configDO) throws ModbusInitException {
        SerialPortNrWrapperImpl p = new SerialPortNrWrapperImpl(configDO);
        map.put(configDO.getPortName(), p);
        ModbusMaster master = modbusFactory.createRtuMaster(p);
        master.init();
        return master;
    }

    /**
     * 关闭串口
     *
     * @param portName 关闭
     */
    public static void close(String portName) {
        SerialPortNrWrapperImpl serialPortNrWrapper = map.get(portName);
        if (serialPortNrWrapper != null) {
            serialPortNrWrapper.close();
            map.remove(portName);
        }
    }
}
