package TCPBilregisterProtokollLesson;

public class Bil {

    protected  String regNr;
    protected  String owner;
    protected  String brand;
    protected  String color;

    public Bil(String regNr, String owner, String brand, String color) {
        this.regNr = regNr;
        this.owner = owner;
        this.brand = brand;
        this.color = color;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
