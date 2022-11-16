package Task12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerListener {

    int port = 55555;

    private static Users users = new Users();

    public ChatServerListener() {

        try (ServerSocket ss = new ServerSocket(port);) {
            while (true) {

                Socket s = ss.accept();
                ChatServer chatServer = new ChatServer(s, users);
                chatServer.start();
            }
            } catch(IOException e){
                throw new RuntimeException(e);
            }
    }

    public static void main(String[] args) {
        ChatServerListener chatListener = new ChatServerListener();
    }
}
