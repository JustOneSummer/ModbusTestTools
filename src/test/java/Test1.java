import gnu.io.CommPortIdentifier;
import gnu.io.NRSerialPort;
import gnu.io.NoSuchPortException;
import gnu.io.RXTXPort;

/**
 * @author CaoXun
 * @date 2020/12/7 13:50 星期一
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchPortException {
//        NRSerialPort.getAvailableSerialPorts().forEach(System.out::println);
        try {
            NRSerialPort nrSerialPort = new NRSerialPort("COM3");
            RXTXPort serialPortInstance = nrSerialPort.getSerialPortInstance();
            nrSerialPort.connect();

            System.out.println(nrSerialPort.isConnected());
            nrSerialPort.disconnect();
            System.out.println(nrSerialPort.isConnected());
//            nrSerialPort.disconnect();
//            NRSerialPort n2 = new NRSerialPort("COM3");
//            n2.connect();
//            System.out.println(n2.isConnected());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("异常");

        }
    }
}
