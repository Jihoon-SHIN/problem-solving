package lv2;

public class Fibonacci {
    public int solution(int n) {
        return (int) (getFibo(n));
    }

    private long getFibo(int n) {
        if ( n <= 1) {
            return n;
        }

        long[] fib = new long[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i=2; i<=n; i++){
            fib[i] = (fib[i-1] + fib[i-2] %  1234567);
        }

        return fib[n];
    }
}
