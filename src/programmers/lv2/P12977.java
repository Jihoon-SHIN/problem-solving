package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class P12977 {
    public int solution(int[] nums) {
        int answer = -1;
        List<Integer> primes = new ArrayList<>();
        combinate(nums, new boolean[nums.length], 0, 3, 0, primes, new int[3]);
        return primes.size();
    }

    private void combinate(int[] nums, boolean[] visited, int start, int r, int depth, List<Integer> primes, int[] output) {
        if (depth == r) {
            // prime 확인
            int sum = 0;
            for (int i=0; i<output.length; i++) {
                sum += output[i];

            }
            if ( isPrime(sum) ) {
                primes.add(sum);
            }
            return;
        }

        for (int i=start; i<nums.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                combinate(nums, visited, i+1, r, depth+1, primes, output);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int a) {
        for (int i=2; i<=Math.sqrt(a); i++) {
            if (a%i == 0) return false;
        }
        return true;
    }
}
