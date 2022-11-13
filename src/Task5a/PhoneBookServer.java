package Task5a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PhoneBookServer {

    DAO d = new DAO();
    public PhoneBookServer(){

        try(ServerSocket ss = new ServerSocket(55555);
            Socket s = ss.accept();
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ){

            out.println("Write a name to see if it is the phonebook: ");
            String temp = "";

            while ((temp = in.readLine()) != null){
                String response = d.getFriend(temp.trim());
                out.println(response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        PhoneBookServer ps = new PhoneBookServer();
    }
}
