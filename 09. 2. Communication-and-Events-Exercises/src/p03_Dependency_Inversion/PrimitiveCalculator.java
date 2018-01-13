package p03_Dependency_Inversion;

import p03_Dependency_Inversion.factories.StrategiesFactory;
import p03_Dependency_Inversion.interfaces.Strategy;

public class PrimitiveCalculator {
    private Strategy strategy;

    public PrimitiveCalculator() {
        this.setStrategy();
    }

    private void setStrategy() {
        this.strategy = StrategiesFactory.createStrategy('+');
    }

    public void changeStrategy(char operator) {
        this.strategy = StrategiesFactory.createStrategy(operator);
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
