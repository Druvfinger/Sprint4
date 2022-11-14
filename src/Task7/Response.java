package Task7;

import java.io.Serializable;

public class Response implements Serializable {

    protected boolean success;
    protected Friend person;

    public Response() {
    }

    public Response(boolean success) {
        this.success = success;
    }

    public Response(boolean success, Friend person) {
        this.success = success;
        this.person = person;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Friend getPerson() {
        return person;
    }

    public void setPerson(Friend person) {
        this.person = person;
    }
}
