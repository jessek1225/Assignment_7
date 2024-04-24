public class Main {
    public static boolean isDirectedGraph(int[][] matrix) {
        int n = matrix.length;

        // Check if the matrix is square
        if (n != matrix[0].length) {
            return false;
        }

        // Check if the matrix represents a directed graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] != 0) {
                    // If there's an edge from i to j, but no edge from j to i, it's directed
                    if (matrix[j][i] == 0) {
                        return true;
                    }
                }
            }
        }

        return false; // If all edges are symmetric, it's not directed
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };

        if (isDirectedGraph(matrix)) {
            System.out.println("The matrix represents a directed graph.");
        } else {
            System.out.println("The matrix does not represent a directed graph.");
        }
    }
}
