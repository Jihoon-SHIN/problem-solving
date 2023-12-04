package programmers.lv2;

public class P12953 {
    public int solution(int[] arr) {
        final int firstNum = arr[0];
        final int secondNum = arr[1];

        int answer = lcm(firstNum, secondNum);

        if (arr.length > 2) {
            for (int i=2; i<arr.length; i++){
                answer = lcm(answer, arr[i]);
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }

    private int lcm(int a, int b){
        return (a*b) / gcd(a, b);
    }
}
