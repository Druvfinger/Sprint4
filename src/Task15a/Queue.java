package Task15a;

import java.util.List;

public interface Queue <T> {

    public void put(T t);
    public T take();
    public int size();
    public int sumOfQueue(List<T> list);

}
