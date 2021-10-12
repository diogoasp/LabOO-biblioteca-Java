package biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        DateManagement date = new DateManagement();
        Calendar todayDate = Calendar.getInstance();
        Calendar anotherDate = new GregorianCalendar(2021,11,12);
        System.out.println("Day of year todayDate = "+todayDate.getTime());
        System.out.println("Day of year anotherDate = "+anotherDate.getTime());
        System.out.println("Dias entre datas: "+date.daysBetweenDates(todayDate, anotherDate));
    }
}
