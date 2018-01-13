package pr05_BarracksWars_Return_of_the_Dependencies.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
