//recursion for Exponentiation
public class recursionE{
    public static void main(String[] args){
       System.out.println(fn(2,3));
    }
       public static int fn(int a,int b){
           if (b==0){
               return 1;
           }
           else{
               return(a*fn(a,b-1));
           }
           }
       }
