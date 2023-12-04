package programmers.lv2;


import java.util.ArrayList;
import java.util.Collections;

public class Programmers155651 {
    public int solution(String[][] book_time) {

        class TimeSlot {
            private final int startTime;
            private final int endTime;

            public TimeSlot(final int startTime, final int endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            public int getStartTime() {
                return startTime;
            }

            public int getEndTime() {
                return endTime;
            }
        }

        int answer = 1;


        final ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
        for (String[] time : book_time) {
            timeSlots.add(new TimeSlot(toMinute(time[0]), toMinute(time[1])));
        }

        timeSlots.sort((o1, o2) -> {
            if (o1.startTime == o2.startTime) return o1.endTime - o2.endTime;
            return o1.startTime - o2.startTime;
        });

        final ArrayList<Integer> endTimeList = new ArrayList<>();


        for (TimeSlot timeSlot : timeSlots) {
            boolean isNoRoom = false;

            Collections.sort(endTimeList);

            for (int i=0; i<endTimeList.size(); i++) {
                final int endTime = endTimeList.get(i) + 10;

                if (timeSlot.getStartTime() >= endTime) {
                    endTimeList.set(i, timeSlot.getEndTime());
                    isNoRoom = true;
                    break;
                }
            }

            if (!isNoRoom) endTimeList.add(timeSlot.getEndTime());
        }


        return endTimeList.size();
    }

    private int toMinute(String time) {
        final String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour*60 + minute;
    }
}

