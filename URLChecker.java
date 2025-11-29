import java.util.Scanner;
public class URLChecker {
    public static boolean isValidURL(String url) {
         url = url.trim();// Remove spaces
        // URL must start with http:// or https:// or www.
        if (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("www.")) {
        
            if (url.contains(".")) {  // URL must have at least 1 dot
                return true;
            }
        }
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
