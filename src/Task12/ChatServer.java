package Task12;

import java.io.*;
import java.net.Socket;

public class ChatServer extends Thread {


    Socket s;

    ChatServer(Socket s) {
        this.s = s;
    }

    public void run() {
        try (PrintWriter writeToClient = new PrintWriter(s.getOutputStream(), true); // öppnar upp en kanal som kan skriva till klienten och tömmer strömmen efter
             BufferedReader readFromClient = new BufferedReader(new InputStreamReader(s.getInputStream())); // öppnar upp en kanal
        ) {

            String messageIn;
            String messageOut;
            String username;

            writeToClient.println("Welcome to the chatroom!");

            writeToClient.println("What would you like your username to be?");

            username = readFromClient.readLine();
            Users user = new Users(username);
            writeToClient.println("Server: your username is " + user.getUsername() + " feel free to chat");

            while ((messageIn = readFromClient.readLine()) != null){
                messageOut = user.getUsername() +": " + messageIn;
                writeToClient.println(messageOut);
                if (messageIn.equals("EXIT")){
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
