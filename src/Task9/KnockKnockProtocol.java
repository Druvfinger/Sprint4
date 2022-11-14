package Task9;

public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTRIDDLE = 1;
    private static final int ANOTHER = 2;
    private static final int NUMRIDDLES = 3;
    private int state = WAITING;
    private int currentRiddle = 0;


    private String[] riddles = {" Flat as a leaf, round as a ring; Has two eyes, can't see a thing. What is it? ",
            "I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I? ",
            " What runs around the whole yard without moving? "};
    private String[] answers = {"A button",
            "Fire",
            "A Fence"};


    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = riddles[currentRiddle];
            state = SENTRIDDLE;
        }
        else if (state == SENTRIDDLE) {
            if (theInput.trim().equalsIgnoreCase(answers[currentRiddle])) {
                state = ANOTHER;
                theOutput = "Correct, press y for another or n for no";
            } else {
                theOutput = "Wrong, try again";
            }
        }
        else if (state == ANOTHER) {
            if (theInput.trim().equalsIgnoreCase("y")) {
                if (currentRiddle == (NUMRIDDLES - 1)) {
                    currentRiddle = 0;
                }else {
                    currentRiddle++;
                    theOutput = riddles[currentRiddle];
                    state = SENTRIDDLE;
                }
            } else if (theInput.trim().equalsIgnoreCase("n")){
                theOutput = "Bye.";
            }
            else {
                theOutput = "unexpected error";
            }
        }
        return theOutput;
    }
}