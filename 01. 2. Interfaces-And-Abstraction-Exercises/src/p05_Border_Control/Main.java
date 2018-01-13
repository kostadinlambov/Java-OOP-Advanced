package p05_Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identificatable> list = new ArrayList<>();

        while(true){

            String[] tokens = reader.readLine().split("\\s+");

            if("End".equalsIgnoreCase(tokens[0])){
                break;
            }

            if (tokens.length == 3){
                String name = tokens[0];
                String age = tokens[1];
                String id = tokens[2];

                Identificatable citizen = new Citizen(name, age, id);
                list.add(citizen);
            }else{
                String model = tokens[0];
                String id = tokens[1];

                Identificatable robot = new Robot(model, id);
                list.add(robot);
            }
        }

        String endOfFakeId = reader.readLine();

        List<String> fakeIds = new ArrayList<>();

        for (Identificatable member : list) {
            if(member.detain(endOfFakeId)){
                fakeIds.add(member.getId());
            }
        }

        for (String fakeId : fakeIds) {
            System.out.println(fakeId);
        }
    }
}
