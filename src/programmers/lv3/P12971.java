package programmers.lv3;

public class P12971 {

    public int solution(int[] sticker) {

        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        // 0 번째를 뽑으면 마지막을 필연적으로 뽑을 수 없게됨.
        // 1 번째를 뽑으면 0 번째를 필연적으로 뽑을 수 없게됨. 둘을 나눠야한다.

        // dp[i+2] = Math.max(sticker[i+2] + dp[i], dp[i+1]);
        // dp[0] , dp[1] 을 정의해야함.

        int[] dp0 = new int[sticker.length];
        int[] dp1 = new int[sticker.length];

        int[] sticker0 = new int[sticker.length];
        int[] sticker1 = new int[sticker.length];

        for (int i=0; i<sticker.length; i++) {
            sticker0[i] = sticker[i];
        }

        for (int i=0; i<sticker.length-1; i++){
            sticker1[i] = sticker[i+1];
        }

        sticker0[sticker.length-1] = 0;
        sticker1[sticker.length-1] = 0;

        // 0 번째를 뽑는 경우 -> 마지막을 못뽑는 경우와 같다.
        dp0[0] = sticker0[0];
        dp0[1] = Math.max(dp0[0], sticker0[1]);
//        dp0[1] = sticker0[0];

        for (int i=0; i<sticker.length-2; i++) {
            dp0[i+2] = Math.max(dp0[i] + sticker0[i+2], dp0[i+1]);
        }

        // 0 번째를 뽑지 않는 경우
        dp1[0] = sticker1[0];
        dp1[1] = Math.max(dp1[0], sticker1[1]);
//        dp1[1] = sticker1[0];
        for (int i=0; i<sticker.length-2; i++) {
            dp1[i+2] = Math.max(dp1[i] + sticker1[i+2], dp1[i+1]);
        }

        return Math.max(dp0[dp0.length-1], dp1[dp1.length-1]);
    }

}
