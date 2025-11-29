import java.util.Scanner;
public class URLChecker {
    public static boolean isValidURL(String url) {
        // Remove spaces
        url = url.trim();
        // URL must start with http:// or https:// or www.
        if (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("www.")) {
         // URL must have at least 1 dot
            if (url.contains(".")) {
                return true;
            }
        }
        // If above conditions fail → invalid
        return false;
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
