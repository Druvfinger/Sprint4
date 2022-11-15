package Task10;

public class Protocol {

    DAO d = new DAO();
    Friend daoResponse;

    private final int OPENPROGRAM = 0;
    private final int WAITING = 1;

    private int state = OPENPROGRAM;

    public Object processInput(String clientInput){
        Object objectToSend = null;

        if (state == OPENPROGRAM){ // state when program opens

            objectToSend = new Intro(); // Sets the object to klass Intro when program opens
            state = WAITING; // changing state to waiting
        } else if (state == WAITING) { // if state is waiting
            daoResponse = d.checkForName(clientInput); // check if input equals name in phonebook
            if (daoResponse == null){ // if name does not exist
                objectToSend = new Response(false); // sends back response false
            }else{
                objectToSend = new Response(true, daoResponse);
            }
        }
        return objectToSend;
    }

}
