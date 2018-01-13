package p01_Weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry>{

    private Weekday weekday;
    private String note;

  public WeeklyEntry(String weekday, String note){
      this.weekday = Weekday.valueOf(weekday.toUpperCase());
      this.note = note;
  }

    @Override
    public String toString() {
        return this.weekday + " - " + this.note;
    }

    @Override
    public int compareTo(WeeklyEntry o) {
        return this.weekday.compareTo(o.weekday);
    }
}
