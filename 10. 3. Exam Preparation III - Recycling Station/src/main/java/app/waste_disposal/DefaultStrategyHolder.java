package app.waste_disposal;

import app.waste_disposal.annotations.BurnableGarbageStrategyAnnotation;
import app.waste_disposal.annotations.RecyclableGarbageStrategyAnnotation;
import app.waste_disposal.annotations.StorableGarbageStrategyAnnotation;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.entities.strategies.BurnableGarbageStrategy;
import app.waste_disposal.entities.strategies.RecyclableGarbageStrategy;
import app.waste_disposal.entities.strategies.StorableGarbageStrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class, GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder() {
        this.strategies = new LinkedHashMap<>();
        this.seedStrategies();
    }

    private void seedStrategies() {
        this.addStrategy(BurnableGarbageStrategyAnnotation.class, new BurnableGarbageStrategy());
        this.addStrategy(RecyclableGarbageStrategyAnnotation.class, new RecyclableGarbageStrategy());
        this.addStrategy(StorableGarbageStrategyAnnotation.class, new StorableGarbageStrategy());
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if (!this.strategies.containsKey(annotationClass)) {
            this.strategies.put(annotationClass, strategy);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if (this.strategies.containsKey(annotationClass)) {
            this.strategies.remove(annotationClass);
            return true;
        }
        return false;
    }
}
