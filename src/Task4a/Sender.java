package Task4a;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

    public Sender()throws IOException {
        String city = "";
        String temperature = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vilken stad:");
        city = scanner.next();
        System.out.println("vad är temperaturen");

        int toPort = 44444;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket ds = new DatagramSocket();

        while(scanner.hasNext()){

            temperature = scanner.next();
            String message = city + "," + temperature;
            byte[] data = message.getBytes();
            DatagramPacket dgp = new DatagramPacket(data, data.length,ip,toPort);
            ds.send(dgp);
        }


    }

    public static void main(String[] args)throws IOException{
        Sender test = new Sender();
    }
}
