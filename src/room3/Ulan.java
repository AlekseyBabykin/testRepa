package room3;

public class Ulan {
    int[][] matrix;

    public Ulan(int dimension) {
        this.matrix = new int[dimension][dimension];
        fillUlam(matrix, matrix.length / 2, matrix.length / 2, true, 0, 1);
    }

    private void fillUlam(int[][] matrix, int x, int y, boolean goRight, int length, int iterator) {

        // if first iteration
        if (length == 0) {
            matrix[x][y] = iterator;
            fillUlam(matrix, x + 1, y, goRight, length + 1, ++iterator);
        }
        //if last iteration
        else if (length == matrix.length) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][y] = iterator;
                iterator++;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[j][i] < 10) System.out.print(" ");
                    System.out.print(matrix[j][i] + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
