import java.util.ArrayList;
import java.util.List;

public class Exercises {

    public int[] productIndices(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] * values[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] spiralTraversal(int[][] values, int rows, int cols) {
        if (rows == 0 || cols == 0) return new int[0];
        int[] result = new int[rows * cols];
        int index = 0;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) result[index++] = values[top][i];
            top++;
            for (int i = top; i <= bottom; i++) result[index++] = values[i][right];
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result[index++] = values[bottom][i];
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result[index++] = values[i][left];
                left++;
            }
        }
        return result;
    }

    public int[][] intPartitions(int n) {
        List<int[]> partitions = new ArrayList<>();
        generatePartitions(n, new int[n], 0, partitions);
        int[][] result = new int[partitions.size()][];
        for (int i = 0; i < partitions.size(); i++) result[i] = partitions.get(i);
        return result;
    }

    private void generatePartitions(int n, int[] current, int index, List<int[]> partitions) {
        if (n == 0) {
            int[] partition = new int[index];
            System.arraycopy(current, 0, partition, 0, index);
            partitions.add(partition);
            return;
        }
        int start = (index == 0) ? n : Math.min(n, current[index - 1]);
        for (int i = start; i >= 1; i--) {
            current[index] = i;
            generatePartitions(n - i, current, index + 1, partitions);
        }
    }

    public static void main(String[] args) {
       //test
        }
    }
