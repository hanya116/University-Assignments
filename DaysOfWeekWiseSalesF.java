
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class DaysOfWeekWiseSalesF {

    public static void main(String[] args) {
        String path = "C:\\Users\\Lab User\\Desktop\\EVE01Sales.txt"; // <-- change path if needed
        HashMap<String, Double> daySales = new HashMap<>();

        try {
            File f1 = new File(path);
            Scanner inp = new Scanner(f1);

            // Skip header line
            if (inp.hasNextLine()) {
                inp.nextLine();
            }

            // Define a date formatter — e.g. 15-Oct-2025
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

            while (inp.hasNextLine()) {
                String line = inp.nextLine();
                String[] fields = line.split("\t");
                if (fields.length < 6) {
                    continue;
                }

                String dateStr = fields[0].trim();
                int qty = Integer.parseInt(fields[4].trim());
                double price = Double.parseDouble(fields[5].trim());
                double amount = qty * price;

                // Parse the date using the formatter
                LocalDate date;
                try {
                    date = LocalDate.parse(dateStr, formatter);
                } catch (Exception e) {
                    // Skip line if date format is invalid
                    continue;
                }

                // Get day of week (e.g. MONDAY, TUESDAY)
                DayOfWeek day = date.getDayOfWeek();
                String dayName = day.toString().substring(0, 1)
                        + day.toString().substring(1).toLowerCase();

                // Add to total for that day
                daySales.put(dayName, daySales.getOrDefault(dayName, 0.0) + amount);
            }

            inp.close();

            // Print results
            System.out.println("Day-of-Week-wise Sales Amount:");
            System.out.println("------------------------------");
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            for (String d : days) {
                double total = daySales.getOrDefault(d, 0.0);
                System.out.printf("%-10s : %.2f%n", d, total);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("File can't be opened: " + fnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
