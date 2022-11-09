package Task4b;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class MulticastSender extends JFrame {

    JPanel backPanel = new JPanel();

    public MulticastSender() throws IOException {
        String city = "";
        String temperature = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vilken stad:");
        city = scanner.next();
        System.out.println("vad är temperaturen");

        int toPort = 44444;
        String ip = "234.235.236.237";
        InetAddress iadr = InetAddress.getByName(ip);
        MulticastSocket socket = new MulticastSocket();
        InetSocketAddress group = new InetSocketAddress(iadr,toPort);
        NetworkInterface netIf = NetworkInterface.getByName("eth1");

        while(scanner.hasNext()){

            temperature = scanner.next();
            String message = city + "," + temperature;
            byte[] data = message.getBytes();
            DatagramPacket dgp = new DatagramPacket(data, data.length,iadr,toPort);
            socket.send(dgp);
        }


    }

    public static void main(String[] args)throws IOException{
        MulticastSender test = new MulticastSender();
    }
}
