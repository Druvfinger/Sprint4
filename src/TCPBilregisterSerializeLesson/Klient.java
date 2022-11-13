package TCPBilregisterSerializeLesson;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Klient {

    public Klient()  {

        try(Socket s = new Socket("127.0.0.1",55555);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            ObjectInputStream in = new ObjectInputStream((s.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ){
            Object fromServer = "";
            String fromUser = "";

            fromServer = in.readObject(); // Läser in hej och välkommen
            System.out.println(fromServer);

            while ((fromUser = userInput.readLine())!= null){ // väntar på användare ska skriva nåt

                out.println(fromUser); // skriver det till server
                //System.out.println("Sent to server: " + fromUser);

                fromServer = in.readObject();

                if (fromServer instanceof Bil){ // om typ är bil skriver ut objektet
                    Bil b = (Bil) fromServer;
                    System.out.println(b.getOwner() + " " + b.getBrand() + " " + b.getColor() + " "+ b.getRegNr());
                } else if (fromServer instanceof  String) { // om sträng skriver ut sträng rakt av
                    System.out.println(fromServer);
                }
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        Klient k = new Klient();
    }
}
