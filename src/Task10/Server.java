package Task10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    Socket s;
    Protocol p = new Protocol();

    public Server(Socket s){
        this.s = s;
    }

    public void run(){

        try(ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); // ansvarig för att skicka object till klient
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
}
