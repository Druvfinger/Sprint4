package TCPBilregisterProtokollLesson;

import java.util.List;

public class Database {

    Bil b1 = new Bil("asd123","gubbe1","Ford", "Silver");
    Bil b2 = new Bil("wer345","gubbe2","Saab", "röd");
    Bil b3 = new Bil("rty567","gubbe3","Fiat", "blå");
    Bil b4 = new Bil("cvb890","gubbe4","Volvo", "guld");
    Bil b5 = new Bil("fgh556","gubbe5","Toyota", "vit");

    List<Bil> data = List.of(b1,b2,b3,b4,b5);

    public Database(){

    }
    public  String search(String regnr){
        for(Bil b : data){
            if (b.getRegNr().equals(regnr)){

                return allData(b);
            }
        }
        return "Denna bil finns inte i registret";
    }
    public String allData(Bil b){
        return b.regNr +" " + b.brand + " " + b.owner + " " + b.color;
    }
}
