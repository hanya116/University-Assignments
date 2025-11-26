import java.util.Scanner;
public class CharInput {
    static class Input {  // inner class
        private Scanner sc = new Scanner(System.in);
        public char getChar() {
            return sc.next().charAt(0);
        }
        public void close() {
            sc.close();
        }
    }
    public static void main(String[] args) {
        InputHelper input = new Input();
        System.out.println("This program will ask you for 10 characters.");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter character " + i + ": ");
            char ch = input.getChar();
            System.out.println("You entered: " + ch);
        }
        input.close();
        System.out.println("Program Ended!");
    }
}
