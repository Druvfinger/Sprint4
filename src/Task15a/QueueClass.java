package Task15a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueueClass <T extends Number > implements Queue<T> {


    List<T> myList = new ArrayList<>();
    T temp;


    public void put(T t) {
        myList.add(t);
    }

    public T take() {
        T t = myList.get(0);
        myList.remove(0);
        return t;
    }

    public int size() {
        return myList.size();
    }

    public int sumOfQueue(List<T> list) {
        int sum = 0;
        for (T element : list) {
            sum += element.intValue();
        }
        return sum;
    }



    public int intValue() {
        return 0;
    }


    public long longValue() {
        return 0;
    }


    public float floatValue() {
        return 0;
    }


    public double doubleValue() {
        return 0;
    }
}
