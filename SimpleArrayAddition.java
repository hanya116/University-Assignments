import java.util.Arrays;
public class SimpleArrayAddition{
    public static void main(String[] args){
        int array[]={1,2,3,4,5};
        int res = 0;
        for(int i:array){
            res += i;
        }
        System.out.println("Array ="+ Arrays.toString(array));
        System.out.println("Sum of Array ="+ " " +res);
        
        }
    }
