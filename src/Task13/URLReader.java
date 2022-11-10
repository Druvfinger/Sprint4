package Task13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLReader {

    public List<String> getWordListFromURL(URL url) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));

            List<String> wordList = new ArrayList<>();
            String temp;

            while ((temp = buf.readLine()) != null) {
                wordList.add(temp);
            }
            return wordList;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
