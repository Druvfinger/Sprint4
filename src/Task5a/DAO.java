package Task5a;

import java.util.List;

public class DAO {

    Friend f1 = new Friend("Friend1", "Adress1", "0123456789","940427");
    Friend f2 = new Friend("Friend2", "Adress2", "012345678","940426");
    Friend f3 = new Friend("Friend3", "Adress3", "01234567","940425");
    Friend f4 = new Friend("Friend4", "Adress4", "0123456","940424");
    Friend f5 = new Friend("Friend5", "Adress5", "012345","940423");

    List<Friend> friendList = List.of(f1,f2,f3,f4,f5);

        public String getFriend (String name){
            for (Friend f : friendList) {
                if (f.getName().equalsIgnoreCase(name)) {
                    return getFriendInfo(f);
                }
            }
            return "Person is not in phonebook";
        }
        public String getFriendInfo (Friend f){
            return f.name + " " + f.address + " " + f.birthDay + " " + f.phoneNumber;
        }
}

