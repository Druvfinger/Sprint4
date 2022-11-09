package Task2a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuoteSender {
    String quote1 = "1";
    String quote2 = "2";
    String quote3 = "3";
    String quote4 = "4";
    String quote5 = "5";

    int listCounter = 0;

    List<String> quotes = Arrays.asList(quote1,quote2,quote3,quote4,quote5);

    public QuoteSender() throws IOException, InterruptedException {


        InetAddress ip = InetAddress.getLocalHost();
        int toPort = 44444;
        DatagramSocket ds = new DatagramSocket();



        while(true) {
            byte[] data = quotes.get(listCounter).getBytes();
            DatagramPacket dgp = new DatagramPacket(data, data.length,ip,toPort);
            ds.send(dgp);
            listCounter = (listCounter +1) % 5;
            Thread.sleep(3000);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        QuoteSender qs = new QuoteSender();
    }
}
