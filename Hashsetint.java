//ismein int ke bajaye Integer use hoga
import java.util.HashSet;
public class Hashsetint{
    public static void main(String[] args){
     HashSet<Integer> prime=new HashSet<Integer>();
     prime.add(2);
     prime.add(3);
     prime.add(5);
     prime.add(7);
     prime.add(8);
     
     prime.remove(8);
     for (int i = 1; i <= 10; i++) {
      if (prime.contains(i)) {
        System.out.println(i + " was found in the set.");
      } else {
        System.out.println(i + " was not found in the set.");
      }
    }
  }
}
