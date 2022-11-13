package Task6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    DAO d = new DAO();

    public Server(){
        try(ServerSocket ss = new ServerSocket(55555);
            Socket s = ss.accept();
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //behöver inte en reader då vi bara skriver det i klient sidan
        ){

            out.writeObject("Welcome,write name to check if it is in phonebook");
            String temp = "";

            while((temp = in.readLine()) != null){
                for(Friend f : d.friendList){
                    Friend DAOresponse = d.getFriendInfo(temp.trim());
                    if (DAOresponse == null){
                        out.writeObject("No such friend in phonebook");
                    }
                    out.writeObject(DAOresponse);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
