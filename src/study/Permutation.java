package study;

import java.util.Arrays;

public class Permutation {

    public void permute(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permute(arr, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}
