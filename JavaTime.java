import java.time.*;
        import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void printCurrentDateInfo() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        int day = currentDateTime.getDayOfMonth();
        int month = currentDateTime.getMonthValue();
        int year = currentDateTime.getYear();
        int hour = currentDateTime.getHour();
        int minute = currentDateTime.getMinute();
        int second = currentDateTime.getSecond();

        System.out.println("Aktualna data:");
        System.out.println("Dzień: " + day);
        System.out.println("Miesiąc: " + month);
        System.out.println("Rok: " + year);
        System.out.println("Godzina: " + hour);
        System.out.println("Minuta: " + minute);
        System.out.println("Sekunda: " + second);
    }

    public static void getCurrentTimeInNewYork() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYorkDateTime = currentDateTime.atZone(newYorkZoneId);

        int hour = newYorkDateTime.getHour();
        int minute = newYorkDateTime.getMinute();
        int second = newYorkDateTime.getSecond();

        System.out.println("Aktualny czas w strefie czasowej 'New York':");
        System.out.println("Godzina: " + hour);
        System.out.println("Minuta: " + minute);
        System.out.println("Sekunda: " + second);
    }

    public static class DateRange {
        private LocalDateTime from;
        private LocalDateTime to;
        private long daysBetween;

        public DateRange(LocalDateTime from, LocalDateTime to) {
            this.from = from;
            this.to = to;
            this.daysBetween = Duration.between(from, to).toDays();
        }

        public LocalDateTime getFrom() {
            return from;
        }

        public LocalDateTime getTo() {
            return to;
        }

        public long getDaysBetween() {
            return daysBetween;
        }
    }

    public static DateRange getPreviousMonthRange(LocalDate date) {
        LocalDate previousMonth = date.minusMonths(1);
        LocalDateTime from = previousMonth.withDayOfMonth(1).atStartOfDay();
        LocalDateTime to = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth()).atTime(23, 59, 59);

        return new DateRange(from, to);
    }

    public static void main(String[] args) {
        printCurrentDateInfo();
        System.out.println();
        getCurrentTimeInNewYork();
        System.out.println();

        LocalDate currentDate = LocalDate.now();
        DateRange previousMonthRange = getPreviousMonthRange(currentDate);
        System.out.println("Poprzedni miesiąc:");
        System.out.println("Od: " + previousMonthRange.getFrom());
        System.out.println("Do: " + previousMonthRange.getTo());
        System.out.println("Liczba dni: " + previousMonthRange.getDaysBetween());
    }
}
