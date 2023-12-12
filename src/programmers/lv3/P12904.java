package programmers.lv3;

import java.util.Objects;

public class P12904 {

    public int solution(String s) {
        String[] strList = new String[2*s.length() + 1];
        int index = 0;
        strList[index++] = "#";

        for (int i=0; i<s.length(); i++) {
            final String substring = s.substring(i, i + 1);
            strList[index++] = substring;
            strList[index++] = "#";
        }

        // Manachers's algorithm
        int N = strList.length;
        int c = 0;
        int r = 0;
        int[] palindrome = new int[N];


        for (int i=0; i<N ; i++) {
            int mirr = 2*c -i;
            if ( i <= r) {
                palindrome[i] = Math.min(r-i, palindrome[mirr]);
            }


            int right = i + palindrome[i] + 1;
            int left = i - palindrome[i] - 1;
            while (right >=0 && left >=0 && right < N && Objects.equals(strList[right], strList[left])) {
                palindrome[i] += 1;
                right++;
                left--;
            }

            if (palindrome[i] + i > r) {
                c = i;
                r = palindrome[i] + i;
            }
        }

        int answer = 0;

        for (int i : palindrome) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
}
