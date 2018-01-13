package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints, Assembler vehicleAssembler) {
        super(model, weight, price, attack, defense, hitPoints, vehicleAssembler);
    }

    @Override
    public double getTotalWeight() {

        return super.getTotalWeight()  * 2;
    }

    @Override
    public long getTotalAttack() {
        return super.getTotalAttack()  -  (super.getTotalAttack() * 25) / 100;
    }

    @Override
    public long getTotalDefense() {
        return super.getTotalDefense() + (super.getTotalDefense() * 50) / 100;
    }

    @Override
    public long getTotalHitPoints() {
        return super.getTotalHitPoints() + (super.getTotalHitPoints() * 75) / 100;
    }
}
