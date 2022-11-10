package Task13;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sorter {

    URL urlToRead;

    public List<String> getSortedList(List<String> list) {


                List<String> myList = list;

                int wordCounter = 0;
                int wordLength = 0;
                int lenghtOf1 = 0;
                int lenghtOf2 = 0;
                int lenghtOf3 = 0;
                int lenghtOf4 = 0;
                int lenghtOf5 = 0;
                int lenghtOf6 = 0;
                int lenghtOf7 = 0;
                int lenghtOf8 = 0;
                int lenghtOf9 = 0;
                int lenghtOf10 = 0;
                int otherLenght = 0;


                for (String element : myList) {
                    wordCounter++;
                    wordLength = element.length();
                    if (wordLength == 1) {
                        lenghtOf1++;
                    } else if (wordLength == 2) {
                        lenghtOf2++;
                    } else if (wordLength == 3) {
                        lenghtOf3++;
                    } else if (wordLength == 4) {
                        lenghtOf4++;
                    } else if (wordLength == 5) {
                        lenghtOf5++;
                    } else if (wordLength == 6) {
                        lenghtOf6++;
                    } else if (wordLength == 7) {
                        lenghtOf7++;
                    } else if (wordLength == 8) {
                        lenghtOf8++;
                    } else if (wordLength == 9) {
                        lenghtOf9++;
                    } else if (wordLength == 10) {
                        lenghtOf10++;
                    }else {
                        otherLenght++;
                    }
                }
                List<String> wordLengthList = List.of( "words with 1 letter: " + lenghtOf1,
                        "words with 2 letters: " + lenghtOf2,
                        "words with 3 letters: " +lenghtOf3,
                        "words with 4 letters: " +lenghtOf4,
                        "words with 5 letters: " +lenghtOf5,
                        "words with 6 letters: " +lenghtOf6,
                        "words with 7 letters: " +lenghtOf7,
                        "words with 8 letters: " +lenghtOf8,
                        "words with 9 letters: " +lenghtOf9,
                        "words with 10 letters: " +lenghtOf10,
                        "words with more then 10 letters:  " + otherLenght,
                        "Amount of words: " + wordCounter);


                return wordLengthList;
    }
}
