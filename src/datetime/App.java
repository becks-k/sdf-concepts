public class App {
    public static void main(String[] args) throws Exception {
        //Predefined Formatters
        String dateString1 = "20240213";
        LocalDate date1 = LocalDate.parse(dateString1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date1);

        //Custom Formatter
        String dateString2 = "13 February 2024 15:44:00 Singapore";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss z");
        LocalDate date2 = LocalDate.parse(dateString2, formatter);
        System.out.println(date2);
        //Specific time zone
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString2, formatter);
        System.out.println(zonedDateTime);

        //Local Date Time
        LocalDateTime date3 = LocalDateTime.now();
        System.out.println(date3);
    }
}
