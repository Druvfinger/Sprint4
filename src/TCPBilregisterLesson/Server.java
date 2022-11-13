package TCPBilregisterLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Database d = new Database();

    public Server(){
        try(ServerSocket ss = new ServerSocket(55555);
            Socket s = ss.accept();
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ){

            out.println("Välkommen, skriv in regNr: ");
            String clientRequest = "";

            while ((clientRequest = in.readLine())!= null){
                String dbAnswer = d.search(clientRequest.trim());
                out.println(dbAnswer);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
