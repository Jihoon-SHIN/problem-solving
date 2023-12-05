package programmers.lv3;

import java.util.Arrays;

public class P12987 {
    int answer = -1;
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int index = 0;

        for (int i=0; i<B.length; i++){
            if (B[i] > A[index]) {
                index++;
            }
        }


        return answer;
    }

}
