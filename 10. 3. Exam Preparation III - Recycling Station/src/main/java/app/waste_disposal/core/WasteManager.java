package app.waste_disposal.core;


import app.waste_disposal.ProcessingDataImpl;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.WasteFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class WasteManager {

    // private ProcessingData processingData;
    private List<ProcessingData> processingDataList;
    private GarbageProcessor garbageProcessor;

    public WasteManager(GarbageProcessor garbageProcessor) {
        // this.processingData = processingData;
        this.processingDataList = new ArrayList<>();
        this.garbageProcessor = garbageProcessor;
    }


    public String processGarbage(List<String> params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String name = params.get(0);
        double weight = Double.parseDouble(params.get(1));
        double volumePerKilogram = Double.parseDouble(params.get(2));
        String garbageType = params.get(3);


        Waste waste = WasteFactory.createWaste(name, weight, volumePerKilogram, garbageType);
        // ProcessingData processingData = new ProcessingDataImpl(waste.)

        ProcessingData processingData = this.garbageProcessor.processWaste(waste);
        processingDataList.add(processingData);

        return waste.toString();
    }


    public String status() {

        double totalEnergyBalance = 0.0;
        double totalCapitalBalance = 0.0;

        for (ProcessingData processingData : processingDataList) {
            totalEnergyBalance += processingData.getEnergyBalance();
            totalCapitalBalance += processingData.getCapitalBalance();
        }

        return String.format("Energy: %.2f Capital: %.2f", totalEnergyBalance, totalCapitalBalance);
    }


}
