package Task3;

import Task4a.Reciever;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class Receiver extends Thread{
    MulticastSocket ms;
    JTextArea text;

    public Receiver(MulticastSocket ms, JTextArea text){
        this.ms = ms;
        this.text = text;

    }


    @Override
    public void run(){

        while (true){
            byte[] data = new byte[256];
            DatagramPacket dgp = new DatagramPacket(data, data.length);
            try {
                ms.receive(dgp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String mess = new String(dgp.getData(),0, dgp.getLength());
            text.append(mess);
        }

    }
}
