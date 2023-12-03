package study;

import java.util.Arrays;

public class Combination {
    public void combinate(int[] arr, int[] output, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
        }

        for (int i=start; i<arr.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combinate(arr, output, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
