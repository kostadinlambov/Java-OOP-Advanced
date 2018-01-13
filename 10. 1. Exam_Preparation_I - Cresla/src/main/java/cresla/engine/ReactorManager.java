package cresla.engine;

import cresla.entities.containers.ModuleContainer;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReactorManager implements Manager {

    private int id;
    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;

    public ReactorManager() {
        this.id = 0;
        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
    }

    public int getId() {
        return this.id;
    }

    private void setId() {
        ++this.id;
    }

    @Override
    public String reactorCommand(List<String> params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String reactorType = params.get(0);
        int additionalParameter = Integer.parseInt(params.get(1));
        int moduleCapacity = Integer.parseInt(params.get(2));

        Container container = new ModuleContainer(moduleCapacity);

        this.setId();
        Reactor reactor = ReactorFactory.createReactor(reactorType, additionalParameter, container, this.getId());

        reactorMap.putIfAbsent(this.id, reactor);

        //System.out.printf("Created %s Reactor – %d%n", reactorType, this.getId());
        return String.format("Created %s Reactor - %d", reactorType, this.getId());
    }

    @Override
    public String moduleCommand(List<String> params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        int reactorId = Integer.parseInt(params.get(0));
        String moduleType = params.get(1);
        int additionalParameter = Integer.parseInt(params.get(2));

        this.setId();
        Module module = ModuleFactory.createModule(this.getId(), additionalParameter, moduleType);

        moduleMap.putIfAbsent(this.getId(), module);

        Reactor reactor = reactorMap.get(reactorId);
        if (moduleType.equalsIgnoreCase("CryogenRod")) {
            reactor.addEnergyModule((EnergyModule) module);
        } else {
            reactor.addAbsorbingModule((AbsorbingModule) module);
        }
        //System.out.printf("Added %s - %d to Reactor - %d%n", moduleType, this.getId(), reactorId);
        return String.format("Added %s - %d to Reactor - %d", moduleType, this.getId(), reactorId);
    }

    @Override
    public String reportCommand(List<String> params) {
        int idToReport = Integer.parseInt(params.get(0));


        if (reactorMap.containsKey(idToReport)) {
            return reactorMap.get(idToReport).toString();
        } else {
            return moduleMap.get(idToReport).toString();
        }

//        for (Map.Entry<Integer, Reactor> reactorEntry : reactorMap.entrySet()) {
//            if (reactorEntry.getKey() == idToReport) {
//                Reactor reactor = reactorEntry.getValue();
////                System.out.println(reactor.toString());
////                return null;
//                return reactor.toString();
//            }
//        }
//
//
//        for (Map.Entry<Integer, Module> moduleEntry : moduleMap.entrySet()) {
//            if (moduleEntry.getKey() == idToReport) {
//                Module module = moduleEntry.getValue();
//                //System.out.println(module.toString());
//               // return null;
//                return module.toString();
//            }
//        }

        //return null;
    }


    @Override
    public String exitCommand(List<String> arguments) {
//        Cryo Reactors: {cryoReactorsCount}
//        Heat Reactors: {heatReactorsCount}
//        Energy Modules: {energyModulesCount}
//        Absorbing Modules: {absorbingModulesCount}
//        Total Energy Output: {totalEnergyOutput}
//        Total Heat Absorbing: {totalHeatAbsorbing}

        StringBuilder sb = new StringBuilder();

//        long totalEnergyOutput = reactorMap.entrySet().stream()
//                .mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();
//

        sb.append(String.format("Cryo Reactors: %d", this.cryoReactorsCount())).append(System.lineSeparator());
        sb.append(String.format("Heat Reactors: %d", this.heatReactorsCount())).append(System.lineSeparator());
        sb.append(String.format("Energy Modules: %d", this.energyModulesCount())).append(System.lineSeparator());
        sb.append(String.format("Absorbing Modules: %d", this.absorbingModulesCount())).append(System.lineSeparator());
        sb.append(String.format("Total Energy Output: %d", this.getTotalEnergyOutput())).append(System.lineSeparator());
        sb.append(String.format("Total Heat Absorbing: %d", this.getTotalHeatAbsorbing())).append(System.lineSeparator());

        return sb.toString().trim();
    }


    private long cryoReactorsCount() {
        return reactorMap.values()
                .stream()
                .filter(x -> x.getClass()
                        .getSimpleName()
                        .equalsIgnoreCase("CryoReactor"))
                .count();
    }

    private long heatReactorsCount() {
        return reactorMap.values()
                .stream()
                .filter(x -> x.getClass()
                        .getSimpleName()
                        .equalsIgnoreCase("HeatReactor"))
                .count();
    }

    private long energyModulesCount() {
        return moduleMap.values()
                .stream()
                .filter(x -> x.getClass()
                        .getSimpleName()
                        .equalsIgnoreCase("CryogenRod"))
                .count();
    }

    private long absorbingModulesCount() {
        return moduleMap.values()
                .stream()
                .filter(x -> x.getClass()
                        .getSimpleName()
                        .equalsIgnoreCase("HeatProcessor") ||
                        x.getClass()
                                .getSimpleName()
                                .equalsIgnoreCase("CooldownSystem")
                )
                .count();
    }

    private long getTotalEnergyOutput() {
        long sum = 0L;
        for (Reactor reactor : reactorMap.values()) {
            sum += reactor.getTotalEnergyOutput();
        }
        long totalEnergyOutput = reactorMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();

//
//        List<Module> moduleList = moduleMap.values().stream()
//                .filter(x-> x.getClass()
//                        .getSimpleName()
//                        .equalsIgnoreCase("CryogenRod"))
//                .collect(Collectors.toList());
//
//        long sum = 0L;
//        for (Module module : moduleList) {
//            BaseEnergyModule baseEnergyModule = (BaseEnergyModule) module;
//            sum += baseEnergyModule.getEnergyOutput();
//        }
        return sum;
    }

    private long getTotalHeatAbsorbing() {
        long totalEnergyOutput = reactorMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();
        long sum = 0L;
        for (Reactor reactor : reactorMap.values()) {
            sum += reactor.getTotalHeatAbsorbing();
        }


//        List<Module> moduleList = moduleMap.values()
//                .stream()
//                .filter(x-> x.getClass()
//                        .getSimpleName()
//                        .equalsIgnoreCase("HeatProcessor") ||
//                        x.getClass()
//                                .getSimpleName()
//                                .equalsIgnoreCase("CooldownSystem")
//                )
//                .collect(Collectors.toList());
//        long sum = 0L;
//        for (Module module : moduleList) {
//            BaseAbsorberModule baseEnergyModule = (BaseAbsorberModule) module;
//            sum += baseEnergyModule.getHeatAbsorbing();
//        }
        return sum;
    }
}
