public class Exp5_MatrixMultiplication {
    static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = multiply(A, B);

        for (int[] row : C) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < row.length; i++) {
                sb.append(row[i]);
                if (i != row.length - 1) sb.append(", ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
