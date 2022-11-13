package Task6;

import java.io.*;
import java.net.Socket;

public class Client {

    public Client(){

        try(Socket s = new Socket("127.0.0.1", 55555);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ){

            Object fromServer = "";
            String fromUser = "";

            fromServer = in.readObject();
            System.out.println(fromServer);

            while((fromUser = userInput.readLine())!= null){ // väntar på användare ska skriva nåt

                out.println(fromUser); // skriver vad användaren har skrivit till server

                fromServer = in.readObject(); // hämtar vad server
                if (fromServer instanceof Friend){
                    Friend f = (Friend) fromServer;
                    System.out.println(f.address + " " + f.Name + " " + f.email + " " + f.birthday);
                } else if (fromServer instanceof String) {
                    System.out.println(fromServer);
                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
