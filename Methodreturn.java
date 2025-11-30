//Method mein void with return type use nahi karte
public class Methodreturn{
    public static void main(String[] args){
        int[] a={1,2,3,4,5};
        int sumA= sum(a);
        System.out.println("Sum of Array ="+" "+sumA);
       
        }
       public static int sum(int[] array){
        int res = 0;
        for(int i:array){
            res += i;
        }
        return res;
        }
}
