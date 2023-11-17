import java.util.ArrayList;
import java.util.List;

public class KnapSackAlgo {
    private int w; // capacity maximal
    private int[] weight; // array of weights of objects
    private int[] value; // array of values of objects
    private int[][] matrix; // knapSack matrix

    public KnapSackAlgo(int w, int weight[], int value[]) {
        this.w = w;
        this.weight = weight;
        this.value = value;
        this.matrix = new int[value.length + 1][w + 1];
        knapSack();
    }

    private void knapSack() {
        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    matrix[i][j] = max(value[i - 1] + matrix[i - 1][j - weight[i - 1]], matrix[i - 1][j]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public void printMatrix() {
        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void selectedItem() {
        List<Integer> results = new ArrayList<>();
        int i = value.length;
        int j = w;

        while (i > 0) {
            if (matrix[i][j] == matrix[i - 1][j]) {
                i--;
            } else {
                results.add(i);
                i--;
                j -= weight[i];
            }
        }

        System.out.println("List of items to take :");
        for (int result : results) {
            System.out
                    .println("Item " + result + " (weight : " + weight[result - 1] + ", value : " + value[result - 1]
                            + ")");
        }
    }

    public static void main(String[] args) {

        // example data
        int value[] = new int[] { 1200, 5000, 1300, 2700, 1000 };
        int weight[] = new int[] { 1, 7, 5, 10, 2 };
        int w = 10;

        // data processing
        KnapSackAlgo knapSackAlgo = new KnapSackAlgo(w, weight, value);
        knapSackAlgo.printMatrix();
        knapSackAlgo.selectedItem();
    }
}