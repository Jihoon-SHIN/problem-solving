package lv2;


// https://school.programmers.co.kr/learn/courses/30/lessons/17687
public class KakaoNnumber {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String allString = "";
        int index = p-1;
        int number = 0;

        while ( answer.length() < t ) {
            if (allString.length() > index ) {
                answer += allString.substring(index, index+1);
                index += m;
            } else {
                final String nNumber = nTomNumber(number, n);
                allString += nNumber;
                number++;
            }
        }


        return answer;
    }

    private String nTomNumber(int n, int m) {
        return Integer.toString(n, m).toUpperCase();
    }
}
