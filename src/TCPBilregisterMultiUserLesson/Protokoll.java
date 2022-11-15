package TCPBilregisterMultiUserLesson;

public class Protokoll {

    Database d = new Database();
    protected final int INITIAL = 0;
    protected final int INTHELOOP = 1;

    protected int state = INITIAL;

    public String getOutput(String fromClient){

        if (state == INITIAL){
            state = INTHELOOP;
            return "Välkommen, skriv in regNr: ";
        } else if (state == INTHELOOP) {
            return d.search(fromClient);
        }
        else {
            return "Unexpected state error";
        }
    }
}
