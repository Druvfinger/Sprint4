package Task12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
             PrintWriter writeToServer = new PrintWriter(s.getOutputStream(), true); //öppnar upp en kanal för att skriva till server
             BufferedReader readFromServer = new BufferedReader(new InputStreamReader(s.getInputStream())); // öppnar en kanal för att läsa från server
             BufferedReader readUserInput = new BufferedReader(new InputStreamReader(System.in)); // läser in user input

        ) {
            String fromServer = "";  // Variabel som ska innehålla vad som läses in från server
            String fromClient = ""; //  Variabel som ska inehålla vad clienten vill skicka till servern
            String username = "";  //   Variabel som håller användarens namn

            System.out.println("Welcome to the chatroom!");

            System.out.println("what would you like your username to be?");
            System.out.print(">");
            username = readUserInput.readLine();
            System.out.print(">");


            while ((fromClient = readUserInput.readLine()) != null) {
                writeToServer.println(username + ": " + fromClient);
                if ((fromServer = readFromServer.readLine()) != null) {
                    System.out.println(fromServer);
                    System.out.print(">");
                }
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
