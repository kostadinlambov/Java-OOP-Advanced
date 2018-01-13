package twitter;

import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {

    private List<String> messages;


    public ServerImpl() {
        this.messages = new ArrayList<String>();
    }

    @Override
    public void storeMessages(String message) {
        this.messages.add(message);
    }
}
