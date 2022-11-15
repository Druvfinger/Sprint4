package Task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    String host = "127.0.0.1"; // deklarerar host adress
    int port = 55555; // deklarerar port

    public ChatClient() {
        try (Socket s = new Socket(host, port); // öppnar upp en socket där informationen läses igenom
             PrintWriter writeToServer = new PrintWriter(s.getOutputStream(),true); //öppnar upp en kanal för att skriva till server
             BufferedReader readFromServer = new BufferedReader(new InputStreamReader(s.getInputStream())); // öppnar en kanal för att läsa från server
             BufferedReader readUserInput = new BufferedReader(new InputStreamReader(System.in)); // läser in user input

        ) {
            String fromServer = "";  // Variabel som ska innehålla vad som läses in från server
            String fromClient = ""; //  Variabel som ska inehålla vad clienten vill skicka till servern
            String username = "";  //   Variabel som håller användarens namn

            fromServer = readFromServer.readLine(); // läser in det servern skickar först (bör vara: "Welcome to the chatroom!")
            System.out.println(fromServer); //Skriver ut vad vi läst in från servern till klient

            fromServer = readFromServer.readLine(); // läser in nästa grej servern skriver (bör vara: "What would you like your username to be?\n")
            System.out.println(fromServer); // Skriver ut vad vi läst in från servern till klient
            fromClient = readUserInput.readLine();
            writeToServer.println(fromClient);

            fromServer = readFromServer.readLine(); // läser in nästa grej servern skriver (bör vara: "feel free to chat")
            System.out.println(fromServer);  // Skriver ut vad vi läst in från servern till klient

            while ((fromClient = readUserInput.readLine()) != null){ // väntar på att användare ska skriva in nåt
                writeToServer.println(fromClient); // skriver till användarnamn samt vad som skrevs in
                System.out.println(readFromServer.readLine());
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
    }
}
