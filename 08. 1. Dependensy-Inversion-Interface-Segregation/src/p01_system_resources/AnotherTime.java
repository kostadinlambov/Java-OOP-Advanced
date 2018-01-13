package p01_system_resources;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AnotherTime implements TimeProvider {

    @Override
    public int getHour() {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
