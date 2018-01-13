package p02_Car_Shop_Extend;

public interface Rentable extends Car {

    Integer getMinRentDay();

    Double getPricePerDay();
}
