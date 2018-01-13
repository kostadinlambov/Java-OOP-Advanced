package p03_Dependency_Inversion.factories;

import p03_Dependency_Inversion.calculateStrategies.AdditionStrategy;
import p03_Dependency_Inversion.calculateStrategies.DivisionStrategy;
import p03_Dependency_Inversion.calculateStrategies.MultiplicationStrategy;
import p03_Dependency_Inversion.calculateStrategies.SubtractionStrategy;
import p03_Dependency_Inversion.interfaces.Strategy;

public final class StrategiesFactory {

    private StrategiesFactory(){}

    public static Strategy createStrategy(char operator) {
        switch (operator) {
            case '+':
                return new AdditionStrategy();
            case '-':
                return new SubtractionStrategy();
            case '*':
                return new MultiplicationStrategy();
            case '/':
                return new DivisionStrategy();
        }
        return null;
    }
}
