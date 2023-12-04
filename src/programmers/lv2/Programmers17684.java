package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Programmers17684 {
    String[] basic = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    Map<String, Integer> dict = basicDict();

    public int[] solution(String msg) {
        final ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int beginIndex = 0;
        int endIndex = beginIndex+1;

        while(endIndex <= msg.length()) {
            final String tempInput = msg.substring(beginIndex, endIndex);
            if ( dict.containsKey(tempInput) ) {
                if (endIndex == msg.length()) {
                    arrayList.add(dict.get(msg.substring(beginIndex, endIndex)));
                }
                endIndex++;
            } else {
                String a = msg.substring(beginIndex, endIndex - 1);
                final Integer index = dict.get(msg.substring(beginIndex, endIndex - 1));
                arrayList.add(index);
                dict.put(tempInput, dict.size()+1);
                beginIndex = endIndex -1;
                endIndex = beginIndex + 1;
            }
        }



        int[] answer = new int[arrayList.size()];
        int index = 0;
        for (Integer i : arrayList) {
            answer[index] = i;
            index++;
        }
        return answer;
    }

    private Map<String, Integer> basicDict() {
        Map<String, Integer> dict = new HashMap<>();
        for (int i=0; i < basic.length ; i++) {
            dict.put(basic[i], i+1);
        }
        return dict;
    }
}
