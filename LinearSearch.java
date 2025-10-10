import java.util.*;
public class LinearSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = {
            "12", "45", "78", "23", "56",
            "89", "34", "67", "90", "11",
            "22", "33", "44", "55", "66"
        };
        System.out.println("Array elements: " + Arrays.toString(numbers));

        System.out.print("Enter a number to search: ");
        String key = sc.nextLine();

        int position = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(key)) {
                position = i;
                break;
            }
        }

            if (position != -1) {
            System.out.println("Number " + key + " found at position (index): " + position);
        } else {
            System.out.println("Number " + key + " not found in the array.");
        }

        sc.close();
    }
}