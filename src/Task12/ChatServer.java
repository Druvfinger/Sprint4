package Task12;

import java.io.*;
import java.net.Socket;

public class ChatServer extends Thread {


    Socket s;
    Users user;

    ChatServer(Socket s, Users user) {
        this.s = s;
        this.user = user;
    }

    public void run() {
        try (PrintWriter writeToClient = new PrintWriter(s.getOutputStream(), true); // öppnar upp en kanal som kan skriva till klienten och tömmer strömmen efter
             BufferedReader readFromClient = new BufferedReader(new InputStreamReader(s.getInputStream())); // öppnar upp en kanal
        ) {

            user.addUser(writeToClient);

            String messageIn;

            while (true) {
                messageIn = readFromClient.readLine();
                for (PrintWriter writer : user.getUsers()) {
                    writer.println(messageIn);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
