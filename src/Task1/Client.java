package Task1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public Client(){
        try (Socket socket = new Socket("127.0.0.1", 44444);
             PrintWriter writerOut = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()),true)
        ){

            String message = "Test";

            while (true){
                writerOut.println(message);
                Thread.sleep(5000);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
