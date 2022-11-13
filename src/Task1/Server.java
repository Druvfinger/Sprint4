package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(){

        try (ServerSocket serverSocket = new ServerSocket(44444);
             Socket regularSocket = serverSocket.accept();
             BufferedReader buf = new BufferedReader(new InputStreamReader(regularSocket.getInputStream()));
        ){
            String temp = "";

            while((temp = buf.readLine()) != null){
                System.out.println(temp);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
