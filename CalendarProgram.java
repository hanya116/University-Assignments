import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = input.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        LocalDate firstDay = LocalDate.of(year, month, 1);
        int daysInMonth = firstDay.lengthOfMonth();

        DayOfWeek startDay = firstDay.getDayOfWeek();
        int startIndex = startDay.getValue(); // 1 = Monday, 7 = Sunday

        if (startIndex == 7)
            startIndex = 0;

        System.out.println("Calendar for the month of " + firstDay.getMonth() + ", " + year);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        int day = 1; 
        int counter = 0;

        while (counter < 42) {
           if (counter < startIndex) {
                System.out.print("    ");
            } else if (day <= daysInMonth) {
                   System.out.printf("%-4d", day);
                day++;
            } else {
                           System.out.print("    ");
            }

            counter++;

           if (counter % 7 == 0)
                System.out.println();
        }

        input.close();
    }
}
