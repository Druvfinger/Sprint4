package Task4a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciever {

    public Reciever()throws IOException{

        int port = 44444;
        DatagramSocket ds = new DatagramSocket(port);
        byte[] data = new byte[256];

        while (true){
            DatagramPacket dgp = new DatagramPacket(data,data.length);
            ds.receive(dgp);
            String s = new String(dgp.getData(),0, data.length);
            System.out.println(s);
        }

    }
    public static void main (String[] args)throws IOException {
        Reciever test = new Reciever();
    }
}
