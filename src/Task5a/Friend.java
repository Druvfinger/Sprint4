package Task5a;

public class Friend {

    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String birthDay;

    public Friend(String name, String address, String phoneNumber, String birthDay) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
