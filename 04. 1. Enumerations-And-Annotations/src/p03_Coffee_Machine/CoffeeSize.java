package p03_Coffee_Machine;

public enum CoffeeSize {

    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int milliliters;
    private int price;

    CoffeeSize(int milliliters, int price) {
        this.milliliters = milliliters;
        this.price = price;
    }

    public int getMilliliters() {
        return this.milliliters;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
