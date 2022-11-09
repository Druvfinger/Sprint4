package UrlLEsson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLDemo {

    public URLDemo() throws IOException {

        URL url = new URL("https://studentportal.nackademin.se");

        BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));
        String temp;

        while ((temp = buf.readLine()) != null){
            System.out.println(temp);
        }
    }

    public static void main(String[] args) throws IOException{
        URLDemo test = new URLDemo();
    }
}
