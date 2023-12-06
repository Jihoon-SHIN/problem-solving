package programmers.lv3;

import java.util.HashMap;
import java.util.Map;

public class P64063 {
    Map<Long, Long> reserved = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i=0; i<room_number.length; i++){
            answer[i] =  vacantRoom(room_number[i]);
        }

        return answer;
    }

    private long vacantRoom(long wantRoom) {
        if (!reserved.containsKey(wantRoom)) {
            reserved.put(wantRoom, wantRoom+1);
            return wantRoom;
        }

        final long emptyRoom = vacantRoom(reserved.get(wantRoom));
        reserved.put(wantRoom, emptyRoom+1);
        return emptyRoom;
    }
}
