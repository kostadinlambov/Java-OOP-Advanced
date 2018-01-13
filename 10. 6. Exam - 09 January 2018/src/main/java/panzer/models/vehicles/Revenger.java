package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Revenger extends BaseVehicle {


    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints, Assembler vehicleAssembler) {
        super(model, weight, price, attack, defense, hitPoints, vehicleAssembler);
    }


    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal multiplyer = new BigDecimal(50);
      //  BigDecimal divisor = new BigDecimal(100);
        BigDecimal divisor = new BigDecimal(100);

        BigDecimal secondParameter = super.getTotalPrice().multiply(multiplyer).divide(divisor, 3, RoundingMode.HALF_UP);

        return super.getTotalPrice().add(secondParameter);
    }


    @Override
    public long getTotalAttack() {
        return super.getTotalAttack() + (super.getTotalAttack() * 150) / 100;
    }

    @Override
    public long getTotalDefense() {
        return super.getTotalDefense() - (super.getTotalDefense() * 50) / 100;
    }

    @Override
    public long getTotalHitPoints() {
        return super.getTotalHitPoints() - (super.getTotalHitPoints() * 50) / 100;
    }

}
