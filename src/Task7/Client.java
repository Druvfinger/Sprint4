package Task7;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public Client(){

        try(Socket s = new Socket("127.0.0.1", 55555); // öppnar en socket vilket är hur vi skickar och tar emot datan
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); // skapar en stream där vi kan skicka data via socket till servern
            ObjectInputStream in = new ObjectInputStream(s.getInputStream()); // skapar en ström där vi kan ta in datan från socket till klientprogrammet
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // öppnar en ström där vi tar in vad användaren skriver
        ){

            String fromUser = "";
            Object fromServer;

            while((fromServer = in.readObject()) != null){ //väntar på att vi ska ta emot data från servern
                
                if (fromServer instanceof Intro){ // om det objektet som servern skickar tillbaks är Intro så skriv ut object
                    System.out.println("Connection Established"); // skriv ut detta
                } else if (fromServer instanceof Response) { // Om objektet skickat från server är av typen response
                    if (!((Response) fromServer).isSuccess()){ // Om det inte är en match med namnet
                        System.out.println("Person not in phonebook"); // skriv ut detta
                    }else {
                        System.out.println(((Response) fromServer).getPerson().getName()); //om inga tidigare stämmer så skriv ut detta
                    }
                }
                System.out.println("Write name to see if in phonebook: "); // skriv ut fråga om att skriva in namn
                fromUser = userInput.readLine();
                if (fromUser != null){ // så länge du skriver in någon ting
                    out.writeObject(fromUser); // skriver vi det till servern
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

    public static void main(String[] args) {
        Client c = new Client();
    }
}
