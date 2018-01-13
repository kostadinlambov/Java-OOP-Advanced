package p03_Dependency_Inversion.calculateStrategies;

import p03_Dependency_Inversion.interfaces.Strategy;

public class AdditionStrategy implements Strategy{
    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
