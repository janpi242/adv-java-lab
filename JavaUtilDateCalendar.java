import java.util.Calendar;
        import java.util.Date;
        import java.util.TimeZone;

public class JavaUtilDateCalendar {
    public static void printCurrentDateInfo() {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // Month starts from 0
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("Aktualna data:");
        System.out.println("Dzień: " + day);
        System.out.println("Miesiąc: " + month);
        System.out.println("Rok: " + year);
        System.out.println("Godzina: " + hour);
        System.out.println("Minuta: " + minute);
        System.out.println("Sekunda: " + second);
    }

    public static void getCurrentTimeInNewYork() {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        calendar.setTimeZone(timeZone);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("Aktualny czas w strefie czasowej 'New York':");
        System.out.println("Godzina: " + hour);
        System.out.println("Minuta: " + minute);
        System.out.println("Sekunda: " + second);
    }

    public static class DateRange {
        private Date from;
        private Date to;

        public DateRange(Date from, Date to) {
            this.from = from;
            this.to = to;
        }

        public Date getFrom() {
            return from;
        }

        public Date getTo() {
            return to;
        }
    }

    public static DateRange getPreviousMonthRange(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Set to first day of the month
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // Move to previous month
        calendar.add(Calendar.MONTH, -1);
        Date from = calendar.getTime();

        // Set to last day of the month
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date to = calendar.getTime();

        return new DateRange(from, to);
    }

    public static void main(String[] args) {
        printCurrentDateInfo();
        System.out.println();
        getCurrentTimeInNewYork();
        System.out.println();

        Date currentDate = new Date();
        DateRange previousMonthRange = getPreviousMonthRange(currentDate);
        System.out.println("Poprzedni miesiąc:");
        System.out.println("Od: " + previousMonthRange.getFrom());
        System.out.println("Do: " + previousMonthRange.getTo());
    }
}
