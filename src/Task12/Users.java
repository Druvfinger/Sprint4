package Task12;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Users {

    protected String username;

    private static List<PrintWriter> users = new ArrayList<>();

    public void addUser(PrintWriter p) {
        users.add(p);
    }

    public List<PrintWriter> getUsers() {
        return users;
    }
}
