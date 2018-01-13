package p01_Weekdays;

public class Main {
    public static void main(String[] args) {

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("monday", "work");
        wc.addEntry("sunday", "sleep");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();

        for (WeeklyEntry weeklyCalendarEntry : schedule) {
            System.out.println(weeklyCalendarEntry);
        }
    }
}
