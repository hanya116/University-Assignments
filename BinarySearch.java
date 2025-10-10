import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data[] = {15, 31, 35, 38, 44, 46, 55, 79, 90, 92};

        System.out.println("Hint: The array contains 10 sorted numbers between 15 and 92.");
        System.out.print("Enter number to search: ");
        int s = sc.nextInt();
        int si = 0;                  
        int li = data.length - 1;    
        int found = -1;              

        while (found < 0 && si <= li) {
            int mi = (si + li) / 2;  
            if (s == data[mi]) {
                found = mi;          
            }
             else if (s < data[mi]) {
                li = mi - 1;         
            } else {
                si = mi + 1;         
            }
        }

        if (found >= 0) {
            System.out.println("Found at position (index): " + found);
        } else {
            System.out.println("Not found in array.");
        }

        sc.close();
    }
}
