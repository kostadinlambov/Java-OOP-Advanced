package app.waste_disposal.contracts;

/**
 * Interface that Garbage Disposal Strategies passed to the BaseWaste Disposal Framework should implement.
 */
public interface GarbageDisposalStrategy {

    /**
     * Processes a BaseWaste object and returns the result of the processing as a ProcessingData object.
     * @param garbage The BaseWaste object that will be processed.
     * @return An object of type ProcessingData containing all information about the results of the processing.
     */
    ProcessingData processGarbage(Waste garbage);
}
