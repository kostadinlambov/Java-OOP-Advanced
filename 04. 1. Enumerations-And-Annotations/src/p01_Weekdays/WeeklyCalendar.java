package p01_Weekdays;

import java.util.*;

public class WeeklyCalendar  {
    List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        this.entries.sort(Comparator.naturalOrder());
        return this.entries;
    }

    public void addEntry(String weekday, String notes) {
        this.entries.add(new WeeklyEntry(weekday, notes));
    }
}
