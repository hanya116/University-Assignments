import java.util.Scanner;
public class URLChecker {
public static boolean isValidURL(String url) {
        url = url.trim(); // remove spaces
        String start = "";
        if (url.startsWith("http://")) {
            start = "http://";
        } else if (url.startsWith("https://")) {
            start = "https://";
        } else if (url.startsWith("www.")) {
            start = "www.";
        } else {
            return false; }
        url = url.substring(start.length());
        String[] parts = url.split("\\."); //split by dot
        if (parts.length == 0) return false;
        for (String p : parts) {
        if (p.isEmpty() || p.length() <= 2) return false; 
            for (char c : p.toCharArray()) { //to be greater than 2 and only letter/digits.
                if (!Character.isLetterOrDigit(c)) return false;
            }  }
        return true;  }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String input = sc.nextLine();
        if (isValidURL(input)) {
            System.out.println("VALID URL");
        } else {
            System.out.println("INVALID URL");
        } } }

