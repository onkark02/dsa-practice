package practice.random;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class TimeTester {
    public static void main(String[] args) {
        //long timeEpoch = 1583151761699L;
        Instant monthStartDate = LocalDate.now().withDayOfMonth(1).atStartOfDay().toInstant(ZoneOffset.UTC);
        Thread thread = new Thread();
        Date date = Date.from(monthStartDate);
        System.out.println("Month start: "+ date);

//        System.out.println("Date: "+ date);
//
//        Duration duration = Duration.ofSeconds(3600);
//        Date startTime = Date.from(date.toInstant().minusSeconds(10));
//        System.out.println("StartDate: "+startTime);
    }


}
