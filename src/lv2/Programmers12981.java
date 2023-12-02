package lv2;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Programmers12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int index = 0;
        String previousWords = words[0];
        final HashMap<String, String> wordsHashMap = new HashMap<String, String>();
        wordsHashMap.put(previousWords, previousWords);

        for (int i=1; i< words.length; i++){
            final String previousLastWord = previousWords.substring(previousWords.length() - 1);
            final String tempFirstWord = words[i].substring(0, 1);
            if (wordsHashMap.containsKey(words[i])) {
                index = i;
                System.out.println(index);
                break;
            }

            if (!previousLastWord.equals(tempFirstWord)) {
                index = i;
                break;
            }

            previousWords = words[i];
            wordsHashMap.put(previousWords, previousWords);
        }

        if (index == 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        answer[0] = (index % n) + 1;
        answer[1] = (index / n) + 1;
        return answer;
    }



}
