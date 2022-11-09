package Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class Task3 extends JFrame implements ActionListener {

    JPanel bottom = new JPanel();
    JTextArea text = new JTextArea("HEJ",20,50);
    JTextField input = new JTextField(50);

    InetAddress inetAddress;
    int port;

    MulticastSocket socket;

    public Task3() throws IOException {

        inetAddress = InetAddress.getByName("235.235.235.235");
        port = 33333;
        InetSocketAddress group = new InetSocketAddress(inetAddress, port);
        NetworkInterface netIf = NetworkInterface.getByName("eth1");
        socket = new MulticastSocket(port);
        socket.joinGroup(group, netIf);

        add(bottom);
        bottom.setLayout(new BorderLayout());
        bottom.add(text, BorderLayout.NORTH);
        bottom.add(input, BorderLayout.SOUTH);
        input.addActionListener(this);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Receiver receiver = new Receiver(socket, text);
        receiver.start();


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String mess = input.getText().trim() +"\n";
        byte[] data = mess.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length,inetAddress,port);
        try {
            socket.send(packet);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException{
        Task3 test = new Task3();
    }


}
