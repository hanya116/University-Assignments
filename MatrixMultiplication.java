import java.util.*;
public class MatrixMultiplication{
        public static void main(String[] args){
        int[][] a={{1,2,3},
                  {4,5,6},
                  {7,3,2}
                    };
        int[][] b={{1,3,4},
                  {5,7,2},
                  {1,9,2}
                };
           int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Result Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
