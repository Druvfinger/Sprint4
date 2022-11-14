package Task7;
import java.io.Serializable;
import java.util.List;

public class DAO  implements Serializable {
    Friend f1 = new Friend("friend1", "road1", "940427", "email1@email.com");
    Friend f2 = new Friend("friend2", "road2", "940426", "email2@email.com");
    Friend f3 = new Friend("friend3", "road3", "940425", "email3@email.com");
    Friend f4 = new Friend("friend4", "road4", "940424", "email4@email.com");
    Friend f5 = new Friend("friend5", "road5", "940423", "email5@email.com");

    List<Friend> friendList = List.of(f1, f2, f3, f4, f5);


    public Friend getFriendInfo(String name) {
        for (Friend element : friendList) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }
    public Friend checkForName(String name){
        for (Friend f : friendList){
            if (f.getName().equalsIgnoreCase(name)){
                return f;
            }
        }
        return null;
    }
}
