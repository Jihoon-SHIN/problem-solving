package programmers.lv2;

import java.util.HashMap;
import java.util.HashSet;

public class Programmers132265 {
    public int solution(int[] topping) {
        int answer = 0;

        final HashSet<Integer> toppingSet = new HashSet<Integer>();
        final HashMap<Integer, Integer> toppingMap = new HashMap<>();

        for (int i=0; i < topping.length; i++) {
            final Integer orDefault = toppingMap.getOrDefault(topping[i], 0);
            toppingMap.put(topping[i], orDefault + 1);
        }

        for (int i=0; i < topping.length ; i++) {
            toppingSet.add(topping[i]);
            toppingMap.put(topping[i], toppingMap.get(topping[i]) - 1);

            if (toppingMap.get(topping[i]) == 0) {
                toppingMap.remove(topping[i]);
            }

            if ( toppingSet.size() == toppingMap.size() ) {
                answer++;
            }
        }
        return answer;
    }
}
