package Task13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    URL urlToRead;
    public Main() throws MalformedURLException {
        urlToRead = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        URLReader urlReader = new URLReader();
        List<String> unSortedList =  urlReader.getWordListFromURL(urlToRead);
        Sorter sorter = new Sorter();
        List<String> sortedList = sorter.getSortedList(unSortedList);

        for (String element : sortedList){
            System.out.println(element);
        }

    }

    public static void main(String[] args) throws MalformedURLException {
        Main test = new Main();
    }
}
