package link.linxun.modbus.modbus.config;

/**
 * modbus通信协议
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public enum ModbusProtocol {
    /**
     * 0x01
     */
    READ_COILS("0x01", "READ"),
    /**
     * 0x02
     */
    READ_DISCRETE_INPUTS("0x02", "READ"),
    /**
     * 0x03
     */
    READ_HOLDING_REGISTERS("0x03", "READ"),
    /**
     * 0x04
     */
    READ_INPUT_REGISTERS("0x04", "READ"),
    /**
     * 0x05
     */
    WRITE_SINGLE_COIL("0x05", "WRITE"),
    /**
     * 0x06
     */
    WRITE_SINGLE_REGISTER("0x06", "WRITE"),
    /**
     * 0x07
     */
    READ_EXCEPTION_STATUS("0x07", "READ"),
    /**
     * 0x08
     */
    DIAGNOSTICS("0x08", "DIAGNOSTICS"),
    /**
     * 0x0B
     */
    GET_COMM_EVENT_COUNTER("0x0B", "GET"),
    /**
     * 0x0C
     */
    GET_COMM_EVENT_LOG("0x0C", "GET"),
    /**
     * 0x0F
     */
    WRITE_MULTIPLE_COILS("0x0F", "WRITE"),
    /**
     * 0x10
     */
    WRITE_MULTIPLE_REGISTERS("0x10", "WRITE"),
    /**
     * 0x11
     */
    REPORT_SERVER_ID("0x11", "REPORT"),
    /**
     * 0x14
     */
    READ_FILE_RECORD("0x14", "READ"),
    /**
     * 0x15
     */
    WRITE_FILE_RECORD("0x15", "WRITE"),
    /**
     * 0x16
     */
    MASK_WRITE_REGISTER("0x16", "WRITE"),
    /**
     * 0x17
     */
    READ_OR_WRITE_MULTIPLE_REGISTERS("0x17", "READ/WRITE"),
    /**
     * 0x18
     */
    READ_FIFO_QUEUE("0x18", "READ");

    private final String code;
    private final String type;

    ModbusProtocol(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
