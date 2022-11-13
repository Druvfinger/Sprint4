package Task5a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PhonebookClient {

    public PhonebookClient(){
        try(Socket s = new Socket("127.0.0.1", 55555);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ){

            String fromUser = "";
            String fromServer = "";

            fromServer = in.readLine();
            System.out.println(fromServer);

            while ((fromUser = input.readLine()) != null){

                out.println(fromUser);

                fromServer = in.readLine();
                System.out.println(fromServer);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        PhonebookClient pc = new PhonebookClient();
    }
}
