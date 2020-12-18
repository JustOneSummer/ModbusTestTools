package link.linxun.modbus.modbus.config;

/**
 * modbus通信协议
 *
 * @author Linxun
 * @date 2020/11/30 13:53 星期一
 */
public class ModbusProtocol {

    public enum ModbusProtocolRead {
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
        READ_INPUT_REGISTERS("0x04", "READ");
        private final String code;
        private final String type;

        ModbusProtocolRead(String code, String type) {
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

    public enum ModbusProtocolWriter {
        /**
         * 0x05
         */
        WRITE_SINGLE_COIL("0x05", "WRITE"),

        /**
         * 0x06
         */
        WRITE_SINGLE_REGISTER("0x06", "WRITE"),


        /**
         * 0x0F
         */
        WRITE_MULTIPLE_COILS("0x0F", "WRITE"),

        /**
         * 0x10
         */
        WRITE_MULTIPLE_REGISTERS("0x10", "WRITE");
        private final String code;
        private final String type;

        ModbusProtocolWriter(String code, String type) {
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
}
