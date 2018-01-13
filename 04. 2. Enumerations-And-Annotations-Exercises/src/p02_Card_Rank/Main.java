package p02_Card_Rank;

public class Main {
    public static void main(String[] args) {

        Fourteen_Ranks[] ranks = Fourteen_Ranks.values();

        System.out.println("Card Ranks:");
        for (Fourteen_Ranks rank : ranks) {
            System.out.println(rank);
        }
    }
}
