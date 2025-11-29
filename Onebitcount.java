import java.util.Scanner;
class Onebitcount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter a number: ");
        int aap = scanner.nextInt();
        int y = aap;       
        String binary = "";
                while (y > 0) {
            int bit = y & 1;         
            binary = bit + binary;      
            y = y >> 1;           
        }
        int countY = aap;  
        int count = 0;
        while (countY > 0) {
            count += countY & 1;
            countY >>= 1;
        }
        System.out.println("Binary of " + aap + " is: " + binary);
        System.out.println("Number of 1 bits: " + count);
        scanner.close();
    }
}
