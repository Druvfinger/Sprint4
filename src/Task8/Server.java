package Task8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Protocol p = new Protocol();
    public Server(){

        try(ServerSocket ss = new ServerSocket(55555); // Serversocket för var den ska ta emot
            Socket s = ss.accept(); // ser till att serversocket accepterar vad som skickas
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); // ansvarig för att skicka object till klient
            ObjectInputStream in = new ObjectInputStream(s.getInputStream()) // läser in user Input
        ){

            Friend objectToSend;
            Object clientInput;

            out.writeObject(new Intro());

            while((clientInput = in.readObject()) != null){ // väntar på att vi ska få en input från klienten och sätter den inputen i variablen clientInput
             out.writeObject(p.processInput((String) clientInput));

            }



        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
