package Task6;

import java.io.Serializable;

public class Friend implements Serializable {

    protected String Name;
    protected String address;
    protected String birthday;
    protected String email;

    public Friend(String name, String address, String birthday, String email) {
        Name = name;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
