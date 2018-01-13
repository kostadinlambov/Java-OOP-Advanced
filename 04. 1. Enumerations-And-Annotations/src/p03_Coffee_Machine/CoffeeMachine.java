package p03_Coffee_Machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffeeList;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        int sumOfCoins = this.coins.stream().mapToInt(Coin::getValue).sum();
        if(coffeeSize.getPrice() <= sumOfCoins){
            coffeeList.add(new Coffee(coffeeType, coffeeSize));
            this.coins.clear();
        }
    }
    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin.toUpperCase()));

    }
	public Iterable<Coffee> coffeesSold(){
        return this.coffeeList;
    }






}
