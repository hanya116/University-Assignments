//Method calling concept
public class MethodConcept{
    public static void main(String[] args){
        int[] a={1,2,3,4,5};
        sum(a);
        }
       public static void sum(int[] array){
        int res = 0;
        for(int i:array){
            res += i;
        }
        System.out.println("Sum of Array ="+ " " +res);
        
        }
}
