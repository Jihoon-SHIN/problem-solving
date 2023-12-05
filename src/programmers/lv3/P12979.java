package programmers.lv3;

public class P12979 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int end = n;
        for (int i=0; i<stations.length; i++){
            final int station = stations[i];
            end = station - w - 1;

            if (end >= start) {
                final int length = end - start + 1;
                if (length <= 2*w + 1) {
                    answer++;
                } else {
                    answer += (int) Math.ceil((double) length / (2*w+1));
                }
            }
            start = station + w + 1;
        }

        end = stations[stations.length-1] + w + 1;
        if (end <= n) {
            final int length = n - end - 1;
            if (length <= 2*w + 1) {
                answer++;
            } else {
                answer += (int) Math.ceil((double) length / (2*w+1));
            }
        }

        return answer;
    }

}
