package Task10;

import java.io.Serializable;

public class Friend implements Serializable {

    protected String name;
    protected String number;
    protected String email;
    protected String birthday;

    public Friend(String name, String number, String email, String birthday) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
