package p08_Military_Elite;

import p08_Military_Elite.implementation.*;
import p08_Military_Elite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Soldier> army = new LinkedHashMap<>();
        String line = "";

        while (true) {

            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String tokens[] = line.split("\\s+");
            String type = tokens[0];
            int id = Integer.valueOf(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type) {

                case "Private":
                    army.putIfAbsent(id, new PrivateImpl(id, firstName, lastName, Double.valueOf(tokens[4])));
                    break;
                case "LeutenantGeneral":
                    Collection<Private> collectionOfPrivates = new ArrayList<>();

                    Stream.of(tokens).skip(5).map(Integer::parseInt).collect(Collectors.toList()).forEach(e -> collectionOfPrivates.add(Private.class.cast(army.get(e))));

                    army.putIfAbsent(id, new LeutenantGeneralImpl(id, firstName, lastName, Double.valueOf(tokens[4]), collectionOfPrivates));
                    break;
                case "Engineer":
                    Collection<Repair> repairCollection = new ArrayList<>();
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length; i += 2) {

                            repairCollection.add(new RepairImpl(tokens[i], Integer.valueOf(tokens[i + 1])));
                        }
                    }
                    SpecialisedSoldier engineer = new EgineerImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], repairCollection);
                    if (engineer.getCorps() != null) {
                        army.putIfAbsent(id, engineer);
                    }
                    break;
                case "Commando":
                    Collection<Mission> missionsCollection = new ArrayList<>();
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length; i += 2) {
                            Mission m = new MissionImpl(tokens[i], tokens[i + 1]);
                            if (m.getState() != null) {
                                missionsCollection.add(new MissionImpl(tokens[i], tokens[i + 1]));
                            }
                        }
                    }
                    SpecialisedSoldier soldier = new CommandoImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], missionsCollection);
                    if (soldier.getCorps() != null) {
                        army.putIfAbsent(id, soldier);
                    }
                    break;
                case "Spy":
                    army.putIfAbsent(id, new SpyImpl(id, firstName, lastName, tokens[4]));
                    break;
            }
        }

        for (Soldier soldier : army.values()) {
            System.out.println(soldier.toString().trim().replaceAll(",", "."));
        }
    }
}
