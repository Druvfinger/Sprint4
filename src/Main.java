import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());

        InetAddress ip2= InetAddress.getByName("192.168.0.176");
        System.out.println(ip2);

        InetAddress ip3= InetAddress.getLoopbackAddress();
        System.out.println(ip3);
    }
}