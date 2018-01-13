package p01_Event_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        while(true){
            String name = reader.readLine();

            if("End".equalsIgnoreCase(name)){
                break;
            }

            //dispatcher.setName(name);
            NameChange nameChange = new NameChange(name);
            dispatcher.setName(nameChange.getChangedName());
            dispatcher.fireNameChangeEvent();

           // handler.handleChangedName(nameChange);
        }
    }
}
