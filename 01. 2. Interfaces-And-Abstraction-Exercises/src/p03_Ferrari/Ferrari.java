package p03_Ferrari;

public class Ferrari implements Car {

    private String carModel;
    private String driverName;

    Ferrari(String driverName) {
        this.carModel = "488-Spider";
        this.setDriverName(driverName);
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gssPedal() {
        return "Zadu6avam sA!";

    }

    @Override
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.carModel, this.brakes(),
                this.gssPedal(), this.getDriverName());
    }
}
