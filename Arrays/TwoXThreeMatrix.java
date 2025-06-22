/*
 * Create a 2×3 matrix and print its elements in matrix form.
 */
package Arrays;

public class TwoXThreeMatrix {
    public static void main(String[] args) {
        int mat [][] = new int[2][3];
        mat[0][0] = 1;
        mat[0][1] = 1;
        mat[0][2] = 1;
        mat[1][0] = 1;
        mat[1][1] = 1;
        mat[1][2] = 1;
        

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }System.out.println(" ");
        }
    }
}
