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



/*
Using Switch
import java.util.Scanner;
public class URLChecker {

    public static boolean isValidURL(String url) {
        url = url.trim(); // remove spaces
        String start = "";

        // Determine prefix using switch
        String prefix = "";
        if (url.startsWith("http://")) prefix = "http";
        else if (url.startsWith("https://")) prefix = "https";
        else if (url.startsWith("www.")) prefix = "www";

        switch (prefix) {
            case "http":
                start = "http://";
                break;
            case "https":
                start = "https://";
                break;
            case "www":
                start = "www.";
                break;
            default:
                return false;
        }

        url = url.substring(start.length());   // remove prefix

        String[] parts = url.split("\\.");     // split by dot
        if (parts.length == 0) return false;

        for (String p : parts) {
            if (p.isEmpty() || p.length() <= 2) return false;

            // must be alphanumeric
            for (char c : p.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String input = sc.nextLine();

        if (isValidURL(input)) {
            System.out.println("VALID URL");
        } else {
            System.out.println("INVALID URL");
        }
    }
}
*/
